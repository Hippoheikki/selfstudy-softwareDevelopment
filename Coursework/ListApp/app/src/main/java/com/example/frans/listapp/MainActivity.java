package com.example.frans.listapp;

import android.content.Intent;
import android.content.res.Resources;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView myListView;
    RecyclerView.Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Item> items = initItems();
        this.myListView = findViewById(R.id.myListView);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        this.myListView.setLayoutManager(mLayoutManager);

        this.adapter = new ItemAdapter(items);
        this.myListView.setAdapter(this.adapter);
    }

    private ArrayList<Item> initItems() {
        ArrayList<Item> list = new ArrayList<>();

        list.add(new Item("Ransuli", "1000€", "Ransu"));
        list.add(new Item("Microphone", "50€", "Blue Snowball Microphone"));
        list.add(new Item("Bottle", "4€", "Koskenkorva Village Tea - vodka based mixed drink"));

        return list;
    }
}
