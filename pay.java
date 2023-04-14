package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class pay extends AppCompatActivity {
TextView t;
ConstraintLayout l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        l=findViewById(R.id.l);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        l.setBackgroundColor(Color.rgb(249,236,236));
        t=findViewById(R.id.t);
        t.setTextColor(Color.rgb(243,135,135));

    }
}