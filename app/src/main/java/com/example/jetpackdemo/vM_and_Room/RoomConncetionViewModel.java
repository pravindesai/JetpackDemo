package com.example.jetpackdemo.vM_and_Room;
import android.app.Application;

import com.example.jetpackdemo.vM_and_Room.Model.VmUser;
import com.example.jetpackdemo.vM_and_Room.Model.VmUserDao;
import com.example.jetpackdemo.vM_and_Room.Model.VmUserDatabase;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class RoomConncetionViewModel extends AndroidViewModel {
    private VmUserDao userDatabase;
    LiveData<List<VmUser>> usersLiveData;
    VmUser vmUser;

    public RoomConncetionViewModel(@NonNull Application application) {
        super(application);

        vmUser = new VmUser();
        userDatabase = VmUserDatabase.getInstance(application).vmUserDao();
        usersLiveData = userDatabase.getAllUsers();

    }

    public void insertUser(){
        userDatabase.insertUser(vmUser);
    }

    public VmUser getVmUser() {
        return vmUser;
    }

    public void setVmUser(VmUser vmUser) {
        this.vmUser = vmUser;
    }
}
