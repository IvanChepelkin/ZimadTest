package com.example.zimadtest.models.data.dogRepo;

import com.example.zimadtest.models.data.network.dogs_remote.DogsRemoteImpl;
import com.example.zimadtest.models.domain.dogs.dog_entity.Dogs;

import io.reactivex.Single;

public class DogsRepositoryImpl implements DogsRepository {
    DogsRemoteImpl dogsRemote;

    public DogsRepositoryImpl(DogsRemoteImpl dogsRemote) {
        this.dogsRemote = dogsRemote;
    }

    @Override
    public Single<Dogs> getDogs() {
        return dogsRemote.getDogs();
    }
}
