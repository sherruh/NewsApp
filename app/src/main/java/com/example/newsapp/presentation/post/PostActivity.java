package com.example.newsapp.presentation.post;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.ImageViewCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.newsapp.R;
import com.example.newsapp.models.Post;

public class PostActivity extends AppCompatActivity {

    ImageView image;
    TextView textTitle;
    TextView textDesc;

    public static void startActivity(Activity activity, Post post){
        Intent intent = new Intent(activity,PostActivity.class);
        intent.putExtra("post",post);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post);
        image=findViewById(R.id.image_post);
        textTitle=findViewById(R.id.tex_title_post);
        textDesc=findViewById(R.id.tex_desc);

        showPostInformation();
    }

    private void showPostInformation(){
        Intent intent=getIntent();
        Post post= (Post) intent.getSerializableExtra("post");
        Glide.with(this).load(post.getImageUrl()).into(image);
        Log.d("MyApp","intenet" + post.getTitle());
        textTitle.setText(post.getTitle());
        textDesc.setText(post.getDescription());
    }


}
