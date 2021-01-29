package by.itacademy.mrsofttest.presenter;

import androidx.appcompat.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

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

public class MainActivityPresenterImpl {
    private MainActivityListener mainActivityListener;
    private ContactDatabase db = App.getInstance().getDatabase();
    private ContactDao contactDao = db.contactDao();
    private Disposable disposable;
    private List<Contact> contactList = new ArrayList<>();

    public MainActivityPresenterImpl(MainActivityListener mainActivityListener) {
        this.mainActivityListener = mainActivityListener;
    }

    public void insertContacts() {
        contactDao.insertAll(ContactList.getList()).subscribeOn(Schedulers.io()).subscribe();
    }

    public void setOnChangeListener(SearchView searchView, ItemAdapter adapter) {
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.update(Filter.filterContact(newText,contactList));
                return true;
            }
        });
    }

    public void getContacts() {
        disposable = contactDao.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(contactList -> {
                    this.contactList = contactList;
                    mainActivityListener.showContacts(contactList);
                });
    }

    public void closeDisposable() {
        disposable.dispose();
    }
}
