package com.example.expensetracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class homescreen extends AppCompatActivity {
    ImageButton profile,nextexpense;
    EditText income,savings,expense;
    Spinner month,year;
    String stincome,stsavings,stexpense,stmonth,styear;
    Intent nintent;
    Button record,budget,save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homescreen);
        profile=(ImageButton)  findViewById(R.id.profile);
        nextexpense=(ImageButton) findViewById(R.id.nextexpense);
        income=(EditText) findViewById(R.id.income);
        savings=(EditText) findViewById(R.id.savings) ;
        expense=(EditText) findViewById(R.id.expense) ;
        month=(Spinner) findViewById(R.id.month) ;
        year=(Spinner) findViewById(R.id.year);
        stincome="";
        stsavings="";
        stexpense="";
        stmonth="";
        styear="";
        stincome=income.getText().toString();
        stsavings=savings.getText().toString();
        //stexpense=expense.getText().toString();
        stmonth=month.getSelectedItem().toString();
        styear=year.getSelectedItem().toString();
        dbhelper db=new dbhelper(homescreen.this);
        nextexpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double in=Double.parseDouble(stincome);
                double sav=Double.parseDouble(stsavings);
                double exp;
                exp=in-sav;
                stexpense=String.valueOf(exp);
                expense.setText(stexpense);
                }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.transacdata(stincome,stsavings,stexpense,stmonth,styear);
            }
        });
        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nintent=new Intent(homescreen.this,user_profile.class);
                startActivity(nintent);
            }
        });
        record=(Button) findViewById(R.id.record);
        record.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nintent=new Intent( homescreen.this,homescreen.class);
                startActivity(nintent);
            }
        });
        budget=(Button) findViewById(R.id.budget);
        budget.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nintent=new Intent( homescreen.this,Budget.class);
                startActivity(nintent);
            }
        });
    }
}