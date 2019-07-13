package com.example.zimadtest.models.domain.dogs.dog_entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Dogs {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("dogItemList")
    @Expose
    private List<DogItem> dogItemList;

    public String getMessage() {
        return message;
    }

    public List<DogItem> getDogItemList() {
        return dogItemList;
    }

}
