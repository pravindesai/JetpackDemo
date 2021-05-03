package com.example.jetpackdemo.paging;

import android.util.Log;

import com.example.jetpackdemo.paging.retrofit.PhotosServiceInt;
import com.example.jetpackdemo.paging.retrofit.photosResponse.PhotosResClass;
import com.example.jetpackdemo.paging.retrofit.photosResponse.PhotosResClassItem;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.PageKeyedDataSource;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PhotosDataSource extends PageKeyedDataSource<Void,PhotosResClassItem> {
    PhotosServiceInt photosServiceInt;
    private static final String TAG = "PhotosDataSource";

    public PhotosDataSource(PhotosServiceInt photosServiceInt) {
        this.photosServiceInt = photosServiceInt;
    }

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Void> params, @NonNull LoadInitialCallback<Void, PhotosResClassItem> callback) {
        Call<PhotosResClass> call = photosServiceInt.getPhotos();
        Log.e(TAG, "loadInitial: " );
        call.enqueue(new Callback<PhotosResClass>() {
            @Override
            public void onResponse(Call<PhotosResClass> call, Response<PhotosResClass> response) {
                PhotosResClass res = response.body();
                if (response.isSuccessful()){

                    for (PhotosResClassItem item:res) {
                        Log.i(TAG, "onResponse: *"+item.getId() );
                    }

                    callback.onResult((ArrayList<PhotosResClassItem>)res, null, null);
                }

            }

            @Override
            public void onFailure(Call<PhotosResClass> call, Throwable t) {
                Log.e(TAG, "onFailure: *"+t.getMessage() );
            }
        });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Void> params, @NonNull LoadCallback<Void, PhotosResClassItem> callback) {

    }

    @Override
    public void loadAfter(@NonNull LoadParams<Void> params, @NonNull LoadCallback<Void, PhotosResClassItem> callback) {

    }

}
