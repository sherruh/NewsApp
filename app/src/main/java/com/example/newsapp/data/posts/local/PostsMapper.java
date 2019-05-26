package com.example.newsapp.data.posts.local;

import com.example.newsapp.models.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class PostsMapper {

    public static Post toPost(RPost rPost){
        Post post = new Post(rPost.getTitle(),rPost.getUrl(),
                rPost.getDescription(),rPost.getImageUrl());
        return post;
    }

    public static RPost toRPost(Post post){
        RPost rPost = new RPost(post.getTitle(),post.getUrl(),
                post.getImageUrl(),post.getDescription());
        return rPost;
    }

    public static List<RPost> toListRPost(List<Post> posts){
        List<RPost> rPosts=new ArrayList<>();
        for (Post post:posts)rPosts.add(toRPost(post));
        return rPosts;
    }

    public static List<Post> toListPost(List<RPost> rPosts){
        List<Post> posts=new ArrayList<>();
        for (RPost rPost:rPosts) posts.add(toPost(rPost));
        return posts;
    }

}
