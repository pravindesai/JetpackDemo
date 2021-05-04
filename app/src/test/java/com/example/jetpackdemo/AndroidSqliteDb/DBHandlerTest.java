package com.example.jetpackdemo.AndroidSqliteDb;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnit4.class)
class DBHandlerTest {

    @org.junit.jupiter.api.Test
    void insertUser() {
        UserEntity entity = new UserEntity(5,"E","NAGAR");
        assertEquals(5,entity.getId());
    }

    @org.junit.jupiter.api.Test
    void getAllUser() {
        fail();
    }


}