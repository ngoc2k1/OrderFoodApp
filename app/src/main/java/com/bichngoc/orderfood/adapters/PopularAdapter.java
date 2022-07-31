package com.bichngoc.orderfood.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bichngoc.orderfood.R;
import com.bichngoc.orderfood.databinding.ViewholderPopularBinding;
import com.bichngoc.orderfood.models.Food;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PopularAdapter extends RecyclerView.Adapter<PopularAdapter.ViewHolder> {
    ArrayList<Food> mPopularList = new ArrayList<>();

    public PopularAdapter(ArrayList<Food> mPopularList) {
        this.mPopularList = mPopularList;
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
        }
    }
}
