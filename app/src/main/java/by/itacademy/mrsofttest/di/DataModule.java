package by.itacademy.mrsofttest.di;

import android.content.Context;

import androidx.room.Room;

import javax.inject.Singleton;

import by.itacademy.mrsofttest.data.ContactDao;
import by.itacademy.mrsofttest.data.ContactDatabase;
import dagger.Module;
import dagger.Provides;

@Module
public class DataModule {
    @Provides
    @Singleton
    ContactDatabase providerContactDatabase(Context context) {
        return Room.databaseBuilder(context, ContactDatabase.class, "db")
                .build();
    }

    @Provides
    @Singleton
    ContactDao providerContactDao(ContactDatabase db) {
        return db.contactDao();
    }
}
