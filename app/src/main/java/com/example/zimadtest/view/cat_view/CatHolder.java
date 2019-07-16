package com.example.zimadtest.view.cat_view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.zimadtest.R;
import com.example.zimadtest.models.domain.cats.cat_entity.CatItem;

public class CatHolder extends RecyclerView.ViewHolder {
    private View root;
    private ImageView catImage;
    private TextView cat_item_number;
    private TextView cat_item_information;
    private CatAdapter.CatItemListener catItemListener;
    private int position;

    public CatHolder(@NonNull View itemView) {
        super(itemView);
        root = itemView;
        catImage = itemView.findViewById(R.id.cat_image);
        cat_item_number = itemView.findViewById(R.id.cat_item_number);
        cat_item_information = itemView.findViewById(R.id.dog_item_information);
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                catItemListener.onCatItemClick(position);
            }
        });
    }

    void bind(CatItem catItem, int position) {
        this.position = position;
        cat_item_number.setText(catItem.getTitle());
        Glide
                .with(root.getContext()) // replace with 'this' if it's in activity
                .load(catItem.getUrl())
                .into(catImage);
    }

    static CatHolder create(LayoutInflater inflater, ViewGroup parent) {
        return new CatHolder(inflater.inflate(R.layout.cat_card, parent, false));
    }
}
