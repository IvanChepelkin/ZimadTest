package com.example.zimadtest.models.domain.cats.cat_usecase;

import com.example.zimadtest.models.data.catRepo.CatRepository;
import com.example.zimadtest.models.domain.cats.cat_entity.Cats;

import io.reactivex.Single;

public class GetCatsUseCaseImpl implements GetCatsUseCse {
    private CatRepository catRepository;

    public GetCatsUseCaseImpl(CatRepository catRepository) {
        this.catRepository = catRepository;
    }

    @Override
    public Single<Cats> getCats() {
        return catRepository.getCats();
    }
}
