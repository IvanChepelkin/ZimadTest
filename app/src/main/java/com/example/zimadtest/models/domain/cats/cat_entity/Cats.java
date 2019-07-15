package com.example.zimadtest.models.domain.cats.cat_entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Cats {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<CatItem> data = null;

    public String getMessage() {
        return message;
    }

    public List<CatItem> getCatItemList() {
        return data;
    }
}
