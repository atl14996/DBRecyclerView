package com.example.week3day3homework;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
MyRecyclerViewAdapter myRecyclerViewAdapter;
AnimalDatabaseHelper animalDatabaseHelper;
Button btnAddEntry;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.rvRecyclerView);
        btnAddEntry = findViewById(R.id.btnaddentry);

//RecyclerView has two requirements
        //1. Layout manager (can be customized, but generally we use a default

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        //2. RecyclerView adapter (written code)

         myRecyclerViewAdapter = new MyRecyclerViewAdapter(animalDatabaseHelper.getAllAnimalsFromDatabase());
        recyclerView.setAdapter(myRecyclerViewAdapter);

    }

    public void onClick (View view) {
        Intent intent = new Intent(this, AddAnimaltoListandDatabase.class);
        startActivityForResult(intent, 433);


    }


}
