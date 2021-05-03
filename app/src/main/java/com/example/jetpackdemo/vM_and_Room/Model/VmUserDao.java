package com.example.jetpackdemo.vM_and_Room.Model;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface VmUserDao {
    @Insert
    void insertUser(VmUser user);

    @Query("select * from VmUser")
    LiveData<List<VmUser>> getAllUsers();

    @Query("select * from VmUser")
    List<VmUser> getAllUser();
}
