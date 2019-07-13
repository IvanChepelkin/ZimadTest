package com.example.zimadtest.models.data.network.client;

import com.example.zimadtest.models.domain.dogs.dog_entity.Dogs;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface EndPoints {
    @GET()
    Single<Dogs> getUserList();
}
