package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";
    private List<Item> items;
    private RecyclerView recView;
    private String[] names = {"Lisa", "Vika", "Masha", "Sasha", "Sveta", "Lisa", "Vika", "Masha", "Sasha", "Sveta"};
    private double[] prices = new double[10];

    private void setData(){
        items = new ArrayList<>();
        for(int i=0;i<10;++i){
            prices[i]=i*10;
            items.add(new Item(names[i], prices[i]));
        }
    }
    private void setAdapter(){
        ItemsAdapter adapter = new ItemsAdapter(items);
        recView.setAdapter(adapter);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        recView = (RecyclerView)findViewById(R.id.recView);
        recView.setHasFixedSize(true);
        Log.i(TAG, "Create activity");
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recView.setLayoutManager(llm);
        recView.setHasFixedSize(true);

        setData();
        setAdapter();
    }
}