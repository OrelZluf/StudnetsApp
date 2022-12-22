package com.example.students;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.students.model.Model;
import com.example.students.model.Student;

public class DetailsActivity extends AppCompatActivity {
    TextView nameEt;
    TextView idEt;
    TextView phoneEt;
    TextView addressEt;
    CheckBox checkBx;
    int pos;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

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

        Button editButton = findViewById(R.id.edit_btn);

        editButton.setOnClickListener(view -> {
            Intent intent = new Intent(this, EditActivity.class);
            Bundle params = new Bundle();

            params.putInt("pos", pos);
            intent.putExtras(params);

            startActivity(intent);
            finish();
        });

    }
}