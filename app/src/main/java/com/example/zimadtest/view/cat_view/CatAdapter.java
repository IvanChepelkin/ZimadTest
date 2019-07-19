package com.example.zimadtest.view.cat_view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.zimadtest.models.domain.cats.cat_entity.CatItem;
import com.example.zimadtest.models.domain.cats.cat_entity.Cats;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatHolder> {
    private Cats cats;
    private CatItemListener catItemListener;

    public CatAdapter(CatItemListener catItemListener) {
        this.catItemListener = catItemListener;
    }

    public void setCatItemList(Cats cats) {
        this.cats = cats;
    }

    @NonNull
    @Override
    public CatHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return CatHolder.create(LayoutInflater.from(viewGroup.getContext()), viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull CatHolder catHolder, int position) {
        catHolder.bind(cats.getCatItemList().get(position), position, cats.getMessage(), catItemListener);
    }

    @Override
    public int getItemCount() {
        return cats.getCatItemList().size();
    }


    public interface CatItemListener {
        void onCatItemClick(int position);
    }
}
