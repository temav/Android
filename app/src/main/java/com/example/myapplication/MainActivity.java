package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";
    private Button button;
    private EditText editText;
    private TextView textView;
    private int colorRed;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.input);
        textView = (TextView) findViewById(R.id.textView);
        button.setText(R.string.buttonText);

        colorRed = getColor(R.color.redButton);
        Log.i(TAG, "Create activity");

        editText.addTextChangedListener(myEditListenerOnTextView);
        editText.addTextChangedListener(myEditListenerOnButton);
        addListenerOnButton();
    }

    TextWatcher myEditListenerOnTextView = new TextWatcher() {
        public void afterTextChanged(Editable s) {
        }
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence str, int start, int before, int count) {
            Log.i(TAG, "onTextChanged  for textView: "+str);
            textView.setText(str);
        }
    };

    TextWatcher myEditListenerOnButton = new TextWatcher() {
        public void afterTextChanged(Editable s) {
        }
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }
        @Override
        public void onTextChanged(CharSequence str, int start, int before, int count) {
            Log.i(TAG, "onTextChanged for button: "+str);
            button.setText(str);
        }
    };

    public void addListenerOnButton() {
        button.setOnClickListener(
                view -> {
                    editText.removeTextChangedListener(myEditListenerOnButton);
                    button.setBackgroundColor(colorRed);
                    Log.i(TAG, "MyClass, onclick button");
                }
        );
    }
}