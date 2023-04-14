package com.example.madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class lgn extends AppCompatActivity {

    TextView cna;

    EditText ie, ep;
    Button b;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    ProgressDialog pd;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lgn);
        b = findViewById(R.id.btnLogin);
        ie=findViewById(R.id.inputEmail);
        ep=findViewById(R.id.inputPassword);
        pd = new ProgressDialog(lgn.this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        String email = ie.getText().toString();
        String password = ep.getText().toString();
        cna = findViewById(R.id.cna);
        cna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(lgn.this, rgstr.class);
                startActivity(i);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performLogin();
            }
        });
    }

    private void performLogin() {
        String email = ie.getText().toString();
        String password = ep.getText().toString();

        if (!email.matches(emailPattern)) {
            ie.setError("Enter correct email");
        } else if (password.isEmpty() || password.length() < 6) {
            ep.setError("Enter proper password");
        } else {
            pd.setMessage("please wait while Login...");
            pd.setTitle("Login");
            pd.setCanceledOnTouchOutside(false);
            pd.show();
            mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        pd.dismiss();
                        Intent i = new Intent(lgn.this, second.class);
                        i.setFlags(i.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);
                        Toast.makeText(lgn.this, "Login successfull!", Toast.LENGTH_SHORT).show();
                    } else {
                        pd.dismiss();
                        Toast.makeText(lgn.this, "" + task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }
}