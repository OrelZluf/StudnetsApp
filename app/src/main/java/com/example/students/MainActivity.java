package com.example.students;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;

import com.example.students.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    StudentsListFragment frag1;
    StudentsListFragment frag4;
    Fragment inDisplay;
    FragmentManager manager;
    FragmentTransaction tran;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getSupportFragmentManager();
        tran = manager.beginTransaction();

        frag1 = new StudentsListFragment();
        displayFragment(frag1);
    }

    public void addFrag(int fragId, Fragment frag){
        tran.add(fragId, frag);
    }

    private void displayFragment(Fragment frag) {
        tran.remove(frag);
        tran.add(R.id.main_frag_container, frag);

        if (inDisplay != null) tran.remove(inDisplay);
        tran.addToBackStack("TAG");
        tran.commit();
        inDisplay = frag;
    }
}