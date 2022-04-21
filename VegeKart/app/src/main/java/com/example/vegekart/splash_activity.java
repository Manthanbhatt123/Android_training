package com.example.vegekart;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class splash_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashactivity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent splash=new Intent(splash_activity.this,home_activity.class);
                startActivity(splash);
                finish();
            }
        },2000);
    }
}