package com.example.jetpackdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.jetpackdemo.paging.Paging_Activity;
import com.example.jetpackdemo.retorfit_demo.Retrofit_Activity;
import com.example.jetpackdemo.mvvm_api.Mvvm_api;
import com.example.jetpackdemo.vM_and_Room.VM_And_Room;
import com.example.jetpackdemo.ViewModel.VMActivity;
import com.example.jetpackdemo.dataBindingDemo.DadaBindingAct;
import com.example.jetpackdemo.NavigationComponentDemo.NavigationDemo;
import com.example.jetpackdemo.databinding_Nav.DBin_Nav;
import com.example.jetpackdemo.listDataBinding.ListViewDataBinding;
import com.example.jetpackdemo.workManager.workmanagerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void openNavigationDemo(View view) {
        startActivity(new Intent(this, NavigationDemo.class));
    }

    public void openDataBindingDemo(View view) {
        startActivity(new Intent(this, DadaBindingAct.class));
    }

    public void openListDataBinding(View view){
        startActivity(new Intent(this, ListViewDataBinding.class));
    }

    public void openDB_Nav(View view) {
        startActivity(new Intent(this, DBin_Nav.class));
    }

    public void VMActDemo(View view) {
        startActivity(new Intent(this, VMActivity.class));
    }

    public void VM_and_Room(View view) {
        startActivity(new Intent(this, VM_And_Room.class));
    }

    public void MVVM_API(View view) {
        startActivity(new Intent(this, Mvvm_api.class));
    }

    public void open_retrofit(View view) {
        startActivity(new Intent(this, Retrofit_Activity.class));
    }

    public void open_Paging(View view) {
        startActivity(new Intent(this, Paging_Activity.class));
    }

    public void open_workManager(View view) {
        startActivity(new Intent(this, workmanagerActivity.class));
    }
}