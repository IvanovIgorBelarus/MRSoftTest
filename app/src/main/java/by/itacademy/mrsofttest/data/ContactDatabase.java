package by.itacademy.mrsofttest.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import by.itacademy.mrsofttest.model.Contact;

@Database(entities = {Contact.class}, version = 1)
public abstract class ContactDatabase extends RoomDatabase {
    public abstract ContactDao contactDao();
}
