package com.example.students;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.students.model.Model;
import com.example.students.model.Student;

import java.util.List;

public class StudentsListFragment extends Fragment {
    List<Student> data;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
//        Button newStudentBtn =  (Button) view.findViewById(R.id.newStudentBtn);
//        newStudentBtn.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//
//            }
//        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_students_list, container, false);
        data = Model.instance().getAllStudents();
        RecyclerView list = view.findViewById(R.id.studentlistfrag_list);
        list.setHasFixedSize(true);

        list.setLayoutManager(new LinearLayoutManager(getContext()));
        StudentRecyclerAdapter adapter = new StudentRecyclerAdapter(getLayoutInflater(),data);
        list.setAdapter(adapter);

        adapter.setOnItemClickListener(new StudentRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                Log.d("TAG", "Row was clicked " + pos);
            }
        });

        return view;
    }
}