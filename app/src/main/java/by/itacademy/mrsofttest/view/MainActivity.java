package by.itacademy.mrsofttest.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import by.itacademy.mrsofttest.R;
import by.itacademy.mrsofttest.model.Contact;
import by.itacademy.mrsofttest.presenter.MainActivityListener;
import by.itacademy.mrsofttest.presenter.MainActivityPresenter;
import by.itacademy.mrsofttest.presenter.MainActivityPresenterImpl;
import by.itacademy.mrsofttest.utils.ItemAdapter;

public class MainActivity extends AppCompatActivity implements MainActivityListener {
    private MainActivityPresenter presenter;
    private SearchView searchView;
    private com.google.android.material.floatingactionbutton.FloatingActionButton sortButton;
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.searchView);
        sortButton = findViewById(R.id.doSort);
        sortButton.setOnClickListener(v -> presenter.sortContact());
        adapter = new ItemAdapter(this);
        initRecycler();
        presenter = new MainActivityPresenterImpl(this);
        presenter.getContacts();
        presenter.insertContacts();
        presenter.setOnChangeListener(searchView, adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.closeDisposable();
    }

    private void initRecycler() {
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void showContacts(List<Contact> contactList) {
        adapter.update(contactList);
    }
}