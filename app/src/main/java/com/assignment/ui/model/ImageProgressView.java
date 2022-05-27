package com.assignment.ui.model;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import androidx.annotation.IntDef;
import androidx.annotation.Nullable;

import com.assignment.R;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class ImageProgressView extends RelativeLayout {

    private RelativeLayout mLayoutContainer;
    private ProgressBar mProgressBar;
    private Context mContext;

    public ImageProgressView(Context context) {
        super(context);
        mContext = context;
        initializeView(context);
    }

    public ImageProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initializeView(context);
    }

    public ImageProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initializeView(context);
    }

    private void initializeView(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.view_image_progress_view, this);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mLayoutContainer = (RelativeLayout) findViewById(R.id.progress_content);
        mProgressBar = (ProgressBar) findViewById(R.id.progress);
    }

    public void setBackgroundColour(int colour) {
        mLayoutContainer.setBackgroundColor(colour);
    }

    public void setVisible(@Visibility int visibility) {
        mLayoutContainer.setVisibility(visibility);
    }

    public void setPlaceHolderVisible(@Visibility int visibility) {
       mProgressBar.setVisibility(visibility == VISIBLE ? GONE : VISIBLE);
    }

    @IntDef({VISIBLE, INVISIBLE, GONE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Visibility {
    }
}
