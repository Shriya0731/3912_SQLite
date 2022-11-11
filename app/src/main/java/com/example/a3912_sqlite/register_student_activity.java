package com.example.a3912_sqlite;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class register_student_activity extends AppCompatActivity {
    EditText rollno, name, dept;
    MYDBHandler mydb;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_activity);
        Button insert = findViewById(R.id.button);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollno = findViewById(R.id.editTextNumber);
                name = findViewById((R.id.editTextTextPersonName));
                dept = findViewById((R.id.editTextTextPersonName2));
                mydb = new MYDBHandler(register_student_activity.this);


                int roll = Integer.parseInt(rollno.getText().toString());
                String uname = name.getText().toString();
                String udept = dept.getText().toString();
                if(uname==null){
                    System.out.println("name null");
                }
                if(udept==null){
                    System.out.println("dept null");
                }
                boolean r =mydb.insert_data(roll,uname,udept);
                if (r){
                    Toast.makeText(register_student_activity.this, "Added successfully!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(register_student_activity.this, "Error!",Toast.LENGTH_SHORT).show();

                }

            }
        });

    }

}
