package com.example.expensetracker;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

public class splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent( splashscreen.this,
                MainActivity2.class);
        startActivity(i);
        finish();
                
            }
        }, 3000);

    }
}