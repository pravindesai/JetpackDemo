package com.example.jetpackdemo.mvvm_api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.jetpackdemo.R;
import com.example.jetpackdemo.databinding.ActivityMvvmApiBinding;
import com.example.jetpackdemo.mvvm_api.api.single_api_response.Data;
import com.example.jetpackdemo.mvvm_api.api.single_api_response.SingleUser;

public class Mvvm_api extends AppCompatActivity {
    APiViewModel viewModel;
    ActivityMvvmApiBinding mvvmApiBinding;
    Data userData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
        //setContentView(R.layout.activity_mvvm_api);

        // _varname   mVarname

        viewModel.getNextUser().observe(this, new Observer<SingleUser>() {
            @Override
            public void onChanged(SingleUser singleUser) {
                userData = singleUser.getData();
                mvvmApiBinding.setData(userData);
            }
        });

        viewModel.getPreviousUser().observe(this, new Observer<SingleUser>() {
            @Override
            public void onChanged(SingleUser singleUser) {
                userData = singleUser.getData();
            }
        });


    }


    private void init() {
        mvvmApiBinding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_api);
        viewModel = new ViewModelProvider(this).get(APiViewModel.class);
        mvvmApiBinding.setViewModel(viewModel);

        userData = new Data("R.drawable.ic_baseline_home_24","mail","fname",0,"lname");


    }
}

/*
                Log.e("*NEXT USER: ", "*******************************"+singleUser.getData().getId() );
                Log.e("*User Observed: ", "onChanged: "+singleUser.getData().getFirstName() );
                Log.e("*User Observed: ", "onChanged: "+singleUser.getData().getLastName() );
*/