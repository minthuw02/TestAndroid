package com.example.test;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context){
        super(context, "SanPham",null,1);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase){
        String sql = "CREATE TABLE SANPHAM(ID INTEGER PRIMARY KEY AUTOINCREMENT," + "IMAGE TEXT, NAME TEXT, PRICE INTEGER)";
        sqLiteDatabase.execSQL(sql);
        String data = "INSERT INTO TODO VALUES(1,drawable/images4.jpg,'Veggie tomato mix',1999),"+
                "(2,drawable/images.jpg,'Fishwith mix orange',1999),"+
                "(3,drawable/download.jpg,'Salad',1990),"+
                "(4,drawable/images5.jpg,'Beefsteaf',2500)";
        sqLiteDatabase.execSQL(data);
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1){
        if (i != i1)
        {
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS SANPHAM");
            onCreate(sqLiteDatabase);
        }
    }
}
