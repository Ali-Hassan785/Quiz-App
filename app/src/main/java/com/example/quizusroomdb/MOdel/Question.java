package com.example.quizusroomdb.MOdel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(foreignKeys = @ForeignKey(entity = Subcat.class,
        parentColumns = "Id",
        childColumns = "sub_cat_id",
        onDelete = ForeignKey.NO_ACTION), tableName = "Question")
public class Question {
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo(name = "Qestion")
    private String Qestion;
    @ColumnInfo(name = "optioin1")
    private String option1;
    @ColumnInfo(name = "optioin2")
    private String option2;
    @ColumnInfo(name = "optioin3")
    private String option3;
    @ColumnInfo(name = "optioin4")
    private String option4;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ColumnInfo(name = "answer")
    private int Answer;
    @ColumnInfo(name = "sub_cat_id")
    private int subcatid;

    public Question(String qestion, String option1, String option2, String option3, String option4, int answer, int subcatid) {
        Qestion = qestion;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        Answer = answer;
        this.subcatid = subcatid;
    }

    public Question() {
    }

    public String getQestion() {
        return Qestion;
    }

    public void setQestion(String qestion) {
        Qestion = qestion;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public int getAnswer() {
        return Answer;
    }

    public void setAnswer(int answer) {
        Answer = answer;
    }

    public int getSubcatid() {
        return subcatid;
    }

    public void setSubcatid(int subcatid) {
        this.subcatid = subcatid;
    }
}

