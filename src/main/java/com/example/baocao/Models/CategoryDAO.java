package com.example.baocao.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.baocao.DbHelper;
import com.example.baocao.Models.Entities.DanhMuc;

import java.util.ArrayList;
import java.util.List;

public class CategoryDAO
{
    private SQLiteDatabase db;

    Cursor readCursor(String tableName)
    {
        String query = "SELECT * FROM " + tableName;

        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }

    public CategoryDAO(Context context)
    {
        DbHelper helper = new DbHelper(context);
        this.db = helper.getWritableDatabase();
    }

    public List<DanhMuc> getCategories()
    {
        List<DanhMuc> categories = new ArrayList<>();

        Cursor cursor = readCursor("DanhMuc");
        if(cursor.moveToFirst())
        {
            System.out.println("có dữ liệu");
            do
            {
                DanhMuc dm = new DanhMuc();
                dm.setMaDanhMuc(cursor.getInt(0));
                dm.setTenDanhMuc(cursor.getString(1));
                categories.add(dm);
            }while (cursor.moveToNext());
        }
        return categories;
    }

    public void insertUpdateCategory(DanhMuc dm, boolean isUpdate){
        ContentValues values = new ContentValues();

        values.put("tenDanhMuc", dm.getTenDanhMuc());
        if(isUpdate)
        {
            db.update("DanhMuc", values, "maDanhMuc=?", new String[]{ String.valueOf(dm.getMaDanhMuc())});
        }
        else
        {
            System.out.println("Thêm danh mục");
            long kq = db.insert("DanhMuc", null, values);
            System.out.println("Kết quả thêm: "+kq);
        }
    }

    public void deleteCategory(int maDanhMuc)
    {
        db.delete("DanhMuc", "maDanhMuc=?", new String[]{ String.valueOf(maDanhMuc) });
    }


}
