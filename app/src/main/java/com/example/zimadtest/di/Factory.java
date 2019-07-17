package com.example.zimadtest.di;

import android.content.Context;

import com.example.zimadtest.models.data.catRepo.CatsRepositoryImpl;
import com.example.zimadtest.models.data.dogRepo.DogsRepositoryImpl;
import com.example.zimadtest.models.data.network.cats_remote.CatsRemoteImpl;
import com.example.zimadtest.models.data.network.client.RetrofitService;
import com.example.zimadtest.models.data.network.dogs_remote.DogsRemoteImpl;
import com.example.zimadtest.models.domain.cats.cat_usecase.GetCatsUseCaseImpl;
import com.example.zimadtest.models.domain.cats.cat_usecase.GetCatsUseCse;
import com.example.zimadtest.models.domain.dogs.dog_usecase.GetDogsUseCase;
import com.example.zimadtest.models.domain.dogs.dog_usecase.GetDogsUseCaseImpl;

public class Factory {

    private static RetrofitService createObjectRetrofitService() {
        return new RetrofitService();
    }

    private static DogsRemoteImpl createObjectDogsRemoteImpl() {
        return new DogsRemoteImpl(Factory.createObjectRetrofitService());
    }

    private static DogsRepositoryImpl createObjectDogsRepository() {
        return new DogsRepositoryImpl(Factory.createObjectDogsRemoteImpl());
    }

    public static GetDogsUseCase createObjectDogsUseCase() {
        return new GetDogsUseCaseImpl(Factory.createObjectDogsRepository());
    }

    private static CatsRemoteImpl createObjectCatsRemoteImpl() {
        return new CatsRemoteImpl(Factory.createObjectRetrofitService());
    }

    private static CatsRepositoryImpl createObjectCatsRepository() {
        return new CatsRepositoryImpl(Factory.createObjectCatsRemoteImpl());
    }

    public static GetCatsUseCse createObjectCatsUseCase() {
        return new GetCatsUseCaseImpl(Factory.createObjectCatsRepository());
    }

}
