package com.com.myamoresms.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.com.myamoresms.R;

public class SplashActivity extends AppCompatActivity {
    Animation app_spash;
    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //load animation
        app_spash = AnimationUtils.loadAnimation(this, R.anim.app_splash_slogan);

        //load element
        logo = findViewById(R.id.logosplash);

        //run animation
        logo.startAnimation(app_spash);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //gantin ke activity lain
                Intent gogetstarted =new Intent(SplashActivity.this, GetStartedActivity.class);
                startActivity(gogetstarted);
                finish();
            }
        }, 2000); //delay 2 detik
    }
}