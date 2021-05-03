package com.example.jetpackdemo.listDataBinding;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jetpackdemo.databinding.TaskLayoutBinding;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

 public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.TaskViewHolder> {
    ArrayList<Task> tasks;

    public RecyclerViewAdapter(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    @NonNull
    @Override
    public TaskViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        TaskLayoutBinding taskLayoutBinding = TaskLayoutBinding.inflate(inflater,parent, false);

        return new TaskViewHolder(taskLayoutBinding);
    }

     @Override
     public void onBindViewHolder(@NonNull TaskViewHolder holder, int position) {
         Task task = tasks.get(position);
         holder.taskLayoutBinding.setTask(task);

         if (!task.isCompleted)
             holder.taskLayoutBinding.statusTv.setTextColor(Color.RED);
         else holder.taskLayoutBinding.statusTv.setTextColor(Color.GREEN);



    }


    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public class TaskViewHolder extends RecyclerView.ViewHolder{
        TaskLayoutBinding taskLayoutBinding;

        public TaskViewHolder(@NonNull TaskLayoutBinding taskLayoutBinding) {
            super(taskLayoutBinding.getRoot());
            this.taskLayoutBinding = taskLayoutBinding;

            taskLayoutBinding.taskItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Task t = tasks.get(getAdapterPosition());
                    t.setCompleted(true);
                    Log.e("**", "onClick: "+ t);
                    notifyDataSetChanged();
                }
            });
        }
    }
}
