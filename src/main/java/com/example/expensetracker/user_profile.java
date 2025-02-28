package com.example.expensetracker;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.SimpleTimeZone;

public class user_profile extends AppCompatActivity {
    EditText etname, etemail, etnewpass, etconpass;
    Button logout,deleteacc,save ;
    String name;
    private static final String KEY_NAME = "name";
    private static final String KEY_EMAIL = "email";
    private static final String KEY_PASS = "password";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        etname = findViewById(R.id.et1);
        etemail = findViewById(R.id.et2);
        etnewpass = findViewById(R.id.et3);
        etconpass = findViewById(R.id.et4);
        name="";
        dbhelper mydb = new dbhelper(user_profile.this);
        SharedPreferences getShared = getSharedPreferences("userdata", MODE_PRIVATE);


        String value = getShared.getString(KEY_NAME, null);
        String value1 = getShared.getString(KEY_EMAIL, null);
        String value2 = getShared.getString(KEY_PASS, null);
        if (value != null || value1 != null || value2 != null) {
            etname.setText(value);
            etemail.setText(value1);
            etnewpass.setText(value2);
        }
        deleteacc = (Button) findViewById(R.id.deleteaccount);
        deleteacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=etname.getText().toString();
                mydb.deleteaccount(name);
                Toast.makeText(user_profile.this, "Account deleted", Toast.LENGTH_LONG).show();

            }
        });
    }
}