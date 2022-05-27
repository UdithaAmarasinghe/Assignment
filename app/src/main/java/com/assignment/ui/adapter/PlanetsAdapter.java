package com.assignment.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.assignment.R;
import com.assignment.rest.response.GetPlanetsResponse;
import com.assignment.ui.model.ImageProgressView;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlanetsAdapter extends RecyclerView.Adapter<PlanetsAdapter.Holder> {

    private Context mContext;
    private List<GetPlanetsResponse.Result> mDataSet;
    private PlanetsAdapterCallback mCallback;

    public PlanetsAdapter(Context mContext, List<GetPlanetsResponse.Result> mDataSet, PlanetsAdapterCallback callback) {
        this.mContext = mContext;
        this.mDataSet = mDataSet;
        mCallback = callback;
    }

    public void addAll(final List<GetPlanetsResponse.Result> dataSet) {
        mDataSet.clear();
        notifyDataSetChanged();
        mDataSet.addAll(dataSet);
        notifyDataSetChanged();
    }

    public void addItem(GetPlanetsResponse.Result item) {
        mDataSet.add(item);
        notifyDataSetChanged();
    }

    public void remove(int index) {
        mDataSet.remove(index);
        notifyDataSetChanged();
    }

    public void clear() {
        if (mDataSet != null) {
            mDataSet.clear();
            notifyDataSetChanged();
        }
    }

    public List<GetPlanetsResponse.Result> getDataSet() {
        return mDataSet;
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_planets, parent, false));
    }

    @Override
    public void onBindViewHolder(final @NonNull Holder holder, int i) {

        GetPlanetsResponse.Result datum = mDataSet.get(i);
        holder.txtPlant.setText(datum!=null ? datum.getName() : "");
        holder.txtClimate.setText(datum!=null ? datum.getClimate() : "");

        Picasso.get().load("https://picsum.photos/300/500")
                .into(holder.icon, new Callback() {
                    @Override
                    public void onSuccess() {
                        holder.imgProgressView.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Exception e) {
                        holder.imgProgressView.setPlaceHolderVisible(View.VISIBLE);
                    }
                });
    }

    @Override
    public int getItemCount() {
        return mDataSet!=null ? mDataSet.size() : 0;
    }

    public class Holder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        @BindView(R.id.txt_plant)
        TextView txtPlant;
        @BindView(R.id.txt_climate)
        TextView txtClimate;
        @BindView(R.id.img)
        ImageView icon;
        @BindView(R.id.img_progress_view)
        ImageProgressView imgProgressView;

        public Holder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            mCallback.onClickItem(getAdapterPosition(),  mDataSet.get(getAdapterPosition()));
        }
    }

    public interface PlanetsAdapterCallback {
        void onClickItem(int position, GetPlanetsResponse.Result result);
    }
}