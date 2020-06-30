package com.example.myapplication.screens;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.view.User;
import com.example.myapplication.view.UsersAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainView {

    MainPresenter presenter;
    private List<User> users = new ArrayList<>();
    private UsersAdapter adapter;
    private RecyclerView recView;
    private Bundle b;

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String user = "mojombo";
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


        b = getIntent().getExtras();
        if (b != null) {
            user = b.getString("user");
            toolbar.setNavigationIcon(R.drawable.ic_launcher_foreground);
            toolbar.setTitle("Followers: " + user);
            toolbar.setNavigationOnClickListener(v -> finish());
        }


        recView = findViewById(R.id.rv);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recView.setLayoutManager(llm);
//        recView.setHasFixedSize(true);
        setAdapter();
        presenter = new MainPresenter(this, user);
//        presenter.initialLoading(user);
    }

    private void setAdapter() {
        adapter = new UsersAdapter(users);
        recView.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        if (getIntent().getBooleanExtra("isFollowers", false)) {
            super.onBackPressed();
        }


        AlertDialog dialog = new AlertDialog.Builder(this)
                .setMessage("IDI NAHOOY!")
                .setPositiveButton("OK", (dialog1, which) -> super.onBackPressed())
                .setNegativeButton("NO", (dialog12, which) -> {
                })
                .create();

        dialog.show();
    }

    @Override
    public void onInitialLoadingSuccess(List<User> payload) {
        Log.i(TAG, payload.toString());
//        users = (ArrayList) payload;
        adapter.setItems(payload);
    }

    @Override
    public void onInitialLoadingFailure() {
        Toast.makeText(this, "HUI SASI", Toast.LENGTH_SHORT).show();
    }
}
//TODO подправить тулбар, добавить getFollowers