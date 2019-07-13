package com.example.zimadtest.models.domain.dogs.dog_entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DogsArray {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("dogItemList")
    @Expose
    private List<DogItem> dogItemList = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DogItem> getDogItemList() {
        return dogItemList;
    }

    public void setDogItemList(List<DogItem> dogItemList) {
        this.dogItemList = dogItemList;
    }

}
