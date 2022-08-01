package com.bichngoc.orderfood.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bichngoc.orderfood.R;
import com.bichngoc.orderfood.adapters.CartListAdapter;
import com.bichngoc.orderfood.databinding.ActivityCartBinding;
import com.bichngoc.orderfood.helper.ManagementCart;
import com.bichngoc.orderfood.interfaces.ChangeNumberItemListener;

public class CartActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapter;
    private ManagementCart managementCart;
    private ActivityCartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_cart);
        managementCart = new ManagementCart(this);

        initList();
        calculateCart();
        bottomNavigation();
    }

    private void initList() {
        adapter = new CartListAdapter(managementCart.getListCart(), this, new ChangeNumberItemListener() {
            @Override
            public void change() {
                calculateCart();
            }
        });
        binding.recyclerviewCartListitem.setAdapter(adapter);
        if (managementCart.getListCart().isEmpty()) {
            binding.textviewCartEmpty.setVisibility(View.VISIBLE);
            binding.scrollviewCartOrderditems.setVisibility(View.GONE);
        } else {
            binding.textviewCartEmpty.setVisibility(View.GONE);
            binding.scrollviewCartOrderditems.setVisibility(View.VISIBLE);
        }
    }

    private void bottomNavigation() {
        binding.linearLikeAppbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this, CartActivity.class));
            }
        });
        binding.linearHomeAppbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CartActivity.this, MainActivity.class));

            }
        });
    }


    private void calculateCart() {
        double ship = 10, tax = 0.1;
        double total = managementCart.getTotalPrice() + ship;
//        binding.textviewCartTax.setText("Tax: " + tax + "");
//        binding.textviewCartTotalitem.setText("Total: " + total + "");
        binding.textviewCartTotalprice.setText("Total price: " + managementCart.getTotalPrice() + "");
    }


}