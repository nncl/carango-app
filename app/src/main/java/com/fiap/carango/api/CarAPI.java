package com.fiap.carango.api;

import com.fiap.carango.model.Car;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Contracts, YO!! Only rules, not implementation
 */
public interface CarAPI {

    // @path (/cars/type/{}) != @query (?q=)
    @GET("/carros/tipo/{tipo}")
    Call<List<Car>> findBy(@Path("tipo") String tipo);

}
