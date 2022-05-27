package com.assignment.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.TextureView;
import android.widget.TextView;

import com.assignment.R;
import com.assignment.rest.response.GetPlanetsResponse;
import com.assignment.utils.AppConstants;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlanetDetailsActivity extends BaseActivity {

    @BindView(R.id.txt_planet_name_value)
    TextView txtPlanetNameValue;
    @BindView(R.id.txt_orbital_period_value)
    TextView txtOrbitalPeriodValue;
    @BindView(R.id.txt_gravity_value)
    TextView txtGravityValue;

    private GetPlanetsResponse.Result mResult;

    public static void startActivity(Context context, GetPlanetsResponse.Result result) {
        Intent intent = new Intent(context, PlanetDetailsActivity.class);
        intent.putExtra(AppConstants.PLANETS_RESULT, result);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planet_details);
        ButterKnife.bind(this);
        init();
    }

    private void init(){
        mResult = (GetPlanetsResponse.Result) getIntent().getSerializableExtra(AppConstants.PLANETS_RESULT);
        txtPlanetNameValue.setText(mResult.getName() != null ? mResult.getName() : "");
        txtOrbitalPeriodValue.setText(mResult.getOrbitalPeriod() != null ? mResult.getOrbitalPeriod() : "");
        txtGravityValue.setText(mResult.getGravity() != null ? mResult.getGravity() : "");
    }
}