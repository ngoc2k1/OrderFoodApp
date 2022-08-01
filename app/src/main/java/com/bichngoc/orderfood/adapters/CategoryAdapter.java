package com.bichngoc.orderfood.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bichngoc.orderfood.R;
import com.bichngoc.orderfood.databinding.ViewholderCategoryBinding;
import com.bichngoc.orderfood.models.Category;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder> {
    ArrayList<Category> mCategoryList = new ArrayList<>();
    ViewholderCategoryBinding binding;

    public CategoryAdapter(ArrayList<Category> mCategoryList) {
        this.mCategoryList = mCategoryList;
    }

    @NonNull
    @Override
    public CategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryAdapter.CategoryViewHolder holder, int position) {
        Category currentCategory = mCategoryList.get(position);
//        binding.textviewViewholdercategoryName.setText(category.getName());
//        binding.imageviewViewholdercategoryPicture.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.drawable.holder_cate_click));
//        binding.imageviewViewholdercategoryPicture.setImageResource(category.getPicture());
        holder.categoryName.setText(currentCategory.getName());
//        holder.categoryPicture.setImageResource(currentCategory.getPicture());
        String pictureUrl = "";
        switch (position) {
            case 0:
                pictureUrl = "cat_1";
                holder.linearLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.color.yellow_light));
                break;
            case 4:
                pictureUrl = "image_food_02";
                holder.linearLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.color.yellow_light));
                break;
            case 1:
                pictureUrl = "image_food_03";
                holder.linearLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.color.blue_light));
                break;
            case 5:
                pictureUrl = "cat_2";
                holder.linearLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.color.blue_light));
                break;
            case 2:
            case 6:
                pictureUrl = "cat_3";
                holder.linearLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.color.orange_light));
                break;
            case 3:
                pictureUrl = "all_imagefood";
                holder.linearLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.color.green_light));
                break;
            case 7:
                pictureUrl = "image_food_01";
                holder.linearLayout.setBackground(ContextCompat.getDrawable(holder.itemView.getContext(), R.color.green_light));
                break;
        }
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(pictureUrl, "drawable", holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.categoryPicture);
    }

    @Override
    public int getItemCount() {
        return mCategoryList.size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        ImageView categoryPicture;
        LinearLayout linearLayout;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryName = itemView.findViewById(R.id.textview_viewholdercategory_name);
            categoryPicture = itemView.findViewById(R.id.imageview_viewholdercategory_picture);
            linearLayout = itemView.findViewById(R.id.viewholder_category);
        }
    }

}
