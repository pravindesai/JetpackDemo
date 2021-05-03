package com.example.jetpackdemo.retorfit_demo;

import android.util.Log;
import android.widget.Toast;

import com.example.jetpackdemo.BaseClasses.JetpackApplication;
import com.example.jetpackdemo.retorfit_demo.retrofit.PostsApiInt;
import com.example.jetpackdemo.retorfit_demo.retrofit.postResponse.PostResponse;
import com.example.jetpackdemo.retorfit_demo.retrofit.postResponse.PostResponseItem;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRepository {
    private final Retrofit retrofit;
    private final PostsApiInt postsApiInt;
    private final String BASE_URL = "https://jsonplaceholder.typicode.com/";

    private MutableLiveData<PostResponseItem> returning_item = new MutableLiveData<>();
    private MutableLiveData<PostResponse> postResponseItems = new MutableLiveData<>();



    public RetrofitRepository() {

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        postsApiInt = retrofit.create(PostsApiInt.class);

    }

    public MutableLiveData<PostResponse> getPosts(){

        Call<PostResponse> call = postsApiInt.getPosts();

        call.enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                if (response.isSuccessful()){
                    postResponseItems.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable t) {
                Log.e("* ", "onFailure: "+t.getMessage() );
            }
        });

        return postResponseItems;
    }

    public MutableLiveData<PostResponseItem> createPost(PostResponseItem item_to_post){

        Call<PostResponseItem>call = postsApiInt.createPost(item_to_post);

        call.enqueue(new Callback<PostResponseItem>() {
            @Override
            public void onResponse(Call<PostResponseItem> call, Response<PostResponseItem> response) {
                if (response.isSuccessful()){
                    returning_item.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<PostResponseItem> call, Throwable t) {
                Log.e("* ", "onFailure: "+t.getMessage() );
            }
        });

        return returning_item;
    }

    public void deletePost(int postId){
        Call<Void> call = postsApiInt.deletePost(postId);
        call.enqueue(new Callback<Void>() {
            String TAG = "**";
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {

                Log.e(TAG, "onResponse:DELETED " );
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Log.e(TAG, "onFailure: DELETE FAILED "+t.getMessage() );
            }
        });
    }

}



