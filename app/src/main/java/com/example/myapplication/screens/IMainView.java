package com.example.myapplication.screens;

import com.example.myapplication.view.User;

import java.util.List;

interface IMainView {
    void onInitialLoadingSuccess(List<User> payload);
    void onInitialLoadingFailure();
}