package com.example.expensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Budget extends AppCompatActivity {
    ImageButton back;
    Intent nintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budget);
        back = (ImageButton)  findViewById(R.id.mymoney);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nintent = new Intent(Budget.this, homescreen.class);
                startActivity(nintent);
            }
        });
    }
}