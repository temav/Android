package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";
    private List<Item> items;
    private ItemsAdapter adapter;
    private RecyclerView recView;
    private Button button;
    private String[] names = {"Lisa", "Vika", "Masha", "Sasha", "Sveta", "Lisa", "Vika", "Masha", "Sasha", "Sveta"};
    private double[] prices = new double[10];
    private final Random random = new Random();
    private void setData(){
        items = new ArrayList<>();
        for(int i=0;i<10;++i){
            prices[i]=i*10;
            items.add(new Item(names[i], prices[i]));
        }
    }
    private void setAdapter(){
        adapter = new ItemsAdapter(items);
        recView.setAdapter(adapter);
    }

    public void addListenerOnButton() {
        button.setOnClickListener(
                view -> {
//                    items = new ArrayList<>(50);
//                    Log.i(TAG, "MyClass, onclick button");
//                    for(Item item: items){
//                        item.name = names[random.nextInt(5)];
//                        int startValue= 100, endValue = 50000;
//                        item.price = startValue + random.nextInt(endValue-startValue+1);
//                    }
                    items = new ArrayList<>();
                    int startValue= 100, endValue = 50000;
                    double price;
                    for (int i=0; i<50;++i){
                        price = startValue + random.nextInt(endValue-startValue+1);
                        items.add(new Item(names[random.nextInt(5)], price));
                    }
                    adapter.setItems(items);
                }
        );
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);
        button = (Button)findViewById(R.id.button);

        recView = (RecyclerView)findViewById(R.id.recView);
        recView.setHasFixedSize(true);
        Log.i(TAG, "Create activity");
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recView.setLayoutManager(llm);
        recView.setHasFixedSize(true);

        setData();
        setAdapter();
        addListenerOnButton();
    }
}