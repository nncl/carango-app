package com.fiap.carango.model;

import com.google.gson.annotations.SerializedName;

/**
 * 1. Getters and Setters/Constructor
 * 2. Import libraries into app gradle
 */

public class Car {

    @SerializedName("nome") // if it is not the same name
    private String name;
    @SerializedName("desc")
    private String description;
    @SerializedName("foto")
    private String image;

    public Car(String name, String description, String image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
