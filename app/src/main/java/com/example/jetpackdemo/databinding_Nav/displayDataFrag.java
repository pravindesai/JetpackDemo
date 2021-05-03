package com.example.jetpackdemo.databinding_Nav;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jetpackdemo.NavigationComponentDemo.secondFragmentArgs;
import com.example.jetpackdemo.R;
import com.example.jetpackdemo.databinding.FragmentDisplayDataBinding;

public class displayDataFrag extends Fragment {
    FragmentDisplayDataBinding displayDataBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //View view = inflater.inflate(R.layout.fragment_display_data, container, false);
        displayDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_display_data, container, false);
        View view = displayDataBinding.getRoot();

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments()!=null){

            displayDataFragArgs args = displayDataFragArgs.fromBundle(getArguments());
            Data data = args.getData();
            displayDataBinding.setData(data);

            Log.e("**Data", "onViewCreated: "+data);
        }
    }
}