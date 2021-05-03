package com.example.jetpackdemo.retorfit_demo.retrofit;

import com.example.jetpackdemo.retorfit_demo.retrofit.postResponse.PostResponse;
import com.example.jetpackdemo.retorfit_demo.retrofit.postResponse.PostResponseItem;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PostsApiInt {
  @GET("posts")
  Call<PostResponse> getPosts();

  @POST("posts")
  Call<PostResponseItem> createPost(@Body PostResponseItem postResponseItem);

  @DELETE("posts/{id}")
  Call<Void> deletePost(@Path("id") int id);

}
