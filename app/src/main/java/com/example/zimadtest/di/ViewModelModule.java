package com.example.zimadtest.di;

import android.arch.lifecycle.ViewModel;

import com.example.zimadtest.viewModels.CatViewModel;
import com.example.zimadtest.viewModels.DogViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

@Module
public abstract class ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(DogViewModel.class)
    public abstract ViewModel bindDogViewModul(DogViewModel dogViewModel);

    @Binds
    @IntoMap
    @ViewModelKey(CatViewModel.class)
    public abstract ViewModel bindCatViewModul(CatViewModel catViewModel);
}
