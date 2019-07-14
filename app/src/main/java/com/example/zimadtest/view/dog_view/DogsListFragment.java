package com.example.zimadtest.view.dog_view;

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
import com.example.zimadtest.di.model_factory.ModelFactory;
import com.example.zimadtest.viewModels.DogViewModel;

public class DogsListFragment extends Fragment implements DogAdapter.ItemListener{
    private RecyclerView dogRecyclerView;
    private DogAdapter dogAdapter;
    private DogViewModel model;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dogs_fragment, container, false);

        dogRecyclerView = (RecyclerView) v.findViewById(R.id.dog_recyclerView);

        dogAdapter = new DogAdapter(this);
        dogRecyclerView.setHasFixedSize(true);
        DogAdapter dogAdapter = new DogAdapter(this);;
        dogRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        model = ViewModelProviders.of(this, new ModelFactory()).get(DogViewModel.class);
        return v;
    }

    @Override
    public void onItemClick(int position) {

    }
}


