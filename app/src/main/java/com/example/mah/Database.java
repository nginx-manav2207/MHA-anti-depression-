package com.example.mah;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1 = "create table users(username text,email text,password text)";
        sqLiteDatabase.execSQL(qry1);
        String qry2 = "create table appt(username text,fullname text,address text,contact text,date text,time text, amount float)";
        sqLiteDatabase.execSQL(qry2);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void register(String username, String email, String password) {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("email", email);
        cv.put("password", password);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("users", null, cv);
        db.close();
    }
    public int login(String username,String password){
        int result=0;
        String str[]={username,password};
        SQLiteDatabase db =getReadableDatabase();
        Cursor c=db.rawQuery("select * from users where username=? and password=?",str);
        if(c.moveToFirst()){
            result=1;
        }
        c.close();
        db.close();
        return result;

    }



    public void addAppointment(String username,String name,String address,String contact,String date,String time,float fee){
        ContentValues cv = new ContentValues();
        cv.put("username",username);
        cv.put("fullname",name);
        cv.put("address",address);
        cv.put("contact",contact);
        cv.put("date",date);
        cv.put("time",time);
        cv.put("amount",fee);
        SQLiteDatabase db = getWritableDatabase();
        db.insert("appt",null,cv);
        db.close();
    }
    public int checkAppointmentExisting(String username, String name, String address, String contact, String date, String time){
        int re=0;
        String str[]=new String[6];
        str[0]= username;
        str[1]= name;
        str[2]= address;
        str[3]= contact;
        str[4]= date;
        str[5]= time;
        SQLiteDatabase db= getReadableDatabase();
        Cursor c = db.rawQuery("select * from appt where username=? and fullname=? and address=? and contact=? and date=? and time=?",str);
        if(c.moveToFirst()){
            re=1;
        }
        c.close();
        db.close();
        return re;
    }
    public ArrayList getApptData(String username){
        ArrayList <String>arr = new ArrayList<>();
        SQLiteDatabase db= getReadableDatabase();
        String str[]=new String[6];
        str[0]=username;
        Cursor c =db.rawQuery("select * from appt where username=?",str);
        if (c.moveToNext()) {
            do {
                String drname = c.getString(1);
                String add = c.getString(2);
                String contct = c.getString(3);
                String date= c.getString(4);
                String time=c.getString(5);
                String amount=c.getString(6);
                arr.add(drname+add+contct+date+time+"RS" + amount);
            } while (c.moveToNext());
        }
        db.close();
        return arr;

    }

}
