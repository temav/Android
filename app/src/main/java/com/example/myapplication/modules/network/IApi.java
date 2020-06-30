package com.example.myapplication.modules.network;

import com.example.myapplication.view.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface IApi {
    @GET("users/{user}/followers")
    Call<List<User>> getUsers(@Path("user") String user);
}
