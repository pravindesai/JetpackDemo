package com.example.jetpackdemo.vM_and_Room.Model;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {VmUser.class}, version = 1, exportSchema = false)
public abstract class VmUserDatabase extends RoomDatabase {
    static VmUserDatabase myDb = null;
    public abstract VmUserDao vmUserDao();
    public static String DB_NAME = "MyVmDB";

    public static VmUserDatabase getInstance(Context context){
        if (myDb == null){
            myDb = Room.databaseBuilder(context,VmUserDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return myDb;
    }
}
