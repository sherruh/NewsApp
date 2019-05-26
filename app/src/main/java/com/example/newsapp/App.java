package com.example.newsapp;

import android.app.Application;
import android.util.Log;

import com.example.newsapp.data.posts.IPostsRepositry;
import com.example.newsapp.data.posts.PostsRepository;
import com.example.newsapp.data.posts.local.LocalStorage;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends Application {

    public static IPostsRepositry postsRepositry;

    @Override
    public void onCreate() {
        initRealm();
        postsRepositry=new PostsRepository(new LocalStorage());
    }

    private void initRealm() {
        Realm.init(this);

        RealmConfiguration configuration = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .name("news.realm")
                .schemaVersion(1)
                .build();

        Realm.setDefaultConfiguration(configuration);
    }
}
