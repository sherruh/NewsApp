package com.example.newsapp.data.posts;

import android.util.Log;

import com.example.newsapp.data.posts.models.ResponseData;
import com.example.newsapp.models.Post;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class PostsRepository {

    private static final String API_KEY="ec8a8cf88e4b479ca9a597669f5f2733";
    private static final String BASE_URL="https://newsapi.org";

    public static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static PostsNetworkClient client=retrofit.create(PostsNetworkClient.class);

    public void getPosts(final IPostsRepositry.PostsCallback postsCallback){
        Call<ResponseData> call=client.getPosts(API_KEY);

        final ArrayList<Post> posts = new ArrayList<>();

        call.enqueue(new Callback<ResponseData>() {
            @Override
            public void onResponse(Call<ResponseData> call, Response<ResponseData> response) {
                Log.d("MyApp", String.valueOf(response.body().getPosts().size()));
                posts.addAll(response.body().getPosts());
                postsCallback.onSucces(posts);
            }

            @Override
            public void onFailure(Call<ResponseData> call, Throwable t) {

            }
        });

    }

    private interface PostsNetworkClient {

        @GET("/v2/top-headlines?country=us")
        Call<ResponseData> getPosts(
                @Query("apiKey") String apiKey
        );
    }
}
