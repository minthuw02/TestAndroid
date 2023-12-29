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
        String data = "INSERT INTO TODO VALUES(1,https://www.google.com.vn/url?sa=i&url=https%3A%2F%2Fwww.hoteljob.vn%2Ftin-tuc%2F8-bi-quyet-chup-anh-mon-an-ngon-mat-bang-dien-thoai-quang-ba-cho-nha-hang&psig=AOvVaw1JMm06L4xVt9rOl04l0arl&ust=1703921588607000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPju08eRtIMDFQAAAAAdAAAAABAD,'Veggie tomato mix',1999),"+
                "(2,https://www.google.com.vn/url?sa=i&url=https%3A%2F%2Fvn.lovepik.com%2Fimage-500931330%2Fcool-cold-dish.html&psig=AOvVaw1JMm06L4xVt9rOl04l0arl&ust=1703921588607000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPju08eRtIMDFQAAAAAdAAAAABAI,'Fishwith mix orange',1999),"+
                "(3,https://www.google.com.vn/url?sa=i&url=https%3A%2F%2Fprinceproduction.vn%2Falbum-category%2Fchup-anh-mon-an-nha-hang%2F&psig=AOvVaw1JMm06L4xVt9rOl04l0arl&ust=1703921588607000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPju08eRtIMDFQAAAAAdAAAAABAQ,'Salad',1990),"+
                "(4,https://www.google.com.vn/url?sa=i&url=https%3A%2F%2Fpxhere.com%2Fvi%2Fphoto%2F1445049&psig=AOvVaw1JMm06L4xVt9rOl04l0arl&ust=1703921588607000&source=images&cd=vfe&opi=89978449&ved=0CBEQjRxqFwoTCPju08eRtIMDFQAAAAAdAAAAABAY,'Beefsteaf',2500)";
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
