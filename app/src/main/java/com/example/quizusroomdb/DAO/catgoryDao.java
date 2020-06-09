package com.example.quizusroomdb.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.quizusroomdb.MOdel.Catagory;

import java.util.List;

@Dao
public interface catgoryDao {
    @Insert
    void insert(Catagory catagory);

    @Query("Select * from  catagory ")
    LiveData<List<Catagory>> getAllcat();
}
