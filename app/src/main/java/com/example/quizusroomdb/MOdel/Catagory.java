package com.example.quizusroomdb.MOdel;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Catagory")
public class Catagory {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int Id;
    @ColumnInfo(name = "name")
    @NonNull
    private String name;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    public Catagory(int id, @NonNull String name) {
        Id = id;
        this.name = name;
    }

    public Catagory(@NonNull String name) {
        this.name = name;
    }

}
