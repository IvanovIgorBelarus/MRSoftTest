package by.itacademy.mrsofttest.presenter;

import android.app.Activity;

import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.inject.Inject;

import by.itacademy.mrsofttest.App;
import by.itacademy.mrsofttest.data.ContactDao;
import by.itacademy.mrsofttest.data.ContactDatabase;
import by.itacademy.mrsofttest.data.ContactList;
import by.itacademy.mrsofttest.model.Contact;
import by.itacademy.mrsofttest.utils.Filter;
import by.itacademy.mrsofttest.utils.ItemAdapter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivityPresenterImpl implements MainActivityPresenter {

    @Inject
    Filter filter;
    @Inject
    ItemAdapter adapter;
    @Inject
    ContactDatabase db;
    @Inject
    ContactDao contactDao;
    private Disposable disposable;
    private List<Contact> contactList = new ArrayList<>();

    @Inject
    public MainActivityPresenterImpl() {
        App.getComponent().inject(this);
    }

    @Override
    public void insertContacts() {
        if (!getPref()) {
            contactDao.insertAll(ContactList.getList()).subscribeOn(Schedulers.io()).subscribe();
            setPref();
        }

    }

    @Override
    public void setOnChangeListener(SearchView searchView) {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.update(filter.filterContact(newText, contactList));
                return true;
            }
        });
    }

    @Override
    public void getContacts() {
        disposable = contactDao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(contactList -> {
                    this.contactList = contactList;
                    adapter.update(contactList);
                });
    }

    @Override
    public void sortContact() {
        Comparator<Contact> comparator = (o1, o2) -> {
            String fullName1 = String.format("%s %s %s", o1.firstName, o1.secondName, o1.surName);
            String fullName2 = String.format("%s %s %s", o2.firstName, o2.secondName, o2.surName);
            return fullName1.compareTo(fullName2);
        };
        Collections.sort(contactList, comparator);
        adapter.update(contactList);
    }

    @Override
    public void closeDisposable() {
        disposable.dispose();
    }

    private void setPref() {
        App.getInstance()
                .getSharedPreferences("pref", Activity.MODE_PRIVATE)
                .edit()
                .putBoolean("state", true)
                .commit();
    }

    private Boolean getPref() {
        return App.getInstance().getSharedPreferences("pref", Activity.MODE_PRIVATE)
                .getBoolean("state", false);
    }

}
