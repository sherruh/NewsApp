package com.example.newsapp.presentation.posts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.newsapp.R;
import com.example.newsapp.data.posts.IPostsRepositry;
import com.example.newsapp.data.posts.PostsRepository;
import com.example.newsapp.models.Post;
import com.example.newsapp.presentation.post.PostActivity;
import com.example.newsapp.presentation.posts.recycler.PostsAdapter;
import com.example.newsapp.presentation.posts.recycler.PostsViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements IPostsRepositry.PostsCallback, PostsViewHolder.PostClickListener {

    RecyclerView recyclerView;
    PostsAdapter adapter;
    ArrayList<Post> posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        posts = new ArrayList<>();
        PostsRepository postsRepository=new PostsRepository();
        recyclerView = findViewById(R.id.posts_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PostsAdapter(new ArrayList<Post>(),this);
        recyclerView.setAdapter(adapter);
        postsRepository.getPosts(this);
    }

    @Override
    public void onSucces(List<Post> posts) {
        adapter.setPosts((ArrayList<Post>) posts);
        this.posts.clear();
        this.posts.addAll(posts);
    }

    @Override
    public void onFailure(String message) {

    }

    @Override
    public void onPostClick(int position) {
        PostActivity.startActivity(this,posts.get(position));
    }
}
