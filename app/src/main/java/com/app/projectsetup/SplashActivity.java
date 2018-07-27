package com.app.projectsetup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import com.app.projectsetup.utils.Util;

public class SplashActivity extends AppCompatActivity {

    //todo:implement your splash activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Util.hideSystemUI(this);

        TextView textView = findViewById(R.id.textView);
        startAnimation(textView);
    }

    private void startAnimation(View view) {
        TranslateAnimation translateAnimation =  new TranslateAnimation(0,0,Util.getDeviceHeight(this),0);
        translateAnimation.setDuration(1500);
        translateAnimation.setFillAfter(true);
        translateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (!isFinishing()){
                    Util.startHomeActivity(SplashActivity.this,new Bundle());
                    Util.startHomeActivity(SplashActivity.this,new Bundle());
                    finish();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        view.startAnimation(translateAnimation);
    }
}
