package com.example.baocao.Models.Entities;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.baocao.DbHelper;

public class AccountDAO {
    private SQLiteDatabase db;

    public AccountDAO(Context context)
    {
        this.db = (new DbHelper(context)).getReadableDatabase();
    }

    public boolean Login(String userName, String pass)
    {
        String query = "SELECT * FROM TaiKhoan WHERE userName = '"+userName+"'";

        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst())
        {
            if(userName.compareTo(cursor.getString(0)) == 0)
            {
                if(pass.compareTo(cursor.getString(1)) == 0)
                    return true;
            }
        }
        return false;
    }
}
