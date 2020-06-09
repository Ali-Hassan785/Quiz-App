package com.example.quizusroomdb.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.quizusroomdb.MOdel.Question;
import com.example.quizusroomdb.MOdel.Subcat;

import java.util.List;

@Dao
public interface QuestionDao {


    @Insert
    void insert(Question question);

    //
//    @Query("Select * from  Subcat")
//    LiveData<List<Subcat>> getcatbyis();
    @Query("Select * from  Question")
    LiveData<List<Question>> getAllquestion();


    @Query("Select * from Question where sub_cat_id = :id")
    LiveData<List<Question>> getquestionbyid(int id);
}
