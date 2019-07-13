package com.example.zimadtest.models.domain.dogs.dog_entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DogsArray {

    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<DogItem> data = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DogItem> getData() {
        return data;
    }

    public void setData(List<DogItem> data) {
        this.data = data;
    }

}
