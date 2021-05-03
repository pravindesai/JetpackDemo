package com.example.jetpackdemo.retorfit_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.jetpackdemo.R;
import com.example.jetpackdemo.databinding.ActivityRetrofitBinding;
import com.example.jetpackdemo.retorfit_demo.retrofit.postResponse.PostResponse;
import com.example.jetpackdemo.retorfit_demo.retrofit.postResponse.PostResponseItem;

public class Retrofit_Activity extends AppCompatActivity {
    RetrofitViewModel viewModel;
    ActivityRetrofitBinding activityRetrofitBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_retrofit_);
        activityRetrofitBinding = DataBindingUtil.setContentView(this, R.layout.activity_retrofit_);
        init();

        viewModel.getPosts().observe(this, new Observer<PostResponse>() {
            @Override
            public void onChanged(PostResponse postResponseItems) {
                String TAG = "*";
                for (PostResponseItem item : postResponseItems){
                    Log.e(TAG, ""+item.getId());
                    Log.e(TAG, ""+item.getTitle());
                    Log.e(TAG, "------------------");

                }
            }
        });

        viewModel.postApiPost().observe(this, new Observer<PostResponseItem>() {
            @Override
            public void onChanged(PostResponseItem postResponseItem) {

                String TAG = "*";
                Log.e(TAG, ""+postResponseItem.getId() );
                Log.e(TAG, ""+postResponseItem.getTitle() );
                Log.e(TAG, "------------------------------" );

            }
        });
    }

    private void init() {
        viewModel = new ViewModelProvider(this).get(RetrofitViewModel.class);
        activityRetrofitBinding.setVm(viewModel);
    }
}