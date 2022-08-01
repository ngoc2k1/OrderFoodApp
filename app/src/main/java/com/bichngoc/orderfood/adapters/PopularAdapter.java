package com.bichngoc.orderfood.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bichngoc.orderfood.R;
import com.bichngoc.orderfood.activities.DetailActivity;
import com.bichngoc.orderfood.interfaces.IRecyclerViewListener;
import com.bichngoc.orderfood.models.Food;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    private ArrayList<Food> mPopularList;
    private IRecyclerViewListener callback;

    public PopularAdapter(ArrayList<Food> mPopularList) {
        this.mPopularList = mPopularList;
    }

    public void setCallback(IRecyclerViewListener callback) {
        this.callback = callback;
    }

    @NonNull
    @Override
    public PopularAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_popular, parent, false);
        return new PopularAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularAdapter.ViewHolder holder, int position) {
        Food currentFood = mPopularList.get(position);
        holder.name.setText(currentFood.getName());
        holder.price.setText(currentFood.getPrice() + "");

        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(currentFood.getPicture(), "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.picture);
        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), DetailActivity.class);
                intent.putExtra("clickedFood", mPopularList.get(holder.getAdapterPosition()));
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mPopularList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        ImageView picture;
        TextView price;
        TextView addToCart;
        LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.textview_viewholderpopular_name);
            picture = itemView.findViewById(R.id.imageview_viewholderpopular_picture);
            price = itemView.findViewById(R.id.textview_viewholderpopular_price);
            addToCart = itemView.findViewById(R.id.textview_viewholderpopular_addtocart);
            linearLayout = itemView.findViewById(R.id.viewholder_popular);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (callback != null) {
                        callback.onClickListener(view, getAdapterPosition());
                    }
                }
            });
        }
    }
}
