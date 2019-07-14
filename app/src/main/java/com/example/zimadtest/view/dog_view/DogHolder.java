package com.example.zimadtest.view.dog_view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.zimadtest.R;
import com.example.zimadtest.models.domain.dogs.dog_entity.DogItem;
import com.squareup.picasso.Picasso;

public class DogHolder extends RecyclerView.ViewHolder {
    private View root;
    private ImageView dogImage;
    private TextView dog_item_number;
    private TextView dog_item_information;
    private DogAdapter.ItemListener itemListener;
    private int position;

    public DogHolder(@NonNull View itemView) {
        super(itemView);
        root = itemView;
        dogImage = itemView.findViewById(R.id.dog_image);
        dog_item_number = itemView.findViewById(R.id.dog_item_number);
        dog_item_information = itemView.findViewById(R.id.dog_item_information);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemListener.onItemClick(position);
            }
        });
    }

    void bind(DogItem dogItem, int position) {
        dog_item_number.setText(dogItem.getTitle());
        Picasso.get()
                .load(dogItem.getUrl())
                .into(dogImage);

    }

    static DogHolder create(LayoutInflater inflater, ViewGroup parent) {
        return new DogHolder(inflater.inflate(R.layout.dog_card, parent, false));
    }
}
