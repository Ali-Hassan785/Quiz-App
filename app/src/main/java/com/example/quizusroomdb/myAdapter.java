package com.example.quizusroomdb;

import android.content.Context;
import android.content.Intent;
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

import java.util.List;

public class myAdapter extends RecyclerView.Adapter<myAdapter.Viewholder> {
    private LayoutInflater layoutInflater;
    private List<Catagory> catagories1;
    private Context context;

    public myAdapter(Context context) {
        this.layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }

    public void setdata(List<Catagory> catagories) {
        this.catagories1 = catagories;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public myAdapter.Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = layoutInflater.inflate(R.layout.item_view, parent, false);
        Viewholder itemVeiwHolder = new Viewholder(view);
        return itemVeiwHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull myAdapter.Viewholder holder, final int position) {
        if (catagories1.size() != 0) {
            holder.textView.setText(String.valueOf(catagories1.get(position).getName() + String.valueOf(catagories1.get(position).getId() + "")));
        } else
            Toast.makeText(context, "No record Found", Toast.LENGTH_SHORT).show();


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, catagories1.get(position).getId() + "", Toast.LENGTH_SHORT).show();
                cost.Catid = catagories1.get(position).getId();
//                Log.e( "Cat id onClick: ",""+cost.Catid );
                context.startActivity(new Intent(context, HomeActivity.class));
            }
        });
    }

    @Override
    public int getItemCount() {
        if (catagories1.size() > 0) {
            return catagories1.size();
        } else return 0;
    }

    public class Viewholder extends RecyclerView.ViewHolder {
        TextView textView;

        public Viewholder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.name11);
        }
    }
}
