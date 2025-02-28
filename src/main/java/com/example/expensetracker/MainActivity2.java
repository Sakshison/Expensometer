package com.example.expensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity2 extends AppCompatActivity {

    Button ad,us;
    Intent nintent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ad=(Button) findViewById(R.id.admin);
        ad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nintent=new Intent( MainActivity2.this,admin.class);
                startActivity(nintent);
            }
        });
        us=(Button) findViewById(R.id.user);
        us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nintent=new Intent( MainActivity2.this,Admin_login.class);
                startActivity(nintent);
            }
        });
        }
    }

