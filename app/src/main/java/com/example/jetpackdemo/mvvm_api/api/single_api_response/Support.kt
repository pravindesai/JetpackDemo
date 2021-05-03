package com.example.jetpackdemo.mvvm_api.api.single_api_response


import com.google.gson.annotations.SerializedName

data class Support(
    @SerializedName("text")
    var text: String,
    @SerializedName("url")
    var url: String
)