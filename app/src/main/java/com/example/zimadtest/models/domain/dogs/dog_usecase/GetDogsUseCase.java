package com.example.zimadtest.models.domain.dogs.dog_usecase;

import com.example.zimadtest.models.domain.dogs.dog_entity.Dogs;

import io.reactivex.Single;

public interface GetDogsUseCase {
    Single<Dogs> getDogs();
}
