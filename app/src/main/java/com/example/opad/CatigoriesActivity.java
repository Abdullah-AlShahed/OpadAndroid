package com.example.opad;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CatigoriesActivity extends AppCompatActivity
//2nd Way to make actions with the button
        implements View.OnClickListener {
    ImageView catigoriesHeaderImage;
    ImageView calculatorimg;
    ImageView postsimg;
    ImageView xoimg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catigories);
        //2nd way
        catigoriesHeaderImage = findViewById(R.id.android_toolpar);
        catigoriesHeaderImage.setOnClickListener(this);
        calculatorimg = findViewById(R.id.calculator_image_view);
        calculatorimg.setOnClickListener(this);
        postsimg = findViewById(R.id.posts_image);
        postsimg.setOnClickListener(this);
        xoimg = findViewById(R.id.xo_image_view);
        xoimg.setOnClickListener(this);


    }

    //2nd way
    @Override
    public void onClick(View view) {
        //not recommended way
        if (view.getId() == R.id.android_toolpar) {
            Toast.makeText(this, "Catigories Header Clicked", Toast.LENGTH_SHORT).show();
        }if (view.getId() == R.id.calculator_image_view) {
            Intent intent =new Intent(CatigoriesActivity.this, CalculatorActivity.class);
            startActivity(intent);
        }if (view.getId() == R.id.posts_image) {
            Intent intent =new Intent(CatigoriesActivity.this, PostsFeedActivity.class );
            startActivity(intent);
        }if (view.getId() == R.id.xo_image_view) {
            Intent intent =new Intent(CatigoriesActivity.this, XOLoginActivity.class );
            startActivity(intent);
        }

    }
}
