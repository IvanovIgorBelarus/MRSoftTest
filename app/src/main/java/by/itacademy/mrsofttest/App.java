package by.itacademy.mrsofttest;

import android.app.Application;

import by.itacademy.mrsofttest.di.AppModule;
import by.itacademy.mrsofttest.di.DaggerMainActivityPresenterComponent;
import by.itacademy.mrsofttest.di.MainActivityPresenterComponent;

public class App extends Application {
    public static App instance;
    private static MainActivityPresenterComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        component = DaggerMainActivityPresenterComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static MainActivityPresenterComponent getComponent() {
        return component;
    }

    public static App getInstance() {
        return instance;
    }
}
