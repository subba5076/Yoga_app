package com.example.madproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
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

public class rgstr extends AppCompatActivity {
    TextView aha;
    EditText ie, ep, cp;
    Button b;
    FirebaseAuth mAuth;
    FirebaseUser mUser;
    ProgressDialog pd;

    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rgstr);
        aha = findViewById(R.id.aha);
        ie = findViewById(R.id.inputEmail);
        ep = findViewById(R.id.inputPassword);
        cp = findViewById(R.id.inputConfirmPassword);
        b = findViewById(R.id.btnRegister);
        pd = new ProgressDialog(rgstr.this);
        mAuth = FirebaseAuth.getInstance();
        mUser = mAuth.getCurrentUser();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        aha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(rgstr.this, lgn.class);
                startActivity(i);
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                perforAuth();
            }
        });
    }

    private void perforAuth() {
        String email = ie.getText().toString();
        String password = ep.getText().toString();
        String confirmPassword = cp.getText().toString();
        if (!email.matches(emailPattern)) {
            ie.setError("Enter correct email");
        } else if (password.isEmpty() || password.length() < 6) {
            ep.setError("Enter proper password");
        } else if (!password.equals(confirmPassword)) {
            cp.setError("password doesnt match!");
        } else {
            pd.setMessage("please wait while Registration...");
            pd.setTitle("Registration");
            pd.setCanceledOnTouchOutside(false);
            pd.show();
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        pd.dismiss();
                        Intent i = new Intent(rgstr.this, lgn.class);
                        i.setFlags(i.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(i);
                        Toast.makeText(rgstr.this, "Registration successfull!", Toast.LENGTH_SHORT).show();
                    } else {
                        pd.dismiss();
                        Toast.makeText(rgstr.this, "" + task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

    }
}
