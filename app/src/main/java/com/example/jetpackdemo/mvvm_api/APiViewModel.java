package com.example.jetpackdemo.mvvm_api;
import com.example.jetpackdemo.mvvm_api.api.single_api_response.SingleUser;
import com.example.jetpackdemo.mvvm_api.Repository.SingleUserRepository;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class APiViewModel extends ViewModel {

    private SingleUserRepository singleUserRepository;

    //Constructor
    public APiViewModel() {
     singleUserRepository = new SingleUserRepository();

    }

    public LiveData<SingleUser> getNextUser(){
        return singleUserRepository.getNextUser();
    }

    public LiveData<SingleUser> getPreviousUser(){
        return singleUserRepository.getPreviousUser();
    }


}
