package com.example.quizusroomdb.Database;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.quizusroomdb.DAO.QuestionDao;
import com.example.quizusroomdb.DAO.catgoryDao;
import com.example.quizusroomdb.DAO.subcatDao;
import com.example.quizusroomdb.MOdel.Catagory;
import com.example.quizusroomdb.MOdel.Question;
import com.example.quizusroomdb.MOdel.Subcat;

@Database(entities = {Catagory.class, Subcat.class, Question.class}, exportSchema = false, version = 5)
public abstract class Appdb extends RoomDatabase {
    public abstract catgoryDao myDao();

    public abstract subcatDao subcatDao();

    public abstract QuestionDao questionDao();

    private static volatile Appdb appDataBaseinstance;

    public static Appdb Appdb(
            final Context context) {
        if (appDataBaseinstance == null) {
            synchronized (Appdb.class) {
                if (appDataBaseinstance == null) {
                    appDataBaseinstance = Room.databaseBuilder(context.getApplicationContext(),
                            Appdb.class, "db_my").addCallback(callback).fallbackToDestructiveMigration().build();
                }
            }
        }
        return appDataBaseinstance;
    }

    static RoomDatabase.Callback callback = new Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);


            Log.i("MainActivity", "Oncreate Invoked!!!");


            new Thread(new Runnable() {
                @Override
                public void run() {
                    appDataBaseinstance.myDao().insert(new Catagory("Science"));
                    appDataBaseinstance.myDao().insert(new Catagory("Art"));
                    appDataBaseinstance.myDao().insert(new Catagory("Sports"));
                    appDataBaseinstance.subcatDao().insert(new Subcat("Math", 1));
                    appDataBaseinstance.subcatDao().insert(new Subcat("Physics", 1));
                    appDataBaseinstance.subcatDao().insert(new Subcat("Chemistry", 1));
                    appDataBaseinstance.subcatDao().insert(new Subcat("art1", 2));
                    appDataBaseinstance.subcatDao().insert(new Subcat("art2", 2));
                    appDataBaseinstance.subcatDao().insert(new Subcat("art3", 2));
                    appDataBaseinstance.questionDao().insert(new Question("2+2=", "1", "2", "3", "4", 4, 1));
                    appDataBaseinstance.questionDao().insert(new Question("3+3=", "1", "2", "3", "4", 4, 1));


                    appDataBaseinstance.questionDao().insert(new Question("Physics1", "1", "2", "3", "4", 4, 2));
                    appDataBaseinstance.questionDao(). insert(new Question("Physics", "1", "2", "3", "4", 4, 2));

                    appDataBaseinstance.questionDao().insert(new Question("Chemistry", "1", "2", "3", "4", 4, 3));
                    appDataBaseinstance.questionDao().insert(new Question("chemistry", "1", "2", "3", "4", 4, 3));
                    appDataBaseinstance.questionDao().insert(new Question("art", "1", "2", "3", "4", 4, 4));

                }
            }).start();


        }

        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
            Log.i("MainActivity", "Onopen Invoked!!!");

        }
    };
}


