package com.example.expensetracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class expenseAdapter extends RecyclerView.Adapter<expenseAdapter.ViewHolder> {
    private Context context;
    private ArrayList <Expense> list;

    public expenseAdapter(Context context,ArrayList<Expense> arrayList)
    {
        this.context = context;
        list= arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.reclayout,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.expenseDesign.setText(list.get(position).getExpense());
        holder.amountDesign.setText(Integer.toString(list.get(position).getAmount()));

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    protected class ViewHolder extends RecyclerView.ViewHolder{
        TextView expenseDesign,amountDesign;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            expenseDesign=itemView.findViewById(R.id.expenseDesign);
            amountDesign=itemView.findViewById(R.id.amountDesign);

        }
    }
}
