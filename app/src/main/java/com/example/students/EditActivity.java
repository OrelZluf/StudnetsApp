package com.example.students;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.students.model.Model;
import com.example.students.model.Student;

public class EditActivity extends AppCompatActivity {
    EditText nameEt;
    EditText idEt;
    EditText phoneEt;
    EditText addressEt;
    CheckBox checkBx;
    int pos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        Bundle b = getIntent().getExtras();
        pos = -1;
        if(b != null)
            pos = b.getInt("pos");

        Student currStudent = Model.instance().getAllStudents().get(pos);

        nameEt = findViewById(R.id.student_name_et);
        idEt = findViewById(R.id.student_id_et);
        phoneEt = findViewById(R.id.student_phone_et);
        addressEt = findViewById(R.id.student_address_et);
        checkBx = findViewById(R.id.checkBox);

        nameEt.setText(currStudent.name);
        idEt.setText(currStudent.id);
        phoneEt.setText(currStudent.phoneNumber);
        addressEt.setText(currStudent.address);
        checkBx.setChecked(currStudent.checkStatus);


        Button saveEditBtn = findViewById(R.id.addstudent_save_btn);
        Button deleteBtn = findViewById(R.id.addstudent_delete_btn);
        Button cancelBtn = findViewById(R.id.addstudent_cancell_btn);

        deleteBtn.setOnClickListener(view -> {
            Model.instance().deleteStudent(pos);
            finish();
        });

        saveEditBtn.setOnClickListener(view -> {
            EditText nameEt = findViewById(R.id.student_name_et);
            EditText idEt = findViewById(R.id.student_id_et);
            EditText phoneEt = findViewById(R.id.student_phone_et);
            EditText addressEt = findViewById(R.id.student_address_et);
            CheckBox checkBx = findViewById(R.id.checkBox);

            Model.instance().editStudent(pos, new Student(idEt.getText().toString(),
                    nameEt.getText().toString(),
                    phoneEt.getText().toString(),
                    addressEt.getText().toString(),
                    checkBx.isChecked()));
            finish();
        });

        cancelBtn.setOnClickListener(view -> finish());

    }
}