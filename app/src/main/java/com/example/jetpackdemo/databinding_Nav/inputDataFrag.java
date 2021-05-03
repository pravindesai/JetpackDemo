package com.example.jetpackdemo.databinding_Nav;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.jetpackdemo.NavigationComponentDemo.firstFragmentDirections;
import com.example.jetpackdemo.R;
import com.example.jetpackdemo.databinding.FragmentInputDataBinding;

public class inputDataFrag extends Fragment {
    Button submit_btn;
    Data data;
    FragmentInputDataBinding inputDataBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        //View view =  inflater.inflate(R.layout.fragment_input_data, container, false);
        inputDataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_input_data, container, false);
        View view = inputDataBinding.getRoot();

        submit_btn = view.findViewById(R.id.submit_btn);
        data = new Data();
        inputDataBinding.setData(data);

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputDataFragDirections.ActionInputDataFragToDisplayDataFrag dataFrag
                        = inputDataFragDirections.actionInputDataFragToDisplayDataFrag(data);
                //dataFrag.setData(data);
                Navigation.findNavController(view).navigate(dataFrag);
            }
        });
        return view;

    }

}