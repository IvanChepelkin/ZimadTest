package com.example.zimadtest.models.data.network.dogs_remote;

import com.example.zimadtest.models.data.network.client.RetrofitService;
import com.example.zimadtest.models.domain.dogs.dog_entity.Dogs;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class DogsRemoteImpl implements DogsRemote {
    private RetrofitService retrofitService;
    private String BASE_URL = "http://kot3.com/xim/api.php?query=dog";

    public DogsRemoteImpl(RetrofitService retrofitService) {
        this.retrofitService = retrofitService;
    }

    @Override
    public Single<Dogs> getDogs() {
        return retrofitService.createClient(BASE_URL)
                .getDogs()
                .subscribeOn(Schedulers.io());
    }
}
