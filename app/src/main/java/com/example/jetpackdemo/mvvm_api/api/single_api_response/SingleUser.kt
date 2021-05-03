package com.example.jetpackdemo.mvvm_api.api.single_api_response


import com.google.gson.annotations.SerializedName

data class SingleUser(
    @SerializedName("data")
    var `data`: Data,
    @SerializedName("support")
    var support: Support
)