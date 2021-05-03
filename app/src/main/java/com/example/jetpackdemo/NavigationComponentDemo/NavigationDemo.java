package com.example.jetpackdemo.NavigationComponentDemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.example.jetpackdemo.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationDemo extends AppCompatActivity {
    BottomNavigationView bottom_navigation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_demo);

        bottom_navigation = findViewById(R.id.bottom_navigation);

        bottom_navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                try {
                    switch (item.getTitle().toString()){
                        case "Home":
                            Navigation.findNavController(NavigationDemo.this,R.id.fragment).navigate(R.id.action_secondFragment_to_firstFragment);
                            break;
                        case "Setting":
                            Navigation.findNavController(NavigationDemo.this,R.id.fragment).navigate(R.id.action_firstFragment_to_secondFragment);
                            break;
                    }
                }catch (Exception e){
                    Log.e("**Exception:  ", ": "+e.getMessage() );
                }
                return true;
            }
        });

    }
}