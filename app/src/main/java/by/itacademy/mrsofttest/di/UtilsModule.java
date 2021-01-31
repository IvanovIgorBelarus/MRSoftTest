package by.itacademy.mrsofttest.di;

import android.content.Context;
import javax.inject.Singleton;
import by.itacademy.mrsofttest.utils.Filter;
import by.itacademy.mrsofttest.utils.ItemAdapter;
import dagger.Module;
import dagger.Provides;

@Module
public class UtilsModule {
    @Provides
    @Singleton
    Filter providerFilter() {
        return new Filter();
    }

    @Provides
    @Singleton
    ItemAdapter providerItemAdapter(Context context) {
        return new ItemAdapter(context);
    }
}
