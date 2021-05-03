package com.example.jetpackdemo.paging;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.paging.PagedList;

import android.os.Bundle;
import android.util.Log;

import com.example.jetpackdemo.R;
import com.example.jetpackdemo.paging.retrofit.photosResponse.PhotosResClass;
import com.example.jetpackdemo.paging.retrofit.photosResponse.PhotosResClassItem;

public class Paging_Activity extends AppCompatActivity {
    PagingViewModel pagingViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging_);

        pagingViewModel = new ViewModelProvider(this).get(PagingViewModel.class);

        pagingViewModel.getPagedListLiveData().observe(this, new Observer<PagedList<PhotosResClassItem>>() {
            @Override
            public void onChanged(PagedList<PhotosResClassItem> photosResClassItems) {
                if (photosResClassItems!=null){
                    for(PhotosResClassItem item : photosResClassItems){
                        Log.e("***CHNAGED: ", ": "+item.getId() );
                    }
                }
            }
        });
    }
}