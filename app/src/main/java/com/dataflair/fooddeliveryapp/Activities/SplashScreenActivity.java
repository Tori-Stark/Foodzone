package com.dataflair.fooddeliveryapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.dataflair.fooddeliveryapp.R;





public class SplashScreenActivity extends AppCompatActivity {
    private static int SPLASH_SCREEN = 4000;

    Animation topAnim,bottomAnim;
    ImageView splashImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);


        topAnim = AnimationUtils.loadAnimation(this,R.anim.top_animation);
        bottomAnim = AnimationUtils.loadAnimation(this,R.anim.bottom_animation);

        splashImage = findViewById(R.id.imageView);
//        splashDescription = findViewById(R.id.splashIntro);

        splashImage.setAnimation(topAnim);
//        splashDescription.setAnimation(bottomAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this,GetStartedActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);



    }
}