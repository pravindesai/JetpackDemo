package com.example.jetpackdemo.LifeCycleAwareComponent;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class LifeCycleAwareActivityObserver implements LifecycleObserver {
    public static String TAG="*OBSEREVER";

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void observerOnCreate(){
        Log.e(TAG, "observerOnCreate: " );
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void observerOnDestroy(){
        Log.e(TAG, "observerOnDestroy " );
    }





}
