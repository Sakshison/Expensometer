package com.example.expensetracker;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.DatePicker;

import java.math.BigDecimal;

public class dbhelper extends SQLiteOpenHelper
{
    public static final String DB_NAME = "user.db";
    public dbhelper(Context context) {
        super(context, "user.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase mydb) {
        mydb.execSQL("create table registration(reg_id PRIMARY KEY, name text,email varchar,password text)");
        mydb.execSQL("create table transac(t_id PRIMARY KEY, income varchar,savings varchar,expense varchar, month varchar,year varchar)");
    }
    @Override
    public void onUpgrade(SQLiteDatabase mydb, int oldversion, int newversion)
    {
        mydb.execSQL("Drop table if exists registration");
        mydb.execSQL("Drop table if exists transac");
    }
    public Boolean insertData(String name, String email, String password)
    {
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("password", password);
        long result = mydb.insert("registration", null,values);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public void transacdata(String income,String savings,String expense, String month,String year)
    {
        SQLiteDatabase mydb = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("income", income);
        values.put("savings",savings);
        values.put("expense",expense);
        values.put("month",month);
        values.put("year",year);
        long result = mydb.insert("transac", null,values);
    }
    public Boolean checkemail(String email)
    {

        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor cursor = mydb.rawQuery("select * from registration where email = ?",new String[] {email});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }
   /* public Boolean checkemailpassword( String email,String password)
    {

        SQLiteDatabase mydb = this.getWritableDatabase();
        Cursor cursor = mydb.rawQuery("select * from registration where email = ? and password =  ?",new String[] {email,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }*/
    public Integer deleteaccount(String name)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("registration", "name = ?", new String[] {name});
    }
    public Cursor getpassword(String uemail)
    {

        Cursor res=null;
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            res = db.rawQuery("select * from registration where email ='" + uemail + "'", null);
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        return res;
    }
}
