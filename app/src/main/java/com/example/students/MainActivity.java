package com.example.students;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView studentsListRV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Student> studentsList = new ArrayList<>();
        // add simulation data
        studentsList.add(new Student("123456",
                "Orel",
                "bla", "0505255441", "Beit arif", true));
        studentsList.add(new Student("123",
                "Dor",
                "bla","0505255441", "Beit arif", true));
        studentsList.add(new Student("1257",
                "Miki",
                "bla","0505255441", "Beit arif", true));

        studentsListRV
                = (RecyclerView)findViewById(
                R.id.recyclerView);

    }
}