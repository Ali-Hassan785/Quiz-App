package com.example.quizusroomdb.MOdel;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;


@Entity(foreignKeys = @ForeignKey(entity = Catagory.class,
        parentColumns = "Id",
        childColumns = "company_id",
        onDelete = ForeignKey.NO_ACTION),tableName = "Subcat")
public class Subcat {
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

    public int getCompany_id() {
        return company_id;
    }

    public void setCompany_id(int company_id) {
        this.company_id = company_id;
    }

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int Id;
    @ColumnInfo(name = "name")
    @NonNull
    private String name;
    @NonNull
    @ColumnInfo(name = "company_id")
    private int company_id;

    public Subcat(@NonNull String name, int company_id) {

        this.name = name;
        this.company_id = company_id;
    }
}
