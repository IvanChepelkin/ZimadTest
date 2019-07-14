package com.example.zimadtest.view.dog_view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.zimadtest.models.domain.dogs.dog_entity.DogItem;

import java.util.List;

public class DogAdapter extends RecyclerView.Adapter<DogHolder> {
    private List<DogItem> dogItemList;
    private ItemListener itemListener;

    public DogAdapter(ItemListener itemListener) {
        super();
        this.itemListener = itemListener;
    }

    public void setDogItemList(List<DogItem> dogItemList) {
        this.dogItemList = dogItemList;
    }

    @NonNull
    @Override
    public DogHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return DogHolder.create(LayoutInflater.from(viewGroup.getContext()), viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull DogHolder dogHolder, int position) {
        dogHolder.bind(dogItemList.get(position), position);

    }

    @Override
    public int getItemCount() {
        return dogItemList.size();
    }

    public interface ItemListener {
        void onItemClick(int position);
    }
}
