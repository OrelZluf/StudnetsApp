package com.example.students;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.students.model.Model;
import com.example.students.model.Student;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);


        Button saveBtn = findViewById(R.id.addstudent_save_btn);
        Button cancelBtn = findViewById(R.id.addstudent_cancell_btn);

        saveBtn.setOnClickListener(view -> {
            EditText nameEt = findViewById(R.id.addstudent_name_et);
            EditText idEt = findViewById(R.id.addstudent_id_et);
            EditText phoneEt = findViewById(R.id.student_phone_et);
            EditText addressEt = findViewById(R.id.student_address_et);
            CheckBox checkBx = findViewById(R.id.checkBox);

            Model.instance().addStudent(new Student(idEt.getText().toString(),
                                                    nameEt.getText().toString(),
                                                    phoneEt.getText().toString(),
                                                    addressEt.getText().toString(),
                                                    checkBx.isChecked()));
            finish();
        });

        cancelBtn.setOnClickListener(view -> finish());
    }
}