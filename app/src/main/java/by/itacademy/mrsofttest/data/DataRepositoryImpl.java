package by.itacademy.mrsofttest.data;

import java.util.List;

import javax.inject.Inject;

import by.itacademy.mrsofttest.model.Contact;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class DataRepositoryImpl implements DataRepository {
    @Inject
    ContactDatabase db;
    @Inject
    ContactDao contactDao;

    @Inject
    public DataRepositoryImpl() {
    }

    @Override
    public void insertContacts() {
        contactDao.insertAll(ContactList.getList()).subscribeOn(Schedulers.io()).subscribe();
    }

    @Override
    public Observable<List<Contact>> getContacts() {
        return contactDao.getAll();
    }
}
