package com.example.jetpackdemo.LifeCycleAwareComponent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.jetpackdemo.R;

public class LifeCycleAwareActivity extends AppCompatActivity {
    private static final String TAG = "*LifeCycleAwareActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_life_cycle_aware);

        Log.e(TAG, "onCreate: Activity" );
        getLifecycle().addObserver(new LifeCycleAwareActivityObserver());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: Activty" );
    }
}