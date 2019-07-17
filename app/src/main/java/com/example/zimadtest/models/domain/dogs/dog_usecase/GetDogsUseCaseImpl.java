package com.example.zimadtest.models.domain.dogs.dog_usecase;

import com.example.zimadtest.models.data.dogRepo.DogsRepositoryImpl;
import com.example.zimadtest.models.domain.dogs.dog_entity.Dogs;

import javax.inject.Inject;

import io.reactivex.Single;

public class  GetDogsUseCaseImpl implements GetDogsUseCase {

    private DogsRepositoryImpl dogsRepository;

    public GetDogsUseCaseImpl(DogsRepositoryImpl dogsRepository) {
        this.dogsRepository = dogsRepository;
    }

    @Override
    public Single<Dogs> getDogs() {
        return dogsRepository.getDogs();
    }
}
