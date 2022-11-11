package com.example.a3912_sqlite;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class view_data_activity extends AppCompatActivity {
    MYDBHandler mydb;
    ArrayList<String> stud_names, stud_dept,stud_roll;
    CustomAdapter customAdapter;
    RecyclerView recyclerView;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_activity);
        recyclerView = findViewById(R.id.recycler);
        mydb = new MYDBHandler(view_data_activity.this);
        stud_names = new ArrayList<>();
        stud_dept = new ArrayList<>();
        stud_roll = new ArrayList<>();

        storeDataInArrays();
        customAdapter = new CustomAdapter(view_data_activity.this,view_data_activity.this,stud_names,stud_dept,stud_roll);

        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(view_data_activity.this));

    }

    void storeDataInArrays() {

        Cursor cursor = mydb.readAllData();
        if(cursor.getCount() == 0){

        }else{
            while (cursor.moveToNext()){
                stud_roll.add(cursor.getString(0));
                stud_names.add(cursor.getString(1));
                stud_dept.add(cursor.getString(2));

            }

        }
    }
}
