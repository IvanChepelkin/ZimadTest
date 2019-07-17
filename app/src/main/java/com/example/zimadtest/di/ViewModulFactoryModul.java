package com.example.zimadtest.di;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class ViewModulFactoryModul {
    @Binds
    public abstract ViewModelProviderFactory bindViewModelProviderFactory(ViewModelProviderFactory viewModelProviderFactory);
}
