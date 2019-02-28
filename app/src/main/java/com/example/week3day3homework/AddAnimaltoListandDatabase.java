package com.example.week3day3homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class AddAnimaltoListandDatabase extends AppCompatActivity {
EditText etName;
EditText etSound;
EditText etType;
MyRecyclerViewAdapter myRecyclerViewAdapter;
AnimalDatabaseHelper animalDatabaseHelper;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_animalto_listand_database);
        etName = findViewById(R.id.etEnterName);
        etSound = findViewById(R.id.etEnterSound);
        etType = findViewById(R.id.etType);

    }

    public void onClick (View view) {

        String name = etName.getText().toString();
        String sound = etSound.getText().toString();
String type = etType.getText().toString();
        //Make an object that matches the opject passed in the ArrayList
        Animal animalToInsert = new Animal(name, type, sound);

        //Call the method in the adapter to add th ebeverage to the list

        animalDatabaseHelper.insertAnimalIntoDatabase(animalToInsert);
    }
}
