package com.example.opad.route_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.opad.R;

import java.util.ArrayList;
import java.util.List;

public class RouteAppMainActivity extends AppCompatActivity {

    RecyclerView routeCoursesRecyclerView;

    RouteAppRecyclerAdapter adapter;

    List<CourseData> coursesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.route_app_courses_feed);
        routeCoursesRecyclerView = findViewById(R.id.route_course_rv);
        creatRouteCourses();
        adapter = new RouteAppRecyclerAdapter(coursesList);
        routeCoursesRecyclerView.setAdapter(adapter);

    }

    private void creatRouteCourses() {
        coursesList = new ArrayList<>();
        coursesList.add(new CourseData(R.drawable.android,R.string.android_course_text));
//        coursesList.add(new CourseData(R.drawable.ios,R.string.ios_course_text));
//        coursesList.add(new CourseData(R.drawable.full_stack,R.string.fullStack_course_text));
    }


}