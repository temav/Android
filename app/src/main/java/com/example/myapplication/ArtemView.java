package com.example.myapplication;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ArtemView extends LinearLayout implements IArtemView {

    private String value = "START";

    @Nullable
    private EditText artemEt;

    @Nullable
    private Button clearButton;
    private Button getButton;
    private Button setButton;
    private boolean reset;
    private RecyclerView recView;
    private List<Item> items = new ArrayList<>();
    private ItemsAdapter adapter;
    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
//                    Toast.makeText(getContext(), s, Toast.LENGTH_SHORT).show();
            value = s.toString();
//            Item ii = new Item(value);
            boolean contain = false;
            for (int i=0; i<items.size();++i)
                if(items.get(i).name==value)
                    contain = true;
            if(!contain) {
                items.add(new Item(value));
                adapter.setItems(items);
            }

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    public ArtemView(Context context) {
        super(context);
        initializeView();
        setAdapter();
    }

    public ArtemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initializeView();
        LinearLayoutManager llm = new LinearLayoutManager(context);
        recView.setLayoutManager(llm);
        recView.setHasFixedSize(true);
        setAdapter();
    }

    public ArtemView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initializeView();
    }
    private void setAdapter(){
        adapter = new ItemsAdapter(items);
        recView.setAdapter(adapter);
    }

    private void initializeView() {
        inflate(getContext(), R.layout.view_example, this);
        initializeExampleEt(getOrientation());
        initializeArtemBtn(getOrientation());
    }

    private void initializeArtemBtn(int orientation) {
        clearButton = findViewById(R.id.clearButton);
        setButton = findViewById(R.id.buttonSet);
        getButton = findViewById(R.id.buttonGet);
        if (clearButton != null) {
            clearButton.setOnClickListener(v -> clearValue());
            getButton.setOnClickListener(v -> {
                Toast.makeText(getContext(), getValue(), Toast.LENGTH_SHORT).show();
            });
            setButton.setOnClickListener(v -> setupValue("Беляш"));
            if (orientation == HORIZONTAL) {
                setupHorizontalParams(clearButton);
            }
        }

    }

    private void initializeExampleEt(int orientation) {
        artemEt = findViewById(R.id.artem_et);
        recView = findViewById(R.id.rv);
        if (artemEt != null) {
            artemEt.setText(value);
            artemEt.addTextChangedListener(textWatcher);

            if (orientation == HORIZONTAL) {
                setupHorizontalParams(artemEt);
            }
        }
    }

    private void setupHorizontalParams(View view) {
        LinearLayout.LayoutParams params = (LayoutParams) view.getLayoutParams();
        params.width = 0;
        params.weight = 1;
        view.setLayoutParams(params);
    }

    @Override
    public String getValue() {
        return artemEt.getText().toString();
    }

    @Override
    public void setupValue(@NonNull String value) {
        if (artemEt != null) {
            artemEt.removeTextChangedListener(textWatcher);
            artemEt.setText(value);
            items = new ArrayList<>();
            adapter.setItems(items);
            artemEt.addTextChangedListener(textWatcher);
        }
    }

    @Override
    public void clearValue() {
        if (artemEt != null) {
            artemEt.removeTextChangedListener(textWatcher);
            artemEt.setText("");
            artemEt.addTextChangedListener(textWatcher);
            items.add(new Item("СБРОС!"));
            adapter.setItems(items);
        }
    }
}
