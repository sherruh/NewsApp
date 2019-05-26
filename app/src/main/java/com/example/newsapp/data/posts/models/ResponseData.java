package com.example.newsapp.data.posts.models;

import com.example.newsapp.models.Post;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseData {

    @SerializedName("articles")
    private List<Post> posts;

    public ResponseData(List<Post> posts) {
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
