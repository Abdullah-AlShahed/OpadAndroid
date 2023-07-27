package com.example.opad;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PostRecyclerAdapter extends RecyclerView.Adapter<PostRecyclerAdapter.PostViewHolder> {
    List<PostData> posts;

    public PostRecyclerAdapter(List<PostData> posts) {
        this.posts = posts;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_view, parent, false);
        PostViewHolder viewHolder = new PostViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostData item = posts.get(position);
        holder.user_image.setImageResource(item.user_image_id);
        holder.user_name.setText(item.user_name);
        holder.post_text.setText(item.post_text);
        holder.post_image.setImageResource(item.post_image);

        holder.post_launch_time_number.setText(String.valueOf(item.post_launch_time_number));
        holder.post_launch_time_type.setText(item.post_launch_time_type);
        holder.post_reacts_number.setText(String.valueOf(item.post_reacts_number));
        holder.post_shares_number.setText(String.valueOf(item.post_shares_number));

    }

    @Override
    public int getItemCount() {
        return posts == null ? 0 : posts.size();
    }

    static class PostViewHolder extends RecyclerView.ViewHolder {
        //from Users Data
        ImageView user_image;
        TextView user_name;
        TextView post_text;
        ImageView post_image;

        //program should Handle
        TextView post_launch_time_number;
        TextView post_launch_time_type;
        TextView post_reacts_number;
        TextView post_shares_number;

        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            this.user_image = itemView.findViewById(R.id.post_round_image);
            this.user_name = itemView.findViewById(R.id.post_user_name);
            this.post_text = itemView.findViewById(R.id.post_text);
            this.post_image = itemView.findViewById(R.id.post_image);
            this.post_launch_time_number = itemView.findViewById(R.id.post_launch_time_number);
            this.post_launch_time_type = itemView.findViewById(R.id.post_launch_time_type);
            this.post_reacts_number = itemView.findViewById(R.id.post_reacts_number);
            this.post_shares_number = itemView.findViewById(R.id.post_shares_number);
        }
    }


}
