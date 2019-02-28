package com.example.week3day3homework;

import java.util.Locale;

public class AnimalDatabaseContract {

    public static final String DATABASE_NAME = "animal_db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_NAME = "Animals";
    public static final String COLUMN_NAME = "Name";
    public static final String COLUMN_TYPE = "Type";
    public static final String COLUMN_SOUND = "Sound";


    public static String createQuery() {
        StringBuilder queryBuilder = new StringBuilder();

        queryBuilder.append("CREATE TABLE");
        queryBuilder.append(TABLE_NAME);
        queryBuilder.append(" ( ");
        queryBuilder.append(COLUMN_NAME);
        queryBuilder.append(" ");
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_TYPE);
        queryBuilder.append(" TEXT, ");
        queryBuilder.append(COLUMN_SOUND);
        queryBuilder.append(" TEXT ) ");





        return queryBuilder.toString();

    }

    public static String getAnimalbyName(String name) {
        return String.format("SELECT * FROM %s WHERE %s = \"%d\"", TABLE_NAME, COLUMN_NAME, name);
        // return "SELECT * FROM" + TABLE_NAME + " WHERE " + COLUMN_ID + " = ";
    }

    public static String getWhereClauseByName(){

        return String.format(Locale.US, "%s = ", COLUMN_NAME);
    }


}



