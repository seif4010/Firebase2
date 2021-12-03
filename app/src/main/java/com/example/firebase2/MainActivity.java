package com.example.firebase2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edit_position = findViewById(R.id.edit_position);
        final EditText edit_name = findViewById(R.id.edit_name);
        Button submit_btn = findViewById(R.id.submit_btn);
        Button update_btn = findViewById(R.id.update_btn);
        Button delete_btn = findViewById(R.id.delete_btn);

        //Object created to get access to the methods
        DataStudent student = new DataStudent();

        //submit button
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Student stud = new Student(edit_name.getText().toString(), edit_position.getText().toString());
                student.add(stud).addOnSuccessListener( success -> {
                    Toast.makeText(MainActivity.this, "Inserted Successfully!!",Toast.LENGTH_SHORT).show();
                        }).addOnFailureListener(error -> {
                    Toast.makeText(MainActivity.this, "Recorded was not inserted!!"+error.getMessage(), Toast.LENGTH_SHORT).show();
                });
            }
        });

        //update button
        update_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("name", edit_name.getText().toString());
                hashMap.put("position", edit_position.getText().toString());

                student.update("MoIj-wKs_MibyHp5q0I", hashMap).addOnSuccessListener(sucess -> {
                    Toast.makeText(MainActivity.this, "Record was Updated!!!", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(error -> {
                    Toast.makeText(MainActivity.this, "Record not Updated Properly!!!" + error.getMessage(), Toast.LENGTH_SHORT).show();
                });

            }
        });

        //delete button
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                student.delete("MoIj-wKs_MibyHp5q0I").addOnSuccessListener(sucess -> {
                    Toast.makeText(MainActivity.this, "Record was Deleted", Toast.LENGTH_SHORT).show();
                }).addOnFailureListener(error -> Toast.makeText(MainActivity.this, "Record not Deleted Properly!!!" + error.getMessage(), Toast.LENGTH_SHORT).show());

            }
        });
    }

//    //view button
//        view_btn.setOnClickListener(new View.OnClickListener() {
//        @Override
//        public void onClick(View view) {
//            student.delete("MoIj-wKs_MibyHp5q0I").addOnSuccessListener(sucess -> {
//                Toast.makeText(MainActivity.this, "Record was Deleted", Toast.LENGTH_SHORT).show();
//            }).addOnFailureListener(error -> Toast.makeText(MainActivity.this, "Record not Deleted Properly!!!" + error.getMessage(), Toast.LENGTH_SHORT).show());
//        }
//    });
}