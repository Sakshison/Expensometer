package com.example.expensetracker;

import android.content.Intent;
import android.content.SharedPreferences;
import android.opengl.GLDebugHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText name, email, password, renterpassword;
    Button button1,button2;
    Intent nintent;
    dbhelper db;
    String stname, stemail, stpassword, strenterpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name=(EditText) findViewById(R.id.yrname);
        email=(EditText) findViewById(R.id.eid);
        password=(EditText) findViewById(R.id.ep);
        renterpassword=(EditText) findViewById(R.id.cp);
        button1 = (Button) findViewById(R.id.button3);

        db = new dbhelper(this);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                stname=name.getText().toString();
                stemail=email.getText().toString();
                stpassword=password.getText().toString();
                strenterpassword=renterpassword.getText().toString();

                if(stname.equals("") || stemail.equals("") || stpassword.equals("") || strenterpassword.equals(""))
                    Toast.makeText(MainActivity.this, "All fields Required",Toast.LENGTH_SHORT).show();
                if (!Patterns.EMAIL_ADDRESS.matcher(stemail).matches())
                    Toast.makeText(MainActivity.this,"Please enter a valid email address",Toast.LENGTH_SHORT).show();
                if (stpassword.length()<5)
                    Toast.makeText(MainActivity.this,"Password must be at least 5 characters",Toast.LENGTH_SHORT).show();
                else{
                    if(stpassword.equals(strenterpassword)){
                        Boolean checkuser = db.checkemail(stemail);
                        if(checkuser==false){//user exists or not
                            Boolean regResult = db.insertData(stname,stemail, stpassword);
                            if(regResult==true) {
                                Toast.makeText(MainActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent nintent = new Intent(MainActivity.this, Admin_login.class);
                                startActivity(nintent);
                            }else{
                                Toast.makeText(MainActivity.this,"Registration Failed", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(MainActivity.this,"User already Exists", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this,"Passwords are not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        button2 = (Button) findViewById(R.id.button1);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nintent = new Intent(MainActivity.this, Admin_login.class);
                startActivity(nintent);
            }
        });
    }
}