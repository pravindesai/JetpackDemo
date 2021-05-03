package com.example.jetpackdemo.mvvm_api.Repository;

import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.jetpackdemo.BaseClasses.JetpackApplication;
import com.example.jetpackdemo.mvvm_api.api.single_api_response.SingleUser;
import com.google.gson.Gson;

import org.json.JSONObject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class SingleUserRepository {
    SingleUser user;
    MutableLiveData<SingleUser> singleUserLiveData;
    private int Curent_user_id = 0;

    Gson gson;
    RequestQueue requestQueue;
    JsonObjectRequest objectRequest;
    String API_URL = "https://reqres.in/api/users/";

    public SingleUserRepository() {
        gson = new Gson();
        singleUserLiveData = new MutableLiveData<>();
        requestQueue = Volley.newRequestQueue(JetpackApplication.getAppContext());

    }

    public LiveData<SingleUser> getNextUser(){
        objectRequest = new JsonObjectRequest(Request.Method.GET, API_URL+(++Curent_user_id),
                null, new ListnerRes(),new ErrorListner());
        requestQueue.add(objectRequest);
        return singleUserLiveData;
    }

    public LiveData<SingleUser> getPreviousUser(){
        if (Curent_user_id>1){
            objectRequest = new JsonObjectRequest(Request.Method.GET, API_URL+(--Curent_user_id),
                    null, new ListnerRes(),new ErrorListner());
            requestQueue.add(objectRequest);
        }

        return singleUserLiveData;
    }

    private class ListnerRes implements Response.Listener<JSONObject>  {

        @Override
        public void onResponse(JSONObject response) {
            user = (SingleUser) gson.fromJson(response.toString(), SingleUser.class);

            singleUserLiveData.setValue(user);
        }

    }

    private class ErrorListner implements Response.ErrorListener{
        @Override
        public void onErrorResponse(VolleyError error) {

            Log.e("** RESPONSE ERROR: ", "onErrorResponse: "+error );
            Toast.makeText(JetpackApplication.getAppContext(), "NEXT USER NOT FOUND", Toast.LENGTH_SHORT).show();

            Curent_user_id--;
            singleUserLiveData.setValue(user);
        }
    }
}
