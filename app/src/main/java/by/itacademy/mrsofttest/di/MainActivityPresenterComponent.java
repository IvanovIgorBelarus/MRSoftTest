package by.itacademy.mrsofttest.di;

import javax.inject.Singleton;

import by.itacademy.mrsofttest.presenter.MainActivityPresenterImpl;
import by.itacademy.mrsofttest.view.MainActivity;
import dagger.Component;

@Component(modules = {UtilsModule.class, DataModule.class, AppModule.class})
@Singleton
public interface MainActivityPresenterComponent {
    void inject(MainActivityPresenterImpl mainActivityPresenterImpl);

    void inject(MainActivity mainActivity);
}
