package com.example.zimadtest.models.domain.cats.cat_usecase;

import com.example.zimadtest.models.domain.cats.cat_entity.Cats;

import io.reactivex.Single;

public interface GetCatsUseCse {
    Single<Cats> getCats();
}
