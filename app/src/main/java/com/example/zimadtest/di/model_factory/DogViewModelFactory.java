package com.example.zimadtest.di.model_factory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.zimadtest.di.Factory;
import com.example.zimadtest.viewModels.CatViewModel;
import com.example.zimadtest.viewModels.DogViewModel;

public class DogViewModelFactory extends ViewModelProvider.NewInstanceFactory {

    public DogViewModelFactory() {
        super();
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass == DogViewModel.class) {
            return (T) new DogViewModel(Factory.createObjectDogsUseCase());
        }
        return null;
    }


}

