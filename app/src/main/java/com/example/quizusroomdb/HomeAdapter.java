package com.example.quizusroomdb;

import android.content.Context;
import android.content.Intent;
import android.icu.lang.UScript;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizusroomdb.DAO.cost;
import com.example.quizusroomdb.MOdel.Catagory;
import com.example.quizusroomdb.MOdel.Subcat;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private LayoutInflater layoutInflater;
    private List<Subcat> subcats1;
    private Context context;

    public HomeAdapter() {
    }

    public HomeAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }


    public void setdata(List<Subcat> catagories) {
        this.subcats1 = catagories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.item_view, parent, false);
        ViewHolder itemVeiwHolder = new ViewHolder(view);
        return itemVeiwHolder;
//        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, final int position) {
        if (subcats1.size() != 0) {
            holder.textView.setText(String.valueOf(subcats1.get(position).getName() + String.valueOf(subcats1.get(position).getId() + "")));
        } else
            Toast.makeText(context, "No record Found", Toast.LENGTH_SHORT).show();


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cost.SubCatid = subcats1.get(position).getId();
                Log.e("onClick: "+"ali", ""+ subcats1.get(position).getId());
                context.startActivity(new Intent(context, QuizActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
//        if (subcats1.size() != 0) {
//            return subcats1.size();
//        } else return 0;


        return subcats1.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.name11);

        }
    }
}
