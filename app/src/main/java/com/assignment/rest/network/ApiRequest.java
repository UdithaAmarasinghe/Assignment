package com.assignment.rest.network;

import com.assignment.rest.response.GetPlanetsResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("planets")
    Call<GetPlanetsResponse> getAllPlanets();

    @GET("planets/")
    Call<GetPlanetsResponse> getAllPlanetsPagination(@Query("page") String pageId);

}
