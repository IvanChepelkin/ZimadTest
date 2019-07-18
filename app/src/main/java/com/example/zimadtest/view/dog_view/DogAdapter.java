package com.example.zimadtest.view.dog_view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.zimadtest.models.domain.dogs.dog_entity.Dogs;

public class DogAdapter extends RecyclerView.Adapter<DogHolder> {
    private Dogs dogs;
    private DogItemListener dogItemListener;

    public DogAdapter(DogItemListener dogItemListener) {
        super();
        this.dogItemListener = dogItemListener;
    }

    public void setDogs(Dogs dogs) {
        this.dogs = dogs;
    }

    @NonNull
    @Override
    public DogHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return DogHolder.create(LayoutInflater.from(viewGroup.getContext()), viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull DogHolder dogHolder, int position) {
        dogHolder.bind(dogs.getDogItemList().get(position), position, dogs.getMessage());
    }

    @Override
    public int getItemCount() {
        return dogs.getDogItemList().size();
    }

    public interface DogItemListener {
        void onDogItemClick(int position);
    }
}
