package com.example.zimadtest.di;

import com.example.zimadtest.models.data.dogRepo.DogsRepositoryImpl;
import com.example.zimadtest.models.data.network.client.RetrofitService;
import com.example.zimadtest.models.data.network.dogs_remote.DogsRemoteImpl;
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
}
