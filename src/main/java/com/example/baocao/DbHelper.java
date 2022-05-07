package com.example.baocao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper
{
    private Context _context;
    private static final String DATABASE_NAME = "baocao.db";
    private static final int DATABASE_VERSION = 1;

    public DbHelper(@Nullable Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        Log.i("Sqlite", "Tạo database");
        db.execSQL("CREATE TABLE DanhMuc(maDanhMuc INTEGER PRIMARY KEY AUTOINCREMENT, tenDanhMuc TEXT)");
        db.execSQL("CREATE TABLE CauHoi(maCauHoi INTEGER PRIMARY KEY AUTOINCREMENT, tenCauHoi TEXT, maDanhMuc INT, FOREIGN KEY(maDanhMuc) REFERENCES DanhMuc(maDanhMuc))");
        db.execSQL("CREATE TABLE TraLoi(maTraLoi INTEGER PRIMARY KEY AUTOINCREMENT, chiTiet TEXT, maCauHoi INT, FOREIGN KEY(maCauHoi) REFERENCES CauHoi(maCauHoi))");
        db.execSQL("CREATE TABLE TaiKhoan(tenTaiKhoan TEXT, MatKhau TEXT, VaiTro INT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        Log.i("Sqlite", "MydatabaseHelper.onUpgrade...");
        db.execSQL("DROP TABLE IF EXISTS DanhMuc");
        db.execSQL("DROP TABLE IF EXISTS CauHoi");
        db.execSQL("DROP TABLE IF EXISTS TraLoi");
        db.execSQL("DROP TABLE IF EXISTS TaiKhoan");

        //Create tables again
        onCreate(db);
    }
}
