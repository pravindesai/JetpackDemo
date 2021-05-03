package com.example.jetpackdemo.vM_and_Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jetpackdemo.R;
import com.example.jetpackdemo.vM_and_Room.Model.VmUser;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class rcAdapter extends RecyclerView.Adapter<rcAdapter.MyViewHolder>{
    ArrayList<VmUser> vmUserArrayList;

    public rcAdapter(ArrayList<VmUser> vmUserArrayList) {
        this.vmUserArrayList = vmUserArrayList;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem= layoutInflater.inflate(R.layout.recycler_view_row, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        VmUser vmUser = vmUserArrayList.get(position);
        holder.Name.setText(vmUser.getName());
        holder.Address.setText(vmUser.getAddress());
    }

    @Override
    public int getItemCount() {
        return vmUserArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView Name,Address;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.Name=itemView.findViewById(R.id.Name);
            this.Address=itemView.findViewById(R.id.Address);

        }
    }
}
