package com.example.jetpackdemo.retorfit_demo;

import com.example.jetpackdemo.retorfit_demo.retrofit.postResponse.PostResponse;
import com.example.jetpackdemo.retorfit_demo.retrofit.postResponse.PostResponseItem;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class RetrofitViewModel extends ViewModel {
    private final RetrofitRepository retrofitRepository;
    private PostResponseItem responseItem;

    public RetrofitViewModel() {
        this.retrofitRepository = new RetrofitRepository();

    }

    public MutableLiveData<PostResponse> getPosts(){
        return retrofitRepository.getPosts();
    }

    public MutableLiveData<PostResponseItem> postApiPost(){
        responseItem = new PostResponseItem("DEMO BODY", "DEMO TITLE", 2);
        return retrofitRepository.createPost(this.responseItem);
    }

    public void deletePost(){
        retrofitRepository.deletePost(1);
    }
}
