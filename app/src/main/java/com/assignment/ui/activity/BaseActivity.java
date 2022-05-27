package com.assignment.ui.activity;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.assignment.R;

public abstract class BaseActivity extends AppCompatActivity {

    public Context mContext;
    private Dialog mProgress;

    public BaseActivity() {
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    public void showProgress() {
        try {
            if (mProgress == null) {

                mProgress = new ProgressDialog(mContext, R.style.Progressbar);
                mProgress.getWindow().setBackgroundDrawable(new
                        ColorDrawable(android.graphics.Color.TRANSPARENT));
                //mProgress.(true);
                mProgress.setCancelable(false);
                mProgress.show();
                mProgress.setContentView(R.layout.dialog_progress_spinner);

            }

            if (mProgress != null) {
                if (mProgress.isShowing() == false) {
                    mProgress.show();
                }
            }
        } catch (Exception e) {

        }
    }

    public void dismissProgress() {
        try {
            if (mProgress != null) {
                if (mProgress.isShowing()) {
                    mProgress.dismiss();
                    mProgress = null;
                }
            }
        } catch (Exception _e) {

        }
    }
}
