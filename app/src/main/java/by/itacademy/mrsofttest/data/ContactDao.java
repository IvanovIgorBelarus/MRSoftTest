package by.itacademy.mrsofttest.data;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import by.itacademy.mrsofttest.model.Contact;
import io.reactivex.Completable;
import io.reactivex.Observable;

@Dao
public interface ContactDao {
    @Query("SELECT * FROM contacts")
    Observable<List<Contact>> getAll();

    @Insert
    Completable insertAll(List<Contact> contactList);
}
