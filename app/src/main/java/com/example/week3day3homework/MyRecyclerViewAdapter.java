package com.example.week3day3homework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.support.v7.widget.helper.ItemTouchUIUtil;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter <MyRecyclerViewAdapter.ViewHolder> implements ItemTouchHelper.Callback {

AnimalDatabaseHelper animalDatabaseHelper;
    ArrayList<Animal> animalArrayList;

public MyRecyclerViewAdapter (ArrayList<Animal> animalList) {
    this.animalArrayList = animalDatabaseHelper.getAllAnimalsFromDatabase();


}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.animal_item, viewGroup, false));

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
Animal currentAnimal = animalArrayList.get(i);


       viewHolder.tvName.setText(currentAnimal.getName());
        viewHolder.tvType.setText(currentAnimal.getType());
        viewHolder.tvSound.setText(currentAnimal.getSound());


    }

    public void addAnimalToList (Animal animal) {
        animalArrayList.add(animal);
        animalDatabaseHelper.insertAnimalIntoDatabase(animal);
        notifyDataSetChanged();

    }

    @Override
    public int getItemCount() {
        return animalDatabaseHelper.getAllAnimalsFromDatabase().size();
    }

    @Override
    public int getMovementFlags(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder) {
        return 0;
    }

    @Override
    public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder viewHolder1) {
        return false;
    }

    @Override
    public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        Animal currentAnimal = animalArrayList.get(i);
        String[] currentAnimalName = {currentAnimal.getName().toString()};
        animalDatabaseHelper.deleteFromDatabaseById(currentAnimalName);

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

       TextView tvName;
       TextView tvType;
       TextView tvSound;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvType = itemView.findViewById(R.id.tvType);
            tvSound = itemView.findViewById(R.id.tvSound);
        }
    }
}