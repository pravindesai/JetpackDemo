package com.example.jetpackdemo.mvvm_api.api.single_api_response


import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.google.gson.annotations.SerializedName


data class Data(
        @SerializedName("avatar")
        var avatar: String,
        @SerializedName("email")
        var email: String,
        @SerializedName("first_name")
        var firstName: String,
        @SerializedName("id")
        var id: Int,
        @SerializedName("last_name")
        var lastName: String


){
        companion object{
                @JvmStatic
                @BindingAdapter("avatarBinder")
                fun loadAvatar(view: ImageView, avatar: String?):Unit{
                        Glide.with(view.context)
                                .load(avatar)
                                .into(view);
                }
        }


}