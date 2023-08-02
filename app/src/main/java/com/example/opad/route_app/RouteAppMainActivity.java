package com.example.opad.route_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.opad.R;

import java.util.ArrayList;
import java.util.List;

public class RouteAppMainActivity extends AppCompatActivity {

    RecyclerView routeCoursesRecyclerView;

    RouteAppRecyclerAdapter adapter;

    RecyclerView.LayoutManager layoutManager;
    List<CourseData> coursesList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.route_app_courses_feed);
        routeCoursesRecyclerView = findViewById(R.id.route_course_rv);
        creatRouteCourses();
        adapter = new RouteAppRecyclerAdapter(coursesList);
        layoutManager = new LinearLayoutManager(this);
        Intent intent = new Intent(RouteAppMainActivity.this, CoursesActivity.class);
        adapter.setOnButtonClickListener(new RouteAppRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position, CourseData item) {
                if (item.courseBtnText==R.string.android_course_text) {
                    intent.putExtra("courseImg", R.drawable.android);
                    intent.putExtra("courseBtnText", R.string.android_content);
                }
                if (item.courseBtnText==R.string.ios_course_text) {
                    intent.putExtra("courseImg", R.drawable.ios);
                    intent.putExtra("courseBtnText", R.string.ios_content);
                }
                if (item.courseBtnText==R.string.fullStack_course_text) {
                    intent.putExtra("courseImg", R.drawable.full_stack);
                    intent.putExtra("courseBtnText", R.string.fullStack_content);
                }
                startActivity(intent);
            }
        });
        routeCoursesRecyclerView.setAdapter(adapter);
        routeCoursesRecyclerView.setLayoutManager(layoutManager);
    }

    private void creatRouteCourses() {
        coursesList = new ArrayList<>();
        coursesList.add(new CourseData(R.drawable.android, R.string.android_course_text));
        coursesList.add(new CourseData(R.drawable.ios, R.string.ios_course_text));
        coursesList.add(new CourseData(R.drawable.full_stack, R.string.fullStack_course_text));
    }
}