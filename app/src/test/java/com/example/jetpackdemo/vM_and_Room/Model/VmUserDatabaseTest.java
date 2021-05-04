package com.example.jetpackdemo.vM_and_Room.Model;

import com.example.jetpackdemo.BaseClasses.JetpackApplication;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

@RunWith(JUnit4.class)
class VmUserDatabaseTest extends TestCase{
    private VmUserDatabase database;
    private VmUserDao dao;

    @Before
    public void setUp() throws Exception {
        super.setUp();
        database = Room.inMemoryDatabaseBuilder(ApplicationProvider.getApplicationContext(),
                VmUserDatabase.class).build();
        dao = database.vmUserDao();
    }


    @org.junit.jupiter.api.Test
    public void testFunctio() throws Exception {
        super.setUp();

        VmUser user = new VmUser("TEST_NAME","TEST_ADDRESS");
        dao.insertUser(user);

        List <VmUser> users=dao.getAllUser();

        assertTrue(users.contains(user));
    }

    @After
    public void close() throws Exception {
        super.setUp();

        database.close();

    }


}