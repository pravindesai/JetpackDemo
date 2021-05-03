package com.example.jetpackdemo.listDataBinding;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.jetpackdemo.R;
import com.example.jetpackdemo.databinding.TaskLayoutBinding;

import java.util.ArrayList;

import androidx.databinding.DataBindingUtil;

public class TaskListAdapter extends BaseAdapter {
    private Context context;
    ArrayList<Task> tasks;
    public TaskListAdapter(ListViewDataBinding listViewDataBinding, ArrayList<Task> tasks) {
        context = listViewDataBinding;
        this.tasks = tasks;
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.task_layout,null);

        TaskLayoutBinding taskLayoutBinding = DataBindingUtil.bind(convertView);
        //convertView.setTag(taskLayoutBinding);

        taskLayoutBinding.setTask(tasks.get(position));
        return taskLayoutBinding.getRoot();
    }

    public void setCompleted(){

    }
}
