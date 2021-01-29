package by.itacademy.mrsofttest;

import android.app.Application;

import androidx.room.Room;

import by.itacademy.mrsofttest.data.ContactDatabase;

public class App extends Application {
    public static App instance;
    private ContactDatabase database;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, ContactDatabase.class, "db")
                .build();
    }

    public static App getInstance() {
        return instance;
    }

    public ContactDatabase getDatabase() {
        return database;
    }
}
