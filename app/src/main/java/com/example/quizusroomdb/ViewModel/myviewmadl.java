package com.example.quizusroomdb.ViewModel;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Dao;

import com.example.quizusroomdb.DAO.QuestionDao;
import com.example.quizusroomdb.DAO.catgoryDao;
import com.example.quizusroomdb.DAO.cost;
import com.example.quizusroomdb.DAO.subcatDao;
import com.example.quizusroomdb.Database.Appdb;
import com.example.quizusroomdb.MOdel.Catagory;
import com.example.quizusroomdb.MOdel.Question;
import com.example.quizusroomdb.MOdel.Subcat;

import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class myviewmadl extends AndroidViewModel {
    public catgoryDao Dao;
    private Appdb appdb;
    private QuestionDao questionDao;
    private subcatDao subcatDao;
    private LiveData<List<Catagory>> Allcat;
    private LiveData<List<Subcat>> Allsubcat;

    private LiveData<List<Subcat>> Allsubcatbyid;


    private LiveData<List<Question>> Questionbyid;
    private LiveData<List<Question>> Allqestion;

    public myviewmadl(@NonNull Application application) {
        super(application);

        appdb = Appdb.Appdb(application);
        Dao = appdb.myDao();
        Allcat = Dao.getAllcat();

        subcatDao = appdb.subcatDao();
        Allsubcat = subcatDao.getAllsubcat();
        Allsubcatbyid = subcatDao.getbyid(cost.Catid);

        questionDao = appdb.questionDao();
        Allqestion = questionDao.getAllquestion();
        Questionbyid = questionDao.getquestionbyid(cost.SubCatid);
    }

    public void insert(Catagory catagory) {
        new InsertAsyncTask(Dao).execute(catagory);
    }


    public void insertQuestion(Question question) {
        new InsertAsyncTaskQuestioninsert(questionDao).execute(question);
    }

    public void insertsubcat(Subcat catagory) {
        new InsertAsyncTask1(subcatDao).execute(catagory);
    }


    private class InsertAsyncTask extends AsyncTask<Catagory, Void, Void> {

        catgoryDao dao;

        public InsertAsyncTask(catgoryDao dao) {
            this.dao = dao;
        }

        @Override
        protected Void doInBackground(Catagory... catagories) {
            Dao.insert(catagories[0]);
            Log.e("doInBackground: ", "inserted!!");
            return null;


        }
    }

    public LiveData<List<Catagory>> getAllRecods() {
        return Allcat;
    }

    public LiveData<List<Question>> getAllqestion() {
        return Allqestion;
    }

    public LiveData<List<Subcat>> getAllsubcatbyid() {
        return Allsubcatbyid;
    }

    public LiveData<List<Subcat>> getAllsubcat() {
        return Allsubcat;
    }

    public LiveData<List<Question>> Questionbyid() {
        return Questionbyid;
    }

    private class InsertAsyncTask1 extends AsyncTask<Subcat, Void, Void> {
        subcatDao subcatDao;

        public InsertAsyncTask1(subcatDao subcatDao) {
            this.subcatDao = subcatDao;
        }

        @Override
        protected Void doInBackground(Subcat... subcats) {
            subcatDao.insert(subcats[0]);
            Log.e("doInBackground: ", "subcat inserted!!");
            return null;
        }
    }

    private class InsertAsyncTaskQuestioninsert extends AsyncTask<Question, Void, Void> {
        QuestionDao questionDao;

        public InsertAsyncTaskQuestioninsert(QuestionDao questionDao) {
            this.questionDao = questionDao;
        }

        @Override
        protected Void doInBackground(Question... questions) {
            questionDao.insert(questions[0]);
            Log.e(TAG, "doInBackground: Question insert!");
            return null;
        }
    }
}
