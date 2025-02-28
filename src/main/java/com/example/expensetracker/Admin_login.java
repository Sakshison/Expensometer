package com.example.expensetracker;
import android.annotation.SuppressLint;
import android.util.Patterns;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Admin_login extends AppCompatActivity {
    EditText email, password;
    Button button1,button2;
    Intent nintent;
    String stemail, stpassword;
    private static final String KEY_NAME="name";
    private static final String KEY_EMAIL="email";
    private static final String KEY_PASSWORD="password";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        email=findViewById(R.id.user1);
        password=findViewById(R.id.user2);
        stemail="";
        stpassword="";

        dbhelper db = new dbhelper(Admin_login.this);


        button1 = (Button) findViewById(R.id.button_login);
        button1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("Range")
            @Override
            public void onClick(View v) {
                stemail=email.getText().toString();
                stpassword=password.getText().toString();
                SharedPreferences shrd = getSharedPreferences("userdata",MODE_PRIVATE);
                if (TextUtils.isEmpty(stemail) || TextUtils.isEmpty(stpassword))
                    Toast.makeText(Admin_login.this,"All fields Required",Toast.LENGTH_SHORT).show();
                if (!Patterns.EMAIL_ADDRESS.matcher(stemail).matches())
                    Toast.makeText(Admin_login.this,"Please enter a valid email address",Toast.LENGTH_SHORT).show();
                else {
                        Cursor result = db.getpassword(stemail);
                        result.moveToFirst();
                        String uname="",uemail="",upassword="";
                        uname=result.getString(result.getColumnIndex("name"));
                        uemail=result.getString(result.getColumnIndex("email"));
                        upassword=result.getString(result.getColumnIndex("password"));
                    if(upassword.equals(stpassword)) {
                        Toast.makeText(Admin_login.this, "Login successfully", Toast.LENGTH_SHORT).show();
                        nintent = new Intent(Admin_login.this, homescreen.class);
                        startActivity(nintent);
                        SharedPreferences.Editor editor = shrd.edit();
                        editor.putString(KEY_NAME,uname);
                        editor.putString(KEY_PASSWORD,upassword);
                        editor.putString(KEY_EMAIL,uemail);
                        editor.apply();
                    }else {
                        Toast.makeText(Admin_login.this, "Login Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        button2 = (Button) findViewById(R.id.button_register);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nintent = new Intent(Admin_login.this, MainActivity.class);
                startActivity(nintent);
            }
        });

    }
}