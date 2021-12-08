package com.test.testtasklteh;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.test.testtasklteh.ListDataUtils.ListDataRequest;
import com.test.testtasklteh.ListDataUtils.ListDataModel;
import com.test.testtasklteh.ListDataUtils.ListDataCallBack;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerListActivity extends Activity implements ListDataCallBack {
    private LinearLayoutManager layoutManager;
    private RecyclerView recyclerView;
    private ListAdapter listAdapter;
    private ProgressBar progressBar;
    private ListDataRequest listDataRequest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.VISIBLE);
        listDataRequest = new ListDataRequest(RecyclerListActivity.this);
        listDataRequest.createRequest();
        updateList();

        recyclerView = findViewById(R.id.recyclerView_data);
        layoutManager = new LinearLayoutManager(RecyclerListActivity.this);


    }

    @Override
    public void isSuccess(List<ListDataModel> dataFromServers) {
        listAdapter = new ListAdapter(dataFromServers, this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(listAdapter);
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onError(String error) {

    }

    public void updateList() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                listDataRequest.createRequest();
            }
        }, 5000, 5000);
    }

    public void refresh(View view) {
        listDataRequest.createRequest();
    }
}
