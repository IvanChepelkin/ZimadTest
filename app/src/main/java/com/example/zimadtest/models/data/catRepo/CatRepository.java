package com.example.zimadtest.models.data.catRepo;

import com.example.zimadtest.models.domain.cats.cat_entity.Cats;

import io.reactivex.Single;

public interface CatRepository {
    Single<Cats> getCats();
}
