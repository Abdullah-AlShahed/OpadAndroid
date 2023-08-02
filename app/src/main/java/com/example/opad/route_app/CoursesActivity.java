package com.example.opad.route_app;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.opad.R;

public class CoursesActivity extends AppCompatActivity {

    ImageView showedImage;
    TextView showedText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses);
    showedImage=findViewById(R.id.course_img);
    showedText=findViewById(R.id.course_txt);

    showedImage.setImageResource(getIntent().getIntExtra("courseImg",-1));
    showedText.setText(getText(getIntent().getIntExtra("courseBtnText",-1)));

    }
}