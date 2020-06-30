package com.example.myapplication.view;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.screens.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UserViewHolder> {

//    private final View.OnClickListener mOnClickListener = new MyOnClickListener();new

    private List<User> items = Collections.emptyList();
    UsersAdapter() {
    }
    public UsersAdapter(List<User> itemsss){
        this.items = itemsss;
    }

    public void setItems(List<User> items) {
        this.items = items;
        notifyDataSetChanged();
    }
    @Override
    public int getItemCount() {
        return items.size();
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        Context context = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item, viewGroup, false);
//        view.setOnClickListener(mOnClickListener);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder UserViewHolder, int position) {
        UserViewHolder.itemView.setOnClickListener(view -> {
            Context context = view.getContext();
            String userLogin = items.get(position).getLogin();

            Toast.makeText(context, userLogin, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(context, MainActivity.class);

            intent.putExtra("user", userLogin);

            context.startActivity(intent);
        });

        User item = items.get(position);
        UserViewHolder.bind(item);
    }
}
