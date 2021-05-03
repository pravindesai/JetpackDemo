package com.example.jetpackdemo.vM_and_Room;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.jetpackdemo.R;
import com.example.jetpackdemo.vM_and_Room.Model.VmUser;
import com.example.jetpackdemo.vM_and_Room.Model.VmUserDatabase;
import com.example.jetpackdemo.databinding.ActivityVMAndRoomBinding;

import java.util.ArrayList;
import java.util.List;

public class VM_And_Room extends AppCompatActivity {
    ActivityVMAndRoomBinding vmAndRoomBinding;

    RoomConncetionViewModel myViewModel;
    RecyclerView rcView;
    rcAdapter adapter;
    ArrayList<VmUser> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        vmAndRoomBinding = DataBindingUtil.setContentView(this, R.layout.activity_v_m__and__room);
        myViewModel = new ViewModelProvider(this).get(RoomConncetionViewModel.class);

        init();
        vmAndRoomBinding.setViewmodel(myViewModel);

        myViewModel.usersLiveData.observe(this, new Observer<List<VmUser>>() {
            @Override
            public void onChanged(List<VmUser> vmUsers) {
                if (vmUsers.size()>0){
                    if (vmUsers.size() != users.size()){
                        VmUser u = ((ArrayList<VmUser>)vmUsers).get(vmUsers.size()-1);
                        users.add(u);
                        adapter.notifyDataSetChanged();
                        Log.e("**", "User Added : "+vmUsers );
                    }
                }
            }
        });

    }

    private void init(){
        users = new ArrayList<>();
        users.addAll(VmUserDatabase.getInstance(this).vmUserDao().getAllUser());

        rcView = vmAndRoomBinding.rcView;
        rcView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new rcAdapter(users);
        rcView.setAdapter(adapter);

    }
}