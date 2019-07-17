package com.example.zimadtest.view.cat_view;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zimadtest.R;
import com.example.zimadtest.di.ViewModelProviderFactory;
import com.example.zimadtest.models.domain.cats.cat_entity.CatItem;
import com.example.zimadtest.viewModels.CatViewModel;

import java.util.List;

import javax.inject.Inject;

public class CatsListFragment extends Fragment implements CatAdapter.CatItemListener {

    private RecyclerView catRecyclerView;
    private CatAdapter catAdapter;
    private CatViewModel model;

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.cats_fragment, container, false);
        initViews(v);
        return v;
    }

    private void initViews(View view) {
        catRecyclerView = view.findViewById(R.id.cat_recyclerView);
        catAdapter = new CatAdapter(this);
        catRecyclerView.setHasFixedSize(true);
        catRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        catAdapter = new CatAdapter(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        model = ViewModelProviders.of(this, viewModelProviderFactory).get(CatViewModel.class);

        LiveData<List<CatItem>> data = model.getData();
        data.observe(getViewLifecycleOwner(), new Observer<List<CatItem>>() {
            @Override
            public void onChanged(@Nullable List<CatItem> catItems) {
                catRecyclerView.setAdapter(catAdapter);
                catAdapter.setCatItemList(catItems);
            }

        });
    }

    @Override
    public void onCatItemClick(int position) {

    }
}
