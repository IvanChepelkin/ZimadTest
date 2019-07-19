package com.example.zimadtest.models.data.network.cats_remote;

import com.example.zimadtest.models.domain.cats.cat_entity.Cats;

import io.reactivex.Single;

public interface CatsRemote {
    Single<Cats> getCats();
}
