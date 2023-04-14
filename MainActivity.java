package com.example.madproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
ImageView i,xh1,c0,c1;
TextView c,q;
Button b;
ConstraintLayout l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        i=findViewById(R.id.i);
        b=findViewById(R.id.b);
        xh1=findViewById(R.id.x1);
        c0=findViewById(R.id.c3);
        c1=findViewById(R.id.c1);

q=findViewById(R.id.quote);
q.setTextColor(Color.rgb(0,0,0));


        l=findViewById(R.id.l);
        l.setBackgroundColor(Color.rgb(249,236,236));
        c=findViewById(R.id.c);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
b.setBackgroundColor(Color.rgb(243,135,135));



        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(MainActivity.this,lgn.class);
                startActivity(i);
            }
        });
    }
}