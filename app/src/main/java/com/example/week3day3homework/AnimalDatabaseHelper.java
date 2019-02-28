package com.example.week3day3homework;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.ArrayList;

import static com.example.week3day3homework.AnimalDatabaseContract.COLUMN_NAME;
import static com.example.week3day3homework.AnimalDatabaseContract.COLUMN_SOUND;
import static com.example.week3day3homework.AnimalDatabaseContract.COLUMN_TYPE;
import static com.example.week3day3homework.AnimalDatabaseContract.DATABASE_NAME;
import static com.example.week3day3homework.AnimalDatabaseContract.DATABASE_VERSION;
import static com.example.week3day3homework.AnimalDatabaseContract.TABLE_NAME;
import static com.example.week3day3homework.AnimalDatabaseContract.createQuery;
import static com.example.week3day3homework.AnimalDatabaseContract.getWhereClauseByName;

public class AnimalDatabaseHelper extends SQLiteOpenHelper {
    public AnimalDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(createQuery());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long insertAnimalIntoDatabase(@NonNull Animal animal) {

        SQLiteDatabase writeableDatabase = this.getWritableDatabase();
        //Data holder used for database key value pairs
        ContentValues contentValues = new ContentValues();

        contentValues.put(COLUMN_NAME, animal.getName());
        contentValues.put(COLUMN_TYPE, animal.getType());
        contentValues.put(COLUMN_SOUND, animal.getSound());


        //insert the car into the table using contentValues

        return writeableDatabase.insert(TABLE_NAME, null, contentValues);


    }

    public static String getAllAnimalsQuery(){
        return "SELECT * FROM" + TABLE_NAME;

    }

    public ArrayList<Animal> getAllAnimalsFromDatabase() {

        ArrayList<Animal> returnAnimalList = new ArrayList<>();
        SQLiteDatabase readableDatabase = this.getReadableDatabase();

        Cursor cursor = readableDatabase.rawQuery(getAllAnimalsQuery(), null);

        if(cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                String type = cursor.getString(cursor.getColumnIndex(COLUMN_TYPE));
                String sound = cursor.getString(cursor.getColumnIndex(COLUMN_SOUND));


                returnAnimalList.add(new Animal(name, type, sound));
            }
            while (cursor.moveToNext());
            //return the result in a list
        }
        cursor.close();
        return returnAnimalList;
    }


    public long deleteFromDatabaseById(String[] name) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();



        return sqLiteDatabase.delete(TABLE_NAME, getWhereClauseByName() + name[0], null);





    }

}
