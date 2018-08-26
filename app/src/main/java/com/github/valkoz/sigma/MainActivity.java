package com.github.valkoz.sigma;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.github.valkoz.sigma.model.TransformedItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MVPMainView {

    private static final String KEY = "items";

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ItemAdapter itemAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private MVPMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        presenter = new MainPresenter();
        swipeRefreshLayout.setOnRefreshListener(() -> {
            if (InternetConnection.isInternetOn(getApplicationContext())) {
                presenter.getItems();
            }
            else {
                hideLoading();
                showError("No Internet access");
            }
        });
        presenter.onCreate(this);


        if (savedInstanceState != null && savedInstanceState.containsKey(KEY)) {
            showItems(savedInstanceState.getParcelableArrayList(KEY));
        }
        else {
            if (InternetConnection.isInternetOn(getApplicationContext())) {
                showLoading();
                presenter.getItems();
            }
            else {
                showError("No Internet access");
            }
        }

    }

    private void initView() {
        swipeRefreshLayout = findViewById(R.id.swipe_refresh);
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        itemAdapter = new ItemAdapter(new ArrayList<>());
        recyclerView.setAdapter(itemAdapter);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (!itemAdapter.getItems().isEmpty()) {
            outState.putParcelableArrayList(KEY, new ArrayList<>(itemAdapter.getItems()));
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
    }

    @Override
    public void showItems(List<TransformedItem> items) {
        itemAdapter.addItems(items);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(getApplicationContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void hideLoading() {
        swipeRefreshLayout.setRefreshing(false);
    }

}
