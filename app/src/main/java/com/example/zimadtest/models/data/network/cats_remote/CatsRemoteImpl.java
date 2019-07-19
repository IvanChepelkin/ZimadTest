package com.example.zimadtest.models.data.network.cats_remote;

import com.example.zimadtest.models.data.network.client.RetrofitService;
import com.example.zimadtest.models.domain.cats.cat_entity.Cats;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class CatsRemoteImpl implements CatsRemote {
    private RetrofitService retrofitService;

    public CatsRemoteImpl(RetrofitService retrofitService) {
        this.retrofitService = retrofitService;
    }

    @Override
    public Single<Cats> getCats() {
        return retrofitService.createClient()
                .getCats()
                .subscribeOn(Schedulers.io());
    }
}
