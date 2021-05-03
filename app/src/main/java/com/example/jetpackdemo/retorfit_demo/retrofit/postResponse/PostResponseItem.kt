package com.example.jetpackdemo.retorfit_demo.retrofit.postResponse


import com.google.gson.annotations.SerializedName

data class PostResponseItem(
    @SerializedName("body")
    var body: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("userId")
    var userId: Int
){
    constructor(body: String, title: String, userId: Int) : this(body, 0, title, userId)
}