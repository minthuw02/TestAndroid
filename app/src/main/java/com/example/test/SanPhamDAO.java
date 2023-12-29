package com.example.test;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

public class SanPhamDAO {
    private final DbHelper dbHelper;

    public SanPhamDAO(Context context) {
        dbHelper = new DbHelper(context);
    }
    public ArrayList<SanPham> getListSanPham(){
        //Tạo một danh sách để add dữ liệu Todo vào
        ArrayList<SanPham> list = new ArrayList<>();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        //Database bắt đầu chạy
        database.beginTransaction();
        try{
            //Tạo câu lệnh truy vấn
            Cursor cursor = database.rawQuery("SELECT * FROM SANPHAM", null);
            if(cursor.getCount() > 0){
                //Nếu cursor lớn hơn không, di chuyển con trỏ lên đầu
                cursor.moveToFirst();
                //Khởi tạo vòng lặp do..while để lấy toàn bộ dữ liệu truy cập được thêm vào danh sách
                do{
                    list.add(new SanPham(cursor.getInt(0),
                           cursor.getString(1),
                           cursor.getInt(2)));
                }while(cursor.moveToNext());
            }
        }catch(Exception e){
            Log.e(TAG, "getListSanPham:" + e);
        }finally {
            //Kết thúc lệnh ngay
            database.endTransaction();
        }
        return list;
    }
}
