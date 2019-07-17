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
import com.example.zimadtest.di.AppComponent;
import com.example.zimadtest.di.ViewModelProviderFactory;
import com.example.zimadtest.models.domain.dogs.dog_entity.DogItem;
import com.example.zimadtest.viewModels.DogViewModel;
import java.util.List;

import javax.inject.Inject;

public class DogsListFragment extends Fragment implements DogAdapter.DogItemListener {
    private RecyclerView dogRecyclerView;
    private DogAdapter dogAdapter;
    private DogViewModel model;

    @Inject
    ViewModelProviderFactory viewModelProviderFactory;

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

       // AppComponent appComponent = ;

        model = ViewModelProviders.of(this, viewModelProviderFactory).get(DogViewModel.class);

        LiveData<List<DogItem>> data = model.getData();
        data.observe(getViewLifecycleOwner(), new Observer<List<DogItem>>() {
            @Override
            public void onChanged(@Nullable List<DogItem> dogItems) {
                dogRecyclerView.setAdapter(dogAdapter);
                dogAdapter.setDogItemList(dogItems);
            }
        });
    }

    @Override
    public void onDogItemClick(int position) {

    }
}


