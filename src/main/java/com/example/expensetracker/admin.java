
package com.example.expensetracker;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class admin extends AppCompatActivity {

    EditText etid,etpass;
    Button btlogin;
    String stpass,stid;
    Intent nintent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        etid=(EditText) findViewById(R.id.adminid);
        etpass=(EditText) findViewById(R.id.adminpass);
        btlogin=(Button) findViewById(R.id.adminlogin);
        stid="";
        stpass="";

        btlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stid=etid.getText().toString();
                stpass=etpass.getText().toString();
                if (stid.equals("") || stpass.equals(""))
                    Toast.makeText(admin.this, "All fields Required", Toast.LENGTH_SHORT).show();
                if (stid.equals("Sakshi Soni") && stpass.equals("sakshis")) {
                    Toast.makeText(admin.this, "Welcome", Toast.LENGTH_SHORT).show();
                    nintent = new Intent(admin.this, homescreen.class);
                    startActivity(nintent);
                }
                else {
                    Toast.makeText(admin.this, "Login Failed", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}