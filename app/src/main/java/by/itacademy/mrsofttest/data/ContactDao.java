package by.itacademy.mrsofttest.data;

import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import by.itacademy.mrsofttest.model.Contact;

public interface ContactDao {
    @Query("SELECT * FROM contact")
    List<Contact> getAll();

    @Insert
    void insert (Contact contact);
}
