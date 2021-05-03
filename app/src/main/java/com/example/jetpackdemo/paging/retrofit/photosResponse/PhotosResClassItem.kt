package com.example.jetpackdemo.paging.retrofit.photosResponse


import com.google.gson.annotations.SerializedName

data class PhotosResClassItem(
    @SerializedName("albumId")
    var albumId: Int,
    @SerializedName("id")
    var id: Int,
    @SerializedName("thumbnailUrl")
    var thumbnailUrl: String,
    @SerializedName("title")
    var title: String,
    @SerializedName("url")
    var url: String
)