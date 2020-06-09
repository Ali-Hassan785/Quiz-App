package com.example.quizusroomdb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.quizusroomdb.MOdel.Subcat;
import com.example.quizusroomdb.ViewModel.myviewmadl;

import java.util.List;

public class HomeActivity extends AppCompatActivity {

    public myviewmadl getMyvie;
    TextView textView;
    String a = "";

    private static final String TAG = "HomeActivity";

    private RecyclerView recyclerView;
    HomeAdapter homeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        getMyvie = ViewModelProviders.of(this).get(myviewmadl.class);
//        getMyvie.insertsubcat(new Subcat("ALi1", 1));
//        textView = findViewById(R.id.tv1);
        recyclerView = findViewById(R.id.recycler_view1);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//
        homeAdapter = new HomeAdapter(this);
        getMyvie.getAllsubcatbyid().observe(this, new Observer<List<Subcat>>() {
            @Override
            public void onChanged(List<Subcat> subcats) {
                Log.e(TAG, "onChanged: " + subcats.size());

                setData(subcats);
            }
        });
    }

    private void setData(List<Subcat> subcats) {
        homeAdapter.setdata(subcats);
        recyclerView.setAdapter(homeAdapter);

    }
}
