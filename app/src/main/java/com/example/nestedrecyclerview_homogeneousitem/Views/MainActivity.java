package com.example.nestedrecyclerview_homogeneousitem.Views;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.nestedrecyclerview_homogeneousitem.Models.Child;
import com.example.nestedrecyclerview_homogeneousitem.R;
import com.example.nestedrecyclerview_homogeneousitem.ViewModel.ChildDataFactory;
import com.example.nestedrecyclerview_homogeneousitem.ViewModel.ParentDataFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity  {

    ParentDataFactory parentDataFactory;
    ChildDataFactory childDataFactory;

    List<Child> childList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parentDataFactory = new ParentDataFactory();
        childDataFactory = new ChildDataFactory();

        initRecycler();

        LocalBroadcastManager.getInstance(this).registerReceiver(mMessageReceiver,
                new IntentFilter("custom-message"));


    }

    private void initRecycler() {

        Context context = getApplicationContext();

        RecyclerView recyclerView =  findViewById(R.id.rv_parent);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layoutManager);

        ParentAdapter parentAdapter = new ParentAdapter(parentDataFactory.parentList(), context);

        recyclerView.setAdapter(parentAdapter);

    }


    public BroadcastReceiver mMessageReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            // Get extra data included in the Intent

            String ItemName = intent.getStringExtra("item");
            int pos = Integer.parseInt(ItemName);

            Toast.makeText(MainActivity.this,
                    childDataFactory.getChild(pos).getTitle() +" " ,Toast.LENGTH_SHORT).show();
        }
    };


}
