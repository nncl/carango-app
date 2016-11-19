package com.fiap.carango.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * 1. Getters and Setters/Constructor
 * 2. Import libraries into app gradle
 */

public class Car implements Parcelable {

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

    protected Car(Parcel in) {
        name = in.readString();
        description = in.readString();
        image = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(image);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Car> CREATOR = new Creator<Car>() {
        @Override
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        @Override
        public Car[] newArray(int size) {
            return new Car[size];
        }
    };

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
