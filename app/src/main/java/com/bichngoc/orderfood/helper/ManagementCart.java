package com.bichngoc.orderfood.helper;

import android.content.Context;
import android.widget.Toast;

import com.bichngoc.orderfood.models.Food;

import java.util.ArrayList;

public class ManagementCart {
    private Context mContext;
    private Database mDatabase;

    public ManagementCart(Context mContext, Database mDatabase) {
        this.mContext = mContext;
        this.mDatabase = mDatabase;
    }

    public void insertFood(Food food) {
        ArrayList<Food> listFood = getListCart();
        boolean existAlready = false;
        int n = 0;
        for (int i = 0; i < listFood.size(); i++) {
            if (listFood.get(i).getName().equals(food.getName())) {
                existAlready = true;
                n = i;
                break;
            }
        }
        if (existAlready) {
            listFood.get(n).setNumberInCart(food.getNumberInCart());
        } else {
            listFood.add(food);
        }
        mDatabase.putListObject("cartList", listFood);
        Toast.makeText(mContext, "Added to your cart", Toast.LENGTH_LONG).show();
    }

    public ArrayList<Food> getListCart() {
        return mDatabase.getListObject("CartList");
    }
}
