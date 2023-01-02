package com.example.expensetracker;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class Utils {
    private static  final String Main_Key="Main Activity Data";
    private static Utils instance;
    private static ArrayList<Expense> list;

    public Utils( ) {
        if(list==null){
            list= new ArrayList<>();
        }
    }

    public static Utils getInstance(){
        if(instance==null){
            instance= new Utils();
            return instance;
        }
        return instance;
    }
    public static void add(Expense e){
        list.add(e);
    }

    public  ArrayList<Expense> getList(){
        return  list;
    }

    public void emptyList(){
        list.clear();

    }
}
