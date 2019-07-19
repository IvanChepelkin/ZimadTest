package com.example.zimadtest.viewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.zimadtest.di.Factory;
import com.example.zimadtest.models.domain.dogs.dog_entity.DogItem;
import com.example.zimadtest.models.domain.dogs.dog_entity.Dogs;
import com.example.zimadtest.models.domain.dogs.dog_usecase.GetDogsUseCase;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class DogViewModel extends ViewModel {
    private GetDogsUseCase getDogsUseCase;
    private MutableLiveData<Dogs> data = new MutableLiveData<>();

    public DogViewModel() {
        this.getDogsUseCase = Factory.createObjectDogsUseCase();
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

                            data.postValue(dogs);
                        }

                        @Override
                        public void onError(Throwable e) {

                        }
                    });
    }

    public LiveData<Dogs> getData() {

        return data;
    }

}
