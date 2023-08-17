package com.example.opad.route_app;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.opad.R;

import java.util.List;

public class RouteAppRecyclerAdapter extends RecyclerView.Adapter<RouteAppRecyclerAdapter.CourseViewHolder> {


    List<CourseData> courses;

    public RouteAppRecyclerAdapter(List<CourseData> courses) {
        this.courses = courses;
    }

    @NonNull
    @Override
    public CourseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.route_app_course, parent, false);
        CourseViewHolder viewHolder = new CourseViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CourseViewHolder holder, int position) {
        CourseData item = courses.get(position);
        holder.image.setImageResource(item.courseImg);
        holder.btnText.setText(item.courseBtnText);
        holder.btnText.setOnClickListener(view -> onButtonClickListener.onClick(position, item));
        // holder.image.setOnClickListener(view -> opad.onClick(position,item));

    }


    OnItemClickListener onButtonClickListener;

    public void setOnButtonClickListener(OnItemClickListener onButtonClickListener) {
        this.onButtonClickListener = onButtonClickListener;
    }

//    OnItemClickListener opad;
//
//    public void setOpad(OnItemClickListener opad) {
//        this.opad = opad;
//    }

    interface OnItemClickListener {
        void onClick(int position, CourseData item);
    }

    @Override
    public int getItemCount() {
        return courses == null ? 0 : courses.size();
    }

    static class CourseViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        Button btnText;

        public CourseViewHolder(@NonNull View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.route_course_image);
            this.btnText = itemView.findViewById(R.id.route_course_btn);
        }
    }


}
