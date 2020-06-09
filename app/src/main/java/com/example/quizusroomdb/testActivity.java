package com.example.quizusroomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.quizusroomdb.MOdel.Subcat;
import com.example.quizusroomdb.ViewModel.myviewmadl;

import java.util.List;

public class testActivity extends AppCompatActivity {

    myviewmadl myviewmadl;
    String a = "";
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        textView = findViewById(R.id.tvv);
        myviewmadl = ViewModelProviders.of(this).get(myviewmadl.class);
        myviewmadl.getAllsubcat().observe(this, new Observer<List<Subcat>>() {
            @Override
            public void onChanged(List<Subcat> subcats) {
                Log.e("jjjj","onChanged: "+subcats.size() );
                for (int i = 0; i < subcats.size(); i++) {
                    a += subcats.get(i).getName() + "  " + subcats.get(i).getCompany_id();
                    Log.e( " ","i am onChanged: "+a );

                }
            }
        });
        textView.setText(a);
    }
}
