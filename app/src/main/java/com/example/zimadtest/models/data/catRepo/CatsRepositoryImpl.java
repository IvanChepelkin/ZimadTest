package com.example.zimadtest.models.data.catRepo;

import com.example.zimadtest.models.data.network.cats_remote.CatsRemote;
import com.example.zimadtest.models.domain.cats.cat_entity.Cats;

import io.reactivex.Single;

public class CatsRepositoryImpl implements CatRepository {
    private CatsRemote catsRemote;

    public CatsRepositoryImpl(CatsRemote catsRemote) {
        this.catsRemote = catsRemote;
    }

    @Override
    public Single<Cats> getCats() {
        return catsRemote.getCats();
    }
}
