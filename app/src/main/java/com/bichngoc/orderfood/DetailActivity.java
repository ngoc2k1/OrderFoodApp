package com.bichngoc.orderfood;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bichngoc.orderfood.databinding.ActivityDetailBinding;
import com.bichngoc.orderfood.helper.ManagementCart;
import com.bichngoc.orderfood.models.Food;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private Food clickedFood;
    private ActivityDetailBinding binding;
    private int quantityOrder = 1;
    private ManagementCart managementCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail);
        getBundle();
    }

    private void getBundle() {
        clickedFood = (Food) getIntent().getSerializableExtra("clickedFood");
        int drawableResourceId = this.getResources().getIdentifier(clickedFood.getPicture(), "drawable", this.getPackageName());
        Glide.with(this).load(drawableResourceId).into(binding.imageviewDetailFood);
        binding.textviewDetailName.setText(clickedFood.getName() + "");
        binding.textviewDetailPrice.setText(clickedFood.getPrice() + "");
        binding.textviewDetailDescription.setText(clickedFood.getDescription() + "");
        binding.textviewDetailQuantity.setText(quantityOrder + "");
        binding.imagebuttonDetailPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantityOrder += 1;
                binding.textviewDetailQuantity.setText(quantityOrder + "");
                Toast.makeText(getApplicationContext(), "+1", Toast.LENGTH_SHORT).show();
            }
        });

        binding.imagebuttonDetailMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantityOrder > 1) {
                    quantityOrder -= 1;
                }
                binding.textviewDetailQuantity.setText(quantityOrder + "");
                Toast.makeText(getApplicationContext(), "-1", Toast.LENGTH_SHORT).show();
            }
        });
        binding.imagebuttonDetailBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}