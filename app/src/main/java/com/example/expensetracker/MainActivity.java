package com.example.expensetracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    expenseAdapter adapter;
    EditText inputExpense,inputAmount;
    Button add,clear;
    TextView total;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        inputAmount= findViewById(R.id.inputAmount);
        inputExpense= findViewById(R.id.inputExpense);
        clear=findViewById(R.id.clear);
        add=findViewById(R.id.add);
        ArrayList<Expense> list= new ArrayList<>();
        total= findViewById(R.id.total);

        adapter= new expenseAdapter(this,Utils.getInstance().getList());
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);
        recyclerView.setAdapter(adapter);
        add.setOnClickListener(new View.OnClickListener() {
            int tot=0;
            @Override
            public void onClick(View v) {
                if (isEmpty(inputExpense)) {
                    inputExpense.setError("cannot be empty");
                } else if (isEmpty(inputAmount)) {
                    inputAmount.setError("cannot be empty");
                } else {
                    String s = inputExpense.getText().toString();
                    int i = Integer.parseInt(inputAmount.getText().toString());
                    String c = String.valueOf(i);

                    Utils.getInstance().add(new Expense(s, i));
                    adapter.notifyDataSetChanged();
                    inputExpense.setText("");
                    inputAmount.setText("");
                    int size = Utils.getInstance().getList().size();
                    ArrayList<Expense> e = Utils.getInstance().getList();
                    for (int j = 0; j < size; j++) {
                        tot += e.get(j).getAmount();
                        total.setText("Total Rs: " + tot);
                    }
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.getInstance().emptyList();
                adapter.notifyDataSetChanged();
                total.setText("Total Rs: ");
            }
        });

    }
    private boolean isEmpty(EditText etText) {
        return etText.getText().toString().trim().length() == 0;
    }

}