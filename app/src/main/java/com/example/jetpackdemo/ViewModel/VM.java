package com.example.jetpackdemo.ViewModel;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class VM extends ViewModel {
    int i;
    MutableLiveData<Integer> ival;

    ArrayList<Integer> itemList;
    MutableLiveData<List<Integer>> intList;

    public VM() {
        ival = new MutableLiveData<>();

        itemList=  new ArrayList<>();
        intList = new MutableLiveData<>();

        i=0;
        ival.setValue(i);
        intList.setValue(updateList(i));

    }

    MutableLiveData<Integer> getCurrentVal(){
        return ival;
    }

    public void inc(){
        ++i;
        ival.setValue(i);
        intList.setValue(updateList(i));
    }

    public List<Integer> updateList(int i){
        Log.e("**", "updateList: " );
        itemList.add(i);
        return itemList;
    }
}
