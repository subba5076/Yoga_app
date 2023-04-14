package com.example.madproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class second extends AppCompatActivity {
TextView tv;
Button p,b,s,up;
ImageView iv;
ConstraintLayout l;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv=findViewById(R.id.tv);
        tv.setTextColor(Color.rgb(0,0,0));

        p=findViewById(R.id.b1);

        b=findViewById(R.id.b2);

        s=findViewById(R.id.b3);



        iv=findViewById(R.id.illu);
        up=findViewById(R.id.upg);

        up.setBackgroundColor(Color.rgb(135, 212, 59));
        l=findViewById(R.id.ls);
        l.setBackgroundColor(Color.rgb(249,236,236));

        p.setBackgroundColor(Color.rgb(243,135,135));
        b.setBackgroundColor(Color.rgb(243,135,135));
        s.setBackgroundColor(Color.rgb(243,135,135));

        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i1 = new Intent(second.this,padmasana.class);
                startActivity(i1);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(second.this,tadasana.class);
                startActivity(i2);
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(second.this,shavasan.class);
                startActivity(i3);
            }
        });
        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder ad = new AlertDialog.Builder(second.this);
                ad.setTitle("UPGRADE");
                ad.setMessage("Upgrade to premium worth only Rs.199/mo ?");
                ad.setNegativeButton("Later", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                ad.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
Intent ii= new Intent(second.this,pay.class);
startActivity(ii);
                    }
                });

                AlertDialog a = ad.create();
                a.show();
            }
        });
    }
}