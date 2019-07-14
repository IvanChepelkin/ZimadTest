package com.example.zimadtest.viewModels;

import android.arch.lifecycle.ViewModel;

import com.example.zimadtest.models.domain.dogs.dog_entity.Dogs;
import com.example.zimadtest.models.domain.dogs.dog_usecase.GetDogsUseCase;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class DogViewModel extends ViewModel {
    GetDogsUseCase getDogsUseCase;

    public DogViewModel(GetDogsUseCase getDogsUseCase) {
        this.getDogsUseCase = getDogsUseCase;
        loadDogs();
    }

    private void loadDogs() {
        Single<Dogs> responce = getDogsUseCase.getDogs();
        responce
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Dogs>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Dogs dogs) {
                        System.out.println("Собачка " + dogs.getDogItemList());

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }
}
