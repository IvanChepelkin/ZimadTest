package com.example.zimadtest.view.dog_view;

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
import com.example.zimadtest.models.domain.dogs.dog_entity.Dogs;
import com.example.zimadtest.viewModels.DogViewModel;

public class DogsListFragment extends Fragment implements DogAdapter.DogItemListener {
    private RecyclerView dogRecyclerView;
    private DogAdapter dogAdapter;
    private DogViewModel dogViewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dogs_fragment, container, false);
        initViews(v);
        return v;
    }

    private void initViews(View view) {
        dogRecyclerView = view.findViewById(R.id.dog_recyclerView);
        dogAdapter = new DogAdapter(this);
        dogRecyclerView.setHasFixedSize(true);
        dogRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        dogAdapter = new DogAdapter(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        dogViewModel = ViewModelProviders.of(this).get(DogViewModel.class);

        LiveData<Dogs> data = dogViewModel.getData();
        data.observe(this, new Observer<Dogs>() {
            @Override
            public void onChanged(@Nullable Dogs dogs) {
                dogRecyclerView.setAdapter(dogAdapter);
                dogAdapter.setDogs(dogs);
            }
        });
    }

    @Override
    public void onDogItemClick(int position) {

    }
}


