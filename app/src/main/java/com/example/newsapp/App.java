package com.example.newsapp;

import android.app.Application;
import android.util.Log;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class App extends Application {

    @Override
    public void onCreate() {
        initRealm();
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
