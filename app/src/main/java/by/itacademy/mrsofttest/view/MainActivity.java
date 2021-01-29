package by.itacademy.mrsofttest.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import by.itacademy.mrsofttest.R;
import by.itacademy.mrsofttest.presenter.MainActivityPresenterImpl;
import by.itacademy.mrsofttest.utils.ItemAdapter;

public class MainActivity extends AppCompatActivity {
    private MainActivityPresenterImpl presenter;
    private ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new ItemAdapter(this);
        initRecycler();
        presenter = new MainActivityPresenterImpl(adapter);
        presenter.insertContacts();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter.updateAdapter();
    }

    private void initRecycler() {
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setAdapter(adapter);
    }
}