package com.example.students;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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

import java.net.InetSocketAddress;
import java.util.List;

public class StudentsListFragment extends Fragment {
    List<Student> data;
    RecyclerView list;
    StudentRecyclerAdapter adapter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        Button newStudentBtn =  (Button) view.findViewById(R.id.newStudentBtn);
        data = Model.instance().getAllStudents();
        newStudentBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddStudentActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_students_list, container, false);
        list = view.findViewById(R.id.studentlistfrag_list);


//        adapter = new StudentRecyclerAdapter(getLayoutInflater(),data);
//        list.setAdapter(adapter);

//        adapter.setOnItemClickListener(new StudentRecyclerAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(int pos) {
//                Log.d("TAG", "Row was clicked " + pos);
//
////                Intent intent = new Intent(getContext(), DetailsActivity.class);
////                startActivity(intent);
//            }
//        });

        return view;
    }

    @Override
    public void onStart() {
        data = Model.instance().getAllStudents();

        list.setHasFixedSize(true);
        list.setLayoutManager(new LinearLayoutManager(getContext()));

        adapter = new StudentRecyclerAdapter(getLayoutInflater(),data);
        list.setAdapter(adapter);

        adapter.setOnItemClickListener(new StudentRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                Log.d("TAG", "Row was clicked " + pos);

                Intent intent = new Intent(getContext(), DetailsActivity.class);
                Bundle params = new Bundle();

                params.putInt("pos", pos);
                intent.putExtras(params);

                startActivity(intent);
            }
        });

        super.onStart();
    }

    //    @Override
//    public void onResume() {
    //      data = Model.instance().getAllStudents();
//
//        adapter = new StudentRecyclerAdapter(getLayoutInflater(),data);
//        list.setAdapter(adapter);
//        super.onResume();
//    }

}