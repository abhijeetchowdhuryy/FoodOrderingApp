package com.example.sizzlingbitesapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sizzlingbitesapp.DynamicRVModel;
import com.example.sizzlingbitesapp.R;

import java.util.ArrayList;

public class DynamicRvAdapter extends RecyclerView.Adapter<DynamicRvAdapter.DynamicRvHolder> {

    public ArrayList<DynamicRVModel> dynamicRVModels;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener mListener) {
        this.mListener = mListener;
    }

    public DynamicRvAdapter(ArrayList<DynamicRVModel> dynamicRVModels) {
        this.dynamicRVModels = dynamicRVModels;
    }

    public class DynamicRvHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public ImageView imageView;
        public TextView textView;

        public TextView details;

        ConstraintLayout constraintLayout;

        public DynamicRvHolder(@NonNull View itemView, final OnItemClickListener mListener) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image);
            textView = itemView.findViewById(R.id.name);
            constraintLayout = itemView.findViewById(R.id.constraintLayout2);
            details = itemView.findViewById(R.id.details);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View view) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(position);
                }
            }
        }
    }

    @NonNull
    @Override
    public DynamicRvAdapter.DynamicRvHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dynamic_rv_item_layout, parent, false);
        return new DynamicRvHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(@NonNull DynamicRvAdapter.DynamicRvHolder holder, int position) {
        DynamicRVModel currentItem = dynamicRVModels.get(position);
        holder.imageView.setImageResource(currentItem.getImage());
        holder.textView.setText(currentItem.getName());
        holder.details.setText(currentItem.getDetails());
    }

    @Override
    public int getItemCount() {
        return dynamicRVModels.size();
    }
}
