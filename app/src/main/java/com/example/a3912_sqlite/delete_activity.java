package com.example.a3912_sqlite;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class delete_activity extends AppCompatActivity {
    EditText rollno;
    Button delete;
    @SuppressLint("MissingInflatedId")
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        rollno = findViewById(R.id.editTextNumber);
        delete =findViewById(R.id.button3);
        MYDBHandler mydb = new MYDBHandler(delete_activity.this);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String roll = rollno.getText().toString();
                Long r =mydb.deleteOneRow(roll);
                if(r == -1){
                    Toast.makeText(delete_activity.this, "Failed", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(delete_activity.this, "deleted Successfully!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
