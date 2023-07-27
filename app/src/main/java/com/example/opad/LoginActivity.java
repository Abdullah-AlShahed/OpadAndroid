package com.example.opad;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    //1st Way to make actions with the button
    Button loginButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //1st Way to make actions with the button
        loginButton = findViewById(R.id.logInButton);
        loginButton.setOnClickListener(view -> {
            Toast.makeText(LoginActivity.this, "Logged In", Toast.LENGTH_SHORT).show();
            Intent intent =new Intent(LoginActivity.this,CatigoriesActivity.class);
            startActivity(intent);
        });




    }
}

