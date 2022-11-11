package com.example.a3912_sqlite;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText rollno, name, dept;
    CardView insert,view_data,update,delete;
    MYDBHandler mydb;
    ArrayList<String> stud_names, stud_dept;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rollno = findViewById(R.id.editTextNumber);
        name = findViewById((R.id.editTextTextPersonName));
        dept = findViewById((R.id.editTextTextPersonName2));
        mydb = new MYDBHandler(MainActivity.this);
        stud_names = new ArrayList<>();
        stud_dept = new ArrayList<>();

        insert = findViewById(R.id.register_card);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent register_intent = new Intent(getApplicationContext(),register_student_activity.class);
                register_intent.setAction(Intent.ACTION_SEND);
                register_intent.setType("text/plain");
                startActivity(register_intent);
            }
        });
        view_data = findViewById(R.id.view_card);
        view_data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent view_intent = new Intent(getApplicationContext(),view_data_activity.class);
                view_intent.setAction(Intent.ACTION_SEND);
                view_intent.setType("text/plain");
                startActivity(view_intent);

            }
        });
        update = findViewById(R.id.update_card);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent update_intent = new Intent(getApplicationContext(),Update_details.class);
                update_intent.setAction(Intent.ACTION_SEND);
                update_intent.setType("text/plain");
                startActivity(update_intent);

            }
        });
        delete = findViewById(R.id.delete_card);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent delete_intent = new Intent(getApplicationContext(),delete_activity.class);
                delete_intent.setAction(Intent.ACTION_SEND);
                delete_intent.setType("text/plain");
                startActivity(delete_intent);

            }
        });

        //storeDataInArrays();

    }

}
