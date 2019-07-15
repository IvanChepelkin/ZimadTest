package com.example.zimadtest.view.cat_view;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.zimadtest.models.domain.cats.cat_entity.CatItem;

import java.util.List;

public class CatAdapter extends RecyclerView.Adapter<CatHolder> {
    private List<CatItem> catItemList;
    private CatItemListener catItemListener;

    public CatAdapter(CatItemListener catItemListener) {
        this.catItemListener = catItemListener;
    }

    public void setCatItemList(List<CatItem> catItemList) {
        this.catItemList = catItemList;
    }

    @NonNull
    @Override
    public CatHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return CatHolder.create(LayoutInflater.from(viewGroup.getContext()), viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull CatHolder catHolder, int position) {
        catHolder.bind(catItemList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return catItemList.size();
    }


    public interface CatItemListener {
        void onCatItemClick(int position);
    }
}
