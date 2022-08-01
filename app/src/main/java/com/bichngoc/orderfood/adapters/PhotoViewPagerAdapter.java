package com.bichngoc.orderfood.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bichngoc.orderfood.R;
import com.bichngoc.orderfood.models.PhotoSplash;

import java.util.ArrayList;

public class PhotoViewPagerAdapter extends RecyclerView.Adapter<PhotoViewPagerAdapter.ViewHolder> {
    private ArrayList<PhotoSplash> list;

    public PhotoViewPagerAdapter(ArrayList<PhotoSplash> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_splash, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        PhotoSplash imageSplash = list.get(position);
        if (imageSplash == null) return;
        holder.imageView.setImageResource(imageSplash.getResourceId());
    }

    @Override
    public int getItemCount() {
        if (list != null) return list.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageview_splash_food);

        }
    }
}
