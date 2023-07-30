package com.example.opad.posts;

public class PostData {

    int user_image_id;
    String user_name;
    String post_text;
    int post_image;

    int post_launch_time_number;
    String post_launch_time_type;
    int post_reacts_number;
    int post_shares_number;

    public PostData(int user_image_id, String user_name, String post_text, int post_image) {
        this.user_image_id = user_image_id;
        this.user_name = user_name;
        this.post_text = post_text;
        this.post_image = post_image;
        this.post_launch_time_number = 0;
        this.post_launch_time_type = "h";
        this.post_reacts_number = 0;
        this.post_shares_number = 0;
    }


    public void setUser_image_id(int user_image_id) {
        this.user_image_id = user_image_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPost_text(String post_text) {
        this.post_text = post_text;
    }

    public void setPost_image(int post_image) {
        this.post_image = post_image;
    }

    public void setPost_launch_time_number(int post_launch_time_number) {
        this.post_launch_time_number = post_launch_time_number;
    }

    public void setPost_launch_time_type(String post_launch_time_type) {
        this.post_launch_time_type = post_launch_time_type;
    }

    public void setPost_reacts_number(int post_reacts_number) {
        this.post_reacts_number = post_reacts_number;
    }

    public void setPost_shares_number(int post_shares_number) {
        this.post_shares_number = post_shares_number;
    }
}
