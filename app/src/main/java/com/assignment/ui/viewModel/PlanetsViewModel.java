package com.assignment.ui.viewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.assignment.rest.repository.Repository;
import com.assignment.rest.response.GetPlanetsResponse;

public class PlanetsViewModel extends AndroidViewModel {

    private final Repository repository;

    public PlanetsViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public MutableLiveData<GetPlanetsResponse> loadAllPlanets() {
        return repository.loadAllPlanets();
    }

    public MutableLiveData<GetPlanetsResponse> loadPlanetsPagination(String pageId) {
        return repository.loadPlanetsPagination(pageId);
    }
}