package com.example.quizusroomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.quizusroomdb.MOdel.Catagory;
import com.example.quizusroomdb.MOdel.Question;
import com.example.quizusroomdb.MOdel.Subcat;
import com.example.quizusroomdb.ViewModel.myviewmadl;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private LiveData<List<Catagory>> mcat;
    private static final String TAG = "MainActivity";
    private myviewmadl getMyvie;
    RecyclerView recyclerView;
    myAdapter myAdapter;
//    List<Catagory> catagories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recycler_view);
        getMyvie = ViewModelProviders.of(this).get(myviewmadl.class);


//        getMyvie.insert(new Catagory("ALi"));
//        getMyvie.insert(new Catagory("ALi"));



        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new myAdapter(this);

        getMyvie.getAllRecods().observe(this, new Observer<List<Catagory>>() {


            @Override
            public void onChanged(List<Catagory> catagories) {


                Log.e(TAG, "onChanged: " + catagories.size());
                setData(catagories);

//                this.catagories1 = catagories;
//                Log.e("onChanged: ", catagories.size() + "");
//                for (int i = 0; i < catagories.size(); i++) {
//                    Log.e(TAG, "onChanged: " + catagories.get(i).getName());
//                }
            }

        });
//        Log.e(TAG, "onCreate: " + mcat.size());
        recyclerView.setAdapter(myAdapter);

    }

    private void setData(List<Catagory> catagories) {
        myAdapter.setdata(catagories);

    }
}
