package com.example.jetpackdemo.dataBindingDemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.example.jetpackdemo.R;
import com.example.jetpackdemo.databinding.ActivityDadaBindingBinding;

public class DadaBindingAct extends AppCompatActivity {
    ActivityDadaBindingBinding actDataBinding;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_dada_binding);

        actDataBinding = DataBindingUtil.setContentView(this,R.layout.activity_dada_binding);
        user = new User(1, "AAAA", "Pune");
        actDataBinding.setCurrentUser(user);

    }

    public void UpdateUser(View view) {

        actDataBinding.setCurrentUser(user);
    }
}