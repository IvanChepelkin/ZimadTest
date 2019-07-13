package com.example.zimadtest.models.domain.dogs.dog_entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DogItem {

    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("title")
    @Expose
    private String title;

    public String getUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

}