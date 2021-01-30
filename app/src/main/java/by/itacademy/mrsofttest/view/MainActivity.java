package by.itacademy.mrsofttest.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import javax.inject.Inject;

import by.itacademy.mrsofttest.App;
import by.itacademy.mrsofttest.R;
import by.itacademy.mrsofttest.presenter.MainActivityPresenter;
import by.itacademy.mrsofttest.utils.ItemAdapter;

public class MainActivity extends AppCompatActivity {
    @Inject
    MainActivityPresenter presenter;
    @Inject
    ItemAdapter adapter;
    private SearchView searchView;
    private com.google.android.material.floatingactionbutton.FloatingActionButton sortButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.getComponent().inject(this);
        searchView = findViewById(R.id.searchView);
        sortButton = findViewById(R.id.doSort);
        sortButton.setOnClickListener(v -> presenter.sortContact());
        initRecycler();
        presenter.getContacts();
        presenter.insertContacts();
        presenter.setOnChangeListener(searchView);
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
}