package com.example.jetpackdemo.paging;

import com.example.jetpackdemo.paging.retrofit.PhotosServiceInt;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;

public class PhotosFactory extends DataSource.Factory{
    MutableLiveData<PhotosDataSource> dataSourceMutableLiveData;
    PhotosDataSource photosDataSource;
    PhotosServiceInt photosServiceInt;

    public PhotosFactory(PhotosServiceInt serviceInt) {
        dataSourceMutableLiveData = new MutableLiveData<>();
        photosServiceInt = serviceInt;
    }

    @NonNull
    @Override
    public DataSource create() {
        photosDataSource = new PhotosDataSource(photosServiceInt);
        dataSourceMutableLiveData.postValue(photosDataSource);
        return null;
    }

    public MutableLiveData<PhotosDataSource> getDataSourceMutableLiveData() {
        return dataSourceMutableLiveData;
    }
}
