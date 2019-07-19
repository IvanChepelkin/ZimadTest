package com.example.zimadtest.models.data.dogRepo;

import com.example.zimadtest.models.domain.dogs.dog_entity.Dogs;

import io.reactivex.Single;

public interface DogsRepository {
    Single<Dogs> getDogs();
}
