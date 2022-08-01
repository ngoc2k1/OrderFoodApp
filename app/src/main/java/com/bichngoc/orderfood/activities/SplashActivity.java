package com.bichngoc.orderfood.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bichngoc.orderfood.R;
import com.bichngoc.orderfood.adapters.PhotoSplashAdapter;
import com.bichngoc.orderfood.databinding.ActivitySplashBinding;
import com.bichngoc.orderfood.models.PhotoSplash;

import java.util.ArrayList;


public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding binding;
    private ArrayList<PhotoSplash> listPhotoFood;
    private PhotoSplashAdapter imageSplashAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash);

        initData();
        imageSplashAdapter = new PhotoSplashAdapter(listPhotoFood);
        binding.viewpager2Splash.setAdapter(imageSplashAdapter);
        binding.circleIndicator3Splash.setViewPager(binding.viewpager2Splash);
        binding.buttonSplashGetstarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initData() {
        listPhotoFood = new ArrayList<>();
        listPhotoFood.add(new PhotoSplash(R.drawable.cat_1));
        listPhotoFood.add(new PhotoSplash(R.drawable.image_food_02));
        listPhotoFood.add(new PhotoSplash(R.drawable.image_food_03));
        listPhotoFood.add(new PhotoSplash(R.drawable.cat_2));
        listPhotoFood.add(new PhotoSplash(R.drawable.image_food_01));
    }
}

