package com.example.zimadtest.di.model_factory;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.support.annotation.NonNull;

import com.example.zimadtest.di.Factory;
import com.example.zimadtest.viewModels.CatViewModel;

public class CatViewModelFactory extends ViewModelProvider.NewInstanceFactory {
//    public CatViewModelFactory() {
//        super();
//    }
//
//    @NonNull
//    @Override
//    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
//        if (modelClass == CatViewModel.class) {
//            return (T) new CatViewModel(Factory.createObjectCatsUseCase());
//        }
//        return null;
//    }
}
