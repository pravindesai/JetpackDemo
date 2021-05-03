package com.example.jetpackdemo.AndroidSqliteDb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.jetpackdemo.R;

public class SqliteActivity extends AppCompatActivity {
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlite);

        dbHandler = new DBHandler(this);

//        UserEntity entity = new UserEntity(1,"AAA", "pune");
//        UserEntity entity2 = new UserEntity(2,"BBB", "mumbai");
//        dbHandler.insertUser(entity);
//        dbHandler.insertUser(entity2);
//        dbHandler.deleteUser(1);
        for (UserEntity userEntity:dbHandler.getAllUser()){
            Log.e("* "+userEntity.getId(),userEntity.getName()  );
        }
    }
}