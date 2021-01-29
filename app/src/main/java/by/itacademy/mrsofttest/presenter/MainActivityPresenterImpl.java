package by.itacademy.mrsofttest.presenter;

import android.annotation.SuppressLint;
import android.util.Log;

import by.itacademy.mrsofttest.App;
import by.itacademy.mrsofttest.data.ContactDao;
import by.itacademy.mrsofttest.data.ContactDatabase;
import by.itacademy.mrsofttest.data.ContactList;
import by.itacademy.mrsofttest.utils.ItemAdapter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainActivityPresenterImpl {
    private ItemAdapter adapter;
    ContactDatabase db = App.getInstance().getDatabase();
    ContactDao contactDao = db.contactDao();

    public MainActivityPresenterImpl(ItemAdapter adapter) {
        this.adapter = adapter;
    }

    @SuppressLint("CheckResult")
    public void insertContacts() {
        contactDao.insertAll(ContactList.getList()).subscribeOn(Schedulers.newThread());
    }

    @SuppressLint("CheckResult")
    public void updateAdapter() {
        contactDao.getAll().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(list -> Log.d("mytag", String.format("updateAdapter size=%s", list.size())));
    }
}
