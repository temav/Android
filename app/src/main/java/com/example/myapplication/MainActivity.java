package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";
    private Button btn;
    private EditText text;
    private TextView tv;
    private String btnText;
    private int colorRed;
    private int colorBlue;
    private boolean flag = false;
    private ListView list;
    private List<String> names = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button)findViewById(R.id.button);
        btn.setText(R.string.buttonText);
        colorBlue = getColor(R.color.blueButton);
        colorRed = getColor(R.color.redButton);
//        btn.setBackgroundTintList(ColorStateList.valueOf(getColor(R.color.blueButton)));
        Log.i(TAG, "Create activity");
        addListenerOnButton();
        list();
    }

    public void addListenerOnButton () {
        text = (EditText)findViewById(R.id.input);
        tv = (TextView)findViewById(R.id.textView);
        btn = (Button)findViewById(R.id.button);
//        final int color1 = Color.RED;
//        final int color2 = Color.BLUE;
        int color;
//        final boolean[] flag = {false};
        btn.setOnClickListener(
                view -> {
                    Editable str = text.getText();
                    names.add(str.toString());
                    Log.i(TAG, "MyClass, onclick button");
                    Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                    tv.setText(str);
                    if (flag) {
                        btn.setBackgroundTintList(ColorStateList.valueOf(colorRed));
                    } else {
                        btn.setBackgroundTintList(ColorStateList.valueOf(colorBlue));
                        btn.setTextColor(Color.WHITE);
                    }
                    flag = !flag;
                }
        );
    }
    public void list () {
        list = (ListView)findViewById(R.id.listViewNames);
        names.add("Vova");
        names.add("Petya");
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.names_layout, names);
        list.setAdapter(adapter);
        list.setOnItemClickListener((adapterView, view, i, l) -> {
            String val = (String)list.getItemAtPosition(i);
            Log.i(TAG, "OnClick Item");
            Toast.makeText(MainActivity.this, "Name: " + val, Toast.LENGTH_SHORT).show();
        });
    }
//    public void buttonOnClick(View v) {
//        EditText text = (EditText)findViewById(R.id.input);
//        TextView tv = (TextView)findViewById(R.id.textView);
//        Editable str = text.getText();
//        tv.setText(str);
//        Log.i(TAG, "MyClass, onbuttonclick " + str);
//    }
}