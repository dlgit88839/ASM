package com.example.asm;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btn_1)
    Button btn1;
    @BindView(R.id.btn_2)
    Button btn2;
    @BindView(R.id.btn_3)
    Button btn3;
    @BindView(R.id.btn_4)
    Button btn4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btn1 = findViewById(R.id.btn_1);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
//        btn1.setOnClickListener(this);
//        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("main", "click4");
            }
        });
    }

    @Override
    @ignore
    public void onClick(View v) {
        Log.e("main", "click3");
    }

    @OnClick({R.id.btn_1, R.id.btn_2})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_1:
                Log.e("main", "click1");
                break;
            case R.id.btn_2:
                Log.e("main", "click2");
                break;
            case R.id.btn_3:
                break;
            case R.id.btn_4:
                break;
        }
    }
}
