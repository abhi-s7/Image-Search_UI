package com.abhi.imagesearch.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.abhi.imagesearch.ui.R;

public class SplashScreen extends AppCompatActivity {


    public static int SPLASH_TIME_OUT = 1500;
    protected Animation fadeIn;
    protected ImageView img1;
//    protected TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.SplashScreenTheme);
//        if (Build.VERSION.SDK_INT >= 21) {
//            getWindow().setNavigationBarColor(getResources().getColor(R.color.daps_logo_color));
//            getWindow().setStatusBarColor(getResources().getColor(R.color.daps_logo_color));
//        }
        setContentView(R.layout.activity_splash_screen);

        fadeIn = AnimationUtils.loadAnimation(this,R.anim.fadein);


        img1 = findViewById(R.id.imageView);
        img1.setVisibility(View.VISIBLE);
        img1.startAnimation(fadeIn);
        new Handler().postDelayed(new Runnable(){
            public void run(){                                         //delay for screen
                Intent navi = new Intent(SplashScreen.this, WhatYouAreLookingFor.class);
//                navi.putExtra("query", "suzuki");
                startActivity(navi);
                finish();                                                        //to end the activity
                //    overridePendingTransition(R.anim.fadein,R.anim.fadeout);
            }
        },SPLASH_TIME_OUT);
    }
}
