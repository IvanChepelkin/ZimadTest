package com.example.zimadtest.viewModels;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.support.v4.app.FragmentTransaction;

import com.example.zimadtest.di.Factory;
import com.example.zimadtest.models.domain.cats.cat_entity.CatItem;
import com.example.zimadtest.models.domain.cats.cat_entity.Cats;
import com.example.zimadtest.models.domain.cats.cat_usecase.GetCatsUseCse;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;

public class CatViewModel extends ViewModel {
    private GetCatsUseCse getCatsUseCse;
    private MutableLiveData<List<CatItem>> data;

    public CatViewModel() {
        this.getCatsUseCse = Factory.createObjectCatsUseCase();
        loadCats();
    }

    private void loadCats() {
        Single<Cats> responce = getCatsUseCse.getCats();
        responce
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<Cats>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Cats cats) {
                        data.postValue(cats.getCatItemList());

                    }

                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public LiveData<List<CatItem>> getData() {

        return data = new MutableLiveData<>();
    }
}
