package com.example.jetpackdemo.paging.retrofit;

import com.example.jetpackdemo.paging.retrofit.photosResponse.PhotosResClass;
import com.example.jetpackdemo.retorfit_demo.retrofit.postResponse.PostResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PhotosServiceInt {

    @GET("photos")
    Call<PhotosResClass> getPhotos();

}
