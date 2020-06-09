package com.example.quizusroomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.quizusroomdb.MOdel.Question;
import com.example.quizusroomdb.ViewModel.myviewmadl;

import java.util.List;

public class QuizActivity extends AppCompatActivity {
    myviewmadl myviewmadl;
    TextView textView;
    LiveData<List<Question>> question;
    String a = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        textView = findViewById(R.id.question1);
        myviewmadl = ViewModelProviders.of(this).get(myviewmadl.class);
        myviewmadl.Questionbyid().observe(this, new Observer<List<Question>>() {
            @Override
            public void onChanged(List<Question> questions) {
                Log.e("Qestion size", "onChanged: " + questions.size());
                setData(questions);

            }
        });


//        question.observe(this, new Observer<List<Question>>() {
//            @Override
//            public void onChanged(List<Question> questions) {
//                for (int i = 0; i < questions.size(); i++) {
//                    a += "Question " + questions.get(i).getQestion() + "\n" +
//                            "opt 1" + questions.get(i).getOption1() + "\n" +
//                            "opt 2" + questions.get(i).getOption2() + "\n" +
//                            "opt 3" + questions.get(i).getOption3() + "\n" +
//                            "opt 4" + questions.get(i).getOption4() + "\n" +
//                            "opt ans" + questions.get(i).getAnswer() + "\n" +
//                            "opt subcat" + questions.get(i).getSubcatid() + "\n";
//
//
//                }
//            }
//        });

//    }
}

    private void setData(List<Question> questions) {

        for (int i = 0; i < questions.size(); i++) {
           a+="Question onCreate: "+questions.get(i).getQestion() ;
        }
        textView.setText(a);

    }
}
