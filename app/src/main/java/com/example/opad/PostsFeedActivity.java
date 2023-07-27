package com.example.opad;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class PostsFeedActivity extends AppCompatActivity {

    RecyclerView postsRecyclerView;
    PostRecyclerAdapter adapter;

    List<PostData> postsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.posts_feed);
        postsRecyclerView=findViewById(R.id.posts_rv);
        creatPostsList();
        adapter =new PostRecyclerAdapter(postsList);
        postsRecyclerView.setAdapter(adapter);


    }

    public void creatPostsList(){

        postsList= new ArrayList<>();
        for(int i =0;i<300;i++){
            postsList.add(new PostData(R.drawable.user_icon,"Opad "+i,"\"With the sun setting on the horizon, I can't help but feel grateful for this breathtaking view. \uD83C\uDF05 Nature never fails to amaze me! #sunsetlovers #gratefulheart #naturephotography \uD83D\uDCF8\"",R.drawable.sunset));

        }


    }




}