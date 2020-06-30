package com.example.myapplication.screens;

import com.example.myapplication.modules.network.IApi;
import com.example.myapplication.modules.network.NetworkModule;
import com.example.myapplication.view.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class MainPresenter {

    IMainView view;

    public MainPresenter(IMainView view, String user) {
        this.view = view;
        initialLoading(user);
    }

    public void initialLoading(String user) {
        final IApi api = NetworkModule.getApi();
        api.getUsers(user).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                view.onInitialLoadingSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                t.printStackTrace();
                view.onInitialLoadingFailure();
            }
        });
    }
}
