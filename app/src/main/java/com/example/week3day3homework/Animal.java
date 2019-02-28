//**************  Week 3 Day 3 Homework **************************
//        1.  Create an database that holds:
//        a) Animals Type (Mammal, Reptile, ect)
//        b) Animals Name(Human, Snake, Cat, ect)
//        c) Animals Sound(Talk, none, meow, ect)
//        d) Animals Image
//        2.  Create a Activity with a RecyclerView that will display the animal
//        3.  When the animal is clicked, start an activity that will:
//        a) show all the items listed in 1 and the animals population which will come from a random number generated
//        in  a thread
//        4.  Create an activity that will allow you to add an animal to the DB.  You should display a ListView for the animal types and allow the user to pick from it.
//        5.  Implement a item touch helper for the RecyclerView that will remove an animal from the RecyclerView AND the Database.
//
//
//
package com.example.week3day3homework;

import android.os.Parcel;
import android.os.Parcelable;

public class Animal implements Parcelable {

    private String type;
    private String name;
    private String sound;

    public Animal(String type, String name, String sound) {
        this.type = type;
        this.name = name;
        this.sound = sound;
    }

    protected Animal(Parcel in) {
        type = in.readString();
        name = in.readString();
        sound = in.readString();
    }

    public static final Creator<Animal> CREATOR = new Creator<Animal>() {
        @Override
        public Animal createFromParcel(Parcel in) {
            return new Animal(in);
        }

        @Override
        public Animal[] newArray(int size) {
            return new Animal[size];
        }
    };

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(type);
        dest.writeString(name);
        dest.writeString(sound);
    }
}
