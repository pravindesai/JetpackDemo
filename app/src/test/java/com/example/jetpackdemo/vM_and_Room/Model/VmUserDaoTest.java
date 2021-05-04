package com.example.jetpackdemo.vM_and_Room.Model;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import java.util.List;
import androidx.room.Room;
import androidx.test.InstrumentationRegistry;
import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(AndroidJUnit4.class)
class VmUserDaoTest {

    public VmUserDatabase database;
    public VmUserDao dao;

    @Before
    public void setUp(){
        database = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext()
                ,VmUserDatabase.class)
                .allowMainThreadQueries()
                .build();

        dao = database.vmUserDao();
    }

    @Test
    public void insertUser() {

        VmUser user = new VmUser("TEST_NAME","TEST_ADDRESS2");
        //dao.insertUser(user);

//        List<VmUser> vmUsers = dao.getAllUser();
//        assertTrue(vmUsers.contains(user));
    }

    @Test
    void getAllUser() {
        //List<VmUser> vmUsers = dao.getAllUser();
    }

    @After
    public void close(){
        database.close();
    }
}