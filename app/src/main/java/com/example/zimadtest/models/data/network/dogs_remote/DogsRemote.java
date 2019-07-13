package com.example.zimadtest.models.data.network.dogs_remote;

import com.example.zimadtest.models.domain.dogs.dog_entity.Dogs;

import io.reactivex.Single;

public interface DogsRemote {
    Single<Dogs> getDogs();
}
