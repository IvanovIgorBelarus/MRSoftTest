package by.itacademy.mrsofttest.presenter;

import androidx.appcompat.widget.SearchView;

import by.itacademy.mrsofttest.utils.ItemAdapter;

public interface MainActivityPresenter {
    void insertContacts();

    void setOnChangeListener(SearchView searchView, ItemAdapter adapter);

    void getContacts();

    void sortContact();

    void closeDisposable();
}
