package com.example.a3912_sqlite;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Update_details extends AppCompatActivity {
    MYDBHandler mydb;

    EditText rollno, name, dept;
    Spinner spin ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_details);
        rollno = findViewById(R.id.editTextNumber);
        name = findViewById((R.id.editTextTextPersonName));
        name.setVisibility(View.INVISIBLE);
        dept = findViewById((R.id.editTextTextPersonName2));
        dept.setVisibility(View.INVISIBLE);
        spin = findViewById(R.id.spinner);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) Button update = findViewById(R.id.button3);


            spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    if(spin.getSelectedItem().toString().equals("Name")){
                        dept.setVisibility(View.INVISIBLE);
                        name.setVisibility(View.VISIBLE);
                        update.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                mydb = new MYDBHandler(Update_details.this);

                                String roll = rollno.getText().toString();
                                String uname = name.getText().toString();
                                Long r =mydb.Update_name(roll,uname);
                                if(r == -1){
                                    Toast.makeText(Update_details.this, "Failed", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(Update_details.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
                                }
                                name.setVisibility(View.INVISIBLE);



                            }
                        });
                    }
                    if(spin.getSelectedItem().toString().equals("Department")){
                        name.setVisibility(View.INVISIBLE);
                        dept.setVisibility(View.VISIBLE);
                        update.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                mydb = new MYDBHandler(Update_details.this);

                                String roll = rollno.getText().toString();
                                String d = dept.getText().toString();
                                Long r =mydb.Update_dept(roll,d);
                                if(r == -1){
                                    Toast.makeText(Update_details.this, "Failed", Toast.LENGTH_SHORT).show();
                                }else {
                                    Toast.makeText(Update_details.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
                                }

                            }
                        });


                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });








    }
}
