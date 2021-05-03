package com.example.jetpackdemo.paging;

import android.util.Log;
import com.example.jetpackdemo.paging.retrofit.PhotosServiceInt;
import com.example.jetpackdemo.paging.retrofit.photosResponse.PhotosResClass;
import com.example.jetpackdemo.paging.retrofit.photosResponse.PhotosResClassItem;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.work.impl.constraints.NetworkState;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PagingViewModel extends ViewModel {
    private final Retrofit retrofit;
    private final PhotosServiceInt photosServiceInt;
    private final String BASE_URL = "https://jsonplaceholder.typicode.com/";
    private static final String TAG = "PagingViewModel";

    private Executor executor;
    private LiveData<PagedList<PhotosResClassItem>> pagedListLiveData;

    public PagingViewModel(){

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        photosServiceInt = retrofit.create(PhotosServiceInt.class);

        executor = Executors.newFixedThreadPool(5);
        PhotosFactory photosFactory = new PhotosFactory(photosServiceInt);

        PagedList.Config pagedListConfig =
                (new PagedList.Config.Builder())
                        .setEnablePlaceholders(false)
                        .setInitialLoadSizeHint(10)
                        .setPageSize(20).build();
        pagedListLiveData =  (new LivePagedListBuilder(photosFactory, pagedListConfig))
                .setFetchExecutor(executor)
                .build();
    }

    public LiveData<PagedList<PhotosResClassItem>> getPagedListLiveData() {
        return pagedListLiveData;
    }
}
