package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";
    private Button btn;
    private EditText text;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "Create activity");
        addListenerOnButton();
    }

    public void addListenerOnButton () {
        text = (EditText)findViewById(R.id.input);
        tv = (TextView)findViewById(R.id.textView);
        btn = (Button)findViewById(R.id.button);
        final int color1 = Color.RED;
        final int color2 = Color.BLUE;
        int color;
        final boolean[] flag = {false};
        btn.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        Editable str = text.getText();
                        Log.i(TAG, "MyClass, onclick ");
                        Toast.makeText(MainActivity.this, str, Toast.LENGTH_LONG).show();
                        tv.setText(str);
                        if (flag[0]) {
                            btn.setBackgroundTintList(ColorStateList.valueOf(color1));
                        } else {
                            btn.setBackgroundTintList(ColorStateList.valueOf(color2));
                            btn.setTextColor(Color.WHITE);
                        }
                        flag[0] = !flag[0];
                    }

                }
        );


    }
//    public void buttonOnClick(View v) {
//        EditText text = (EditText)findViewById(R.id.input);
//        TextView tv = (TextView)findViewById(R.id.textView);
//        Editable str = text.getText();
//        tv.setText(str);
//        Log.i(TAG, "MyClass, onbuttonclick " + str);
//    }
}