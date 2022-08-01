package com.bichngoc.orderfood.helper;

import android.content.Context;
import android.widget.Toast;

import com.bichngoc.orderfood.interfaces.ChangeNumberItemListener;
import com.bichngoc.orderfood.models.Food;

import java.util.ArrayList;

public class ManagementCart {
    private Context mContext;
    private Database mDatabase;

    public ManagementCart(Context mContext) {
        this.mContext = mContext;
        this.mDatabase = new Database(mContext);
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
        mDatabase.putListObject("CartList", listFood);
        Toast.makeText(mContext, "Added to your cart", Toast.LENGTH_SHORT).show();
    }

    public ArrayList<Food> getListCart() {
        return mDatabase.getListObject("CartList");
    }

    public void plusNumberFood(ArrayList<Food> list, int pos, ChangeNumberItemListener changeNumberItemListener) {
        list.get(pos).setNumberInCart(list.get(pos).getNumberInCart() + 1);
        mDatabase.putListObject("CartList", list);
        changeNumberItemListener.change();
    }

    public void minusNumberFood(ArrayList<Food> list, int pos, ChangeNumberItemListener changeNumberItemListener) {
        if (list.get(pos).getNumberInCart() == 1) {
            list.remove(pos);
        } else list.get(pos).setNumberInCart(list.get(pos).getNumberInCart() - 1);
        mDatabase.putListObject("CartList", list);
        changeNumberItemListener.change();
    }

    public void deleteNumberFood(ArrayList<Food> list, int pos, ChangeNumberItemListener changeNumberItemListener) {
        list.remove(pos);
        mDatabase.putListObject("CartList", list);
        changeNumberItemListener.change();
    }

    public Double getTotalPrice() {
        ArrayList<Food> list = getListCart();
        double price = 0;
        for (int i = 0; i < list.size(); i++) {
            price = price + (list.get(i).getPrice() * list.get(i).getNumberInCart());

        }
        return price;
    }
}
