package by.itacademy.mrsofttest.data;

import java.util.List;

import by.itacademy.mrsofttest.model.Contact;
import io.reactivex.Observable;

public interface DataRepository {
    void insertContacts();

    Observable<List<Contact>> getContacts();
}
