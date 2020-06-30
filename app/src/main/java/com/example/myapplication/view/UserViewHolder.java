package com.example.myapplication.view;

import android.content.Context;
import android.media.Image;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.modules.network.NetworkModule;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class UserViewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private ImageView img;
    private Context context;

    public UserViewHolder(@NonNull View userView) {
        super(userView);

        name = userView.findViewById(R.id.name);
        img = userView.findViewById(R.id.imageAvatar);
        context = userView.getContext();
    }

    public void bind(User user){
        name.setText(user.getLogin());
//        Log.i("AVATAR", user.getAvatarUrl());
//        Picasso picasso = NetworkModule.getPicasso();
        Picasso.get().load(user.getAvatarUrl()).into(img);
    }
}
