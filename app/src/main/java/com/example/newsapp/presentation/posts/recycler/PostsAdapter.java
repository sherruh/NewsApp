package com.example.newsapp.presentation.posts.recycler;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newsapp.R;
import com.example.newsapp.models.Post;

import java.util.ArrayList;

public class PostsAdapter extends RecyclerView.Adapter<PostsViewHolder> {

    private ArrayList<Post> posts;
    PostsViewHolder.PostClickListener postClickListener;


    public PostsAdapter(ArrayList<Post> posts, PostsViewHolder.PostClickListener postClickListener) {
        this.posts = posts;
        this.postClickListener=postClickListener;
    }

    @NonNull
    @Override
    public PostsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.view_holder_posts, viewGroup, false);
        return new PostsViewHolder(view,postClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull PostsViewHolder postsViewHolder, int i) {
        postsViewHolder.onBindViewHolder(posts.get(i));
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts.addAll(posts);
        notifyDataSetChanged();
    }
}
