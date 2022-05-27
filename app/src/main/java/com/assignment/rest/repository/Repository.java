package com.assignment.rest.repository;

import static android.content.ContentValues.TAG;

import android.app.Application;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.assignment.rest.network.ApiRequest;
import com.assignment.rest.network.RetrofitClient;
import com.assignment.rest.response.GetPlanetsResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Repository {

    private static final String TAG = Repository.class.getSimpleName();

    private final MutableLiveData<GetPlanetsResponse> loadAllPlanets;
    private final MutableLiveData<GetPlanetsResponse> loadPlanetsPagination;

    public Repository(Application application) {
        loadAllPlanets = new MutableLiveData<>();
        loadPlanetsPagination = new MutableLiveData<>();
    }

    public MutableLiveData<GetPlanetsResponse> loadAllPlanets(){

        Call<GetPlanetsResponse> call = RetrofitClient.getInstance().apiRequest().getAllPlanets();
        call.enqueue(new Callback<GetPlanetsResponse>() {
            @Override
            public void onResponse(Call<GetPlanetsResponse> call, Response<GetPlanetsResponse> response) {
                if(response.code() == 200) {
                    Log.d(TAG, "onResponse" + response);
                    loadAllPlanets.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<GetPlanetsResponse> call, Throwable t) {
                loadAllPlanets.postValue(null);
            }
        });
        return loadAllPlanets;
    }

    public MutableLiveData<GetPlanetsResponse> loadPlanetsPagination(String pageId){
        loadPlanetsPagination.setValue(null);
        Call<GetPlanetsResponse> call = RetrofitClient.getInstance().apiRequest().getAllPlanetsPagination(pageId);
        call.enqueue(new Callback<GetPlanetsResponse>() {
            @Override
            public void onResponse(Call<GetPlanetsResponse> call, Response<GetPlanetsResponse> response) {
                if(response.code() == 200) {
                    Log.d(TAG, "onResponse " + response);
                    loadPlanetsPagination.setValue(response.body());
                }
            }
            @Override
            public void onFailure(Call<GetPlanetsResponse> call, Throwable t) {
                loadPlanetsPagination.postValue(null);
            }
        });
        return loadPlanetsPagination;
    }
}
