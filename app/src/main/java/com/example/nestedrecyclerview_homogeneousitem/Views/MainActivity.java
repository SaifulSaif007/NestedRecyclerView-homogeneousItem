package com.example.nestedrecyclerview_homogeneousitem.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.nestedrecyclerview_homogeneousitem.R;
import com.example.nestedrecyclerview_homogeneousitem.ViewModel.ParentDataFactory;

public class MainActivity extends AppCompatActivity implements ParentAdapter.ParentItemClick {

    ParentDataFactory parentDataFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parentDataFactory = new ParentDataFactory();

        initRecycler();

    }

    private void initRecycler() {

        RecyclerView recyclerView =  findViewById(R.id.rv_parent);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        ParentAdapter parentAdapter = new ParentAdapter(parentDataFactory.parentList(), this);

        recyclerView.setAdapter(parentAdapter);

    }

    @Override
    public void parentClick(int position) {
        Log.e("Parent", ""+ position);
    }
}
