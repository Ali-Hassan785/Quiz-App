package com.example.quizusroomdb.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.quizusroomdb.MOdel.Catagory;
import com.example.quizusroomdb.MOdel.Subcat;

import java.util.List;
@Dao
public interface subcatDao {
    @Insert
        void insert(Subcat subcat);
//
//    @Query("Select * from  Subcat")
//    LiveData<List<Subcat>> getcatbyis();
    @Query("Select * from  Subcat")
    LiveData<List<Subcat>> getAllsubcat();


    @Query("Select * from Subcat where company_id = :id")
    LiveData<List<Subcat>> getbyid(int id);
}
