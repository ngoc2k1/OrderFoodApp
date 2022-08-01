package com.bichngoc.orderfood.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bichngoc.orderfood.R;
import com.bichngoc.orderfood.helper.ManagementCart;
import com.bichngoc.orderfood.interfaces.ChangeNumberItemListener;
import com.bichngoc.orderfood.models.Food;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {
    private ArrayList<Food> foodList;
    private ManagementCart managementCart;
    private ChangeNumberItemListener changeNumberItemListener;

    public CartListAdapter(ArrayList<Food> foodList, Context context, ChangeNumberItemListener changeNumberItemListener) {
        this.foodList = foodList;
        this.managementCart = new ManagementCart(context);
        this.changeNumberItemListener = changeNumberItemListener;
    }

    @NonNull
    @Override
    public CartListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartListAdapter.ViewHolder holder, int position) {

        Food food = foodList.get(position);
        holder.name.setText(food.getName());
        holder.price_unit.setText(food.getPrice() + "");
        holder.total_item.setText(food.getNumberInCart() + "");
        holder.total_price.setText(food.getPrice() * food.getNumberInCart() + "");
        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(food.getPicture(), "drawable",
                holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableResourceId)
                .into(holder.picture);
        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.deleteNumberFood(foodList, holder.getAdapterPosition(), new ChangeNumberItemListener() {
                    @Override
                    public void change() {
                        notifyDataSetChanged();
                        changeNumberItemListener.change();
                        //empty xuat hien
                        //thong bao delete,minus
//                        Toast.makeText(view.getContext(), "deleted " + foodList.get(holder.getAdapterPosition()).getName(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.plusNumberFood(foodList, holder.getAdapterPosition(), new ChangeNumberItemListener() {
                    @Override
                    public void change() {
                        notifyDataSetChanged();
                        changeNumberItemListener.change();
                    }
                });
            }
        });
        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                managementCart.minusNumberFood(foodList, holder.getAdapterPosition(), new ChangeNumberItemListener() {
                    @Override
                    public void change() {
                        notifyDataSetChanged();
                        changeNumberItemListener.change();
                    }
                });
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, price_unit, total_price, total_item;
        ImageView picture, minus, plus;
        ImageButton delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            plus = itemView.findViewById(R.id.imagebutton_holdercart_plus);
            minus = itemView.findViewById(R.id.imagebutton_holdercart_minus);
            picture = itemView.findViewById(R.id.imageview_holdercart_picture);
            price_unit = itemView.findViewById(R.id.textview_holdercart_priceunit);
            name = itemView.findViewById(R.id.textview_holdercart_name);
            total_item = itemView.findViewById(R.id.textview_holdercart_quantity);
            total_price = itemView.findViewById(R.id.textview_holdercart_total);
            delete = itemView.findViewById(R.id.imagebutton_holdercart_delete);
        }
    }
}
