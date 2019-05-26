package com.example.newsapp.data.posts;

import com.example.newsapp.models.Post;

import java.util.List;

public interface IPostsRepositry {
    void getPosts(PostsCallback postsCallback);

    public interface PostsCallback{
        void onSucces(List<Post> posts);

        void onFailure(String message);
    }
}
