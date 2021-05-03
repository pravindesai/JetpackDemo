package com.example.jetpackdemo.listDataBinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;

import com.example.jetpackdemo.R;
import com.example.jetpackdemo.databinding.ActivityListViewDataBindingBinding;

import java.util.ArrayList;

public class ListViewDataBinding extends AppCompatActivity {
    ActivityListViewDataBindingBinding listViewDataBindingBinding;
    RecyclerViewAdapter recyclerViewAdapter;

    ArrayList<Task> tasks;

    //RecyclerView rcView;
    //EditText taskEt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_list_view_data_binding);
        listViewDataBindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_list_view_data_binding);

        init();

        recyclerViewAdapter = new RecyclerViewAdapter(tasks);
        listViewDataBindingBinding.rcView.setLayoutManager(new LinearLayoutManager(this));
        listViewDataBindingBinding.rcView.setAdapter(recyclerViewAdapter);
    }

    private void init() {
        //rcView = findViewById(R.id.rcView);
        //taskEt = findViewById(R.id.taskEt);

        tasks = new ArrayList<>();

        tasks.add(new Task("Task 1",false));
        tasks.add(new Task("Task 2",false));

    }

    public void insertTask(View view) {
        Task t = new Task("", false);
        t.setDesc(
                listViewDataBindingBinding.taskEt.getText().toString()
        );
        t.setCompleted(false);

        tasks.add(t);
        recyclerViewAdapter.notifyDataSetChanged();
    }


}