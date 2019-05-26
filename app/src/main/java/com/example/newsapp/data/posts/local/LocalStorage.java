package com.example.newsapp.data.posts.local;

import android.util.Log;

import com.example.newsapp.data.posts.IPostsRepositry;
import com.example.newsapp.models.Post;

import java.util.List;
import java.util.logging.Logger;

import io.realm.Realm;
import io.realm.RealmResults;

public class LocalStorage implements ILocalStorage {

    @Override
    public void getPosts(IPostsRepositry.PostsCallback postsCallback) {
        Realm realm = Realm.getDefaultInstance();
        RealmResults<RPost> rPosts = realm.where(RPost.class).findAll();
        Log.d("MyApp","In local");
        postsCallback.onSucces(PostsMapper.toListPost(rPosts));
        realm.close();
    }

    @Override
    public void savePosts(final List<Post> posts) {
        executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                for (Post post:posts){
                    RPost managedPost = realm.where(RPost.class)
                            .equalTo("title", post.getTitle()) // Проверка на наличие в БД этой записи для того,
                                                                        // чтобы не вносить одни и теже записи
                            .findFirst();
                    if (managedPost == null) {
                        realm.copyToRealm(PostsMapper.toRPost(post));
                    }
                }
            }
        });

        Log.d("MyApp","written");

    }

    private void executeTransaction(Realm.Transaction transaction) {
        Realm realm = null;

        try {
            realm = Realm.getDefaultInstance();
            realm.executeTransaction(transaction);
        } catch (Exception e) {
        } finally {
            if (realm != null) {
                realm.close();
            }
        }
    }
}
