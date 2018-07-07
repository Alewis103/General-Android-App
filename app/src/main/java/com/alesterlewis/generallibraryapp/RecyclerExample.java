package com.alesterlewis.generallibraryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerExample extends AppCompatActivity {

    ArrayList<String> mContacts;
    RecyclerView mRecycler;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_activity);

        mRecycler = (RecyclerView) findViewById(R.id.recycler_view);
        mContacts = new ArrayList<>();// datastore for example which should be populated by data from Async Task
        mContacts.add("Alester Lewis");
        mContacts.add("Alester Lewis");
        mContacts.add("Alester Lewis");
        mContacts.add("Alester Lewis");
        mContacts.add("Alester Lewis");
        mContacts.add("Alester Lewis");
        mContacts.add("Alester Lewis");
        mContacts.add("Alester Lewis");
        mContacts.add("Alester Lewis");
        mContacts.add("Alester Lewis");


        /*
        *By doing this, recyclerview won’t request layout whenever data is updated in the
         * recyclerview item and the view will just invalidate by itself.
         * use if your arraylist is not going to change it size again at runtime
        */
        mRecycler.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new AdapterExample(mContacts);
        mRecycler.setLayoutManager(mLayoutManager);
        mRecycler.setAdapter(mAdapter);


    }
}
