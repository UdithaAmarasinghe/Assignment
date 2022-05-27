package com.assignment.ui.activity;

import androidx.core.widget.NestedScrollView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.assignment.R;
import com.assignment.rest.response.GetPlanetsResponse;
import com.assignment.ui.adapter.PlanetsAdapter;
import com.assignment.ui.model.ImageProgressView;
import com.assignment.ui.viewModel.PlanetsViewModel;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @BindView(R.id.rv_plants_list)
    RecyclerView mRvPlantsList;
    @BindView(R.id.layout_nested_scrollview)
    NestedScrollView layoutNestedScrollview;
    @BindView(R.id.progress_bar)
    ImageProgressView progressBar;

    private PlanetsViewModel planetsViewModel;
    private PlanetsAdapter planetsAdapter;
    private String isNext;
    private boolean isScrolled = false;
    int page = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        planetsViewModel = ViewModelProviders.of(this).get(PlanetsViewModel.class);
        init();
    }

    private void init() {
        initPlantsListRecyclerView();
        getAllPlants();

        layoutNestedScrollview.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY == v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight()) {
                    if (isNext != null) {
                        page++;
                        isScrolled = true;
                        progressBar.setVisibility(View.VISIBLE);
                        loadPaginationDetails();
                    }
                }
            }
        });
    }

    private void initPlantsListRecyclerView() {
        planetsAdapter = new PlanetsAdapter(MainActivity.this, new ArrayList<GetPlanetsResponse.Result>(), new PlanetsAdapter.PlanetsAdapterCallback() {
            @Override
            public void onClickItem(int position, GetPlanetsResponse.Result result) {
                PlanetDetailsActivity.startActivity(mContext, result);
            }
        });
        mRvPlantsList.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        mRvPlantsList.setHasFixedSize(true);
        mRvPlantsList.setLayoutManager(new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false));
        mRvPlantsList.setAdapter(planetsAdapter);
    }

    private void getAllPlants() {
        showProgress();
        planetsViewModel.loadAllPlanets().observe(this, new Observer<GetPlanetsResponse>() {
            @Override
            public void onChanged(GetPlanetsResponse response) {
                dismissProgress();
                if (response != null) {
                    isNext = response.getNext();
                    dismissProgress();
                    planetsAdapter.addAll(response.getResults());
                }
            }
        });
    }

    private void loadPaginationDetails() {
        planetsViewModel.loadPlanetsPagination(String.valueOf(page)).observe(this, new Observer<GetPlanetsResponse>() {
            @Override
            public void onChanged(GetPlanetsResponse response) {
                if (response != null && isScrolled) {
                    progressBar.setVisibility(View.GONE);
                    isNext = response.getNext();
                    for (int x = 0; x < response.getResults().size(); x++) {
                        planetsAdapter.addItem(response.getResults().get(x));
                    }
                    isScrolled = false;
                    return;
                }
            }
        });
    }
}