package com.example.newsapp.data.posts.local;

import com.example.newsapp.data.posts.IPostsRepositry;
import com.example.newsapp.models.Post;

import java.util.List;

public interface ILocalStorage {

    public void getPosts(IPostsRepositry.PostsCallback postsCallback);

    public void savePosts(List<Post> posts);

}
