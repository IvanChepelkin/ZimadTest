package com.example.zimadtest.models.data.network.client;

import com.example.zimadtest.models.domain.cats.cat_entity.Cats;
import com.example.zimadtest.models.domain.dogs.dog_entity.Dogs;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface EndPoints {
    @GET("xim/api.php?query=dog")
    Single<Dogs> getDogs();

    @GET("xim/api.php?query=cat")
    Single<Cats> getCats();
}
