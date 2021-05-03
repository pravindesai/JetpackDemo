package com.example.jetpackdemo.AndroidSqliteDb;

import android.app.DownloadManager;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {
    private static final int version = 1;
    private static String dbName = "MyDB";
    private static String TABLE_NAME = "USER_TABLE";

    public DBHandler(@Nullable Context context) {
        super(context, dbName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String Create_User_Table =  "CREATE TABLE "+TABLE_NAME+" (id INTEGER PRIMARY KEY , name TEXT, address TEXT)";
        db.execSQL(Create_User_Table);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    void insertUser(UserEntity row){

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues row_values = new ContentValues();
        row_values.put("id", row.getId());
        row_values.put("name", row.getName());
        row_values.put("address", row.getAddress());

        db.insert(TABLE_NAME, null, row_values);
        db.close();
        Log.e("USER Inserted", " "+row );
    }

    List<UserEntity> getAllUser(){
        List<UserEntity> userList = new ArrayList<>();
        String QUERY ="select * from "+TABLE_NAME;

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(QUERY, null);
        if (cursor.moveToFirst()){
            do {
                UserEntity entity = new UserEntity();
                entity.setId(cursor.getInt(0));
                entity.setName(cursor.getString(1));
                entity.setAddress(cursor.getString(2));
                userList.add(entity);

            }while (cursor.moveToNext());
        }
        return userList;
    }

    public void deleteUser(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NAME, "id" + " = ?",
                new String[] { String.valueOf(id) });
        db.close();
        Log.e("*DELETED ", "ID "+id );
    }

    int updateUser(UserEntity entity){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("name", entity.getName());
        values.put("address", entity.getAddress());

        return db.update(TABLE_NAME, values, "id =?",
                new String[]{String.valueOf(entity.getId())});
    }
}
