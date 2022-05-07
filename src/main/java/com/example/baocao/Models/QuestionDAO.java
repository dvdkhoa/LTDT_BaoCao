package com.example.baocao.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.baocao.DbHelper;
import com.example.baocao.Models.Entities.CauHoi;

import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {
   private SQLiteDatabase db;

   public QuestionDAO(Context context)
   {
       this.db = new DbHelper(context).getWritableDatabase();
   }

    private Cursor readCursor(String tableName)
    {
        String query = "SELECT * FROM " + tableName;

        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }

    public List<CauHoi> getQuestions()
    {
        List<CauHoi> questions = new ArrayList<>();

        Cursor cursor = readCursor("CauHoi");
        if(cursor.moveToFirst())
        {
            do
            {
                CauHoi cauhoi = new CauHoi();
                cauhoi.setMaCauHoi(cursor.getInt(0));
                cauhoi.setTenCauHoi(cursor.getString(1));
                cauhoi.setMaDanhMuc(cursor.getInt(3));

                questions.add(cauhoi);
            }while (cursor.moveToNext());
        }
        return questions;
    }

    public void insertUpdateQuestion(CauHoi cauHoi, boolean isUpdate)
    {
        ContentValues values = new ContentValues();
        values.put("tenCauHoi", cauHoi.getTenCauHoi());
        values.put("maDanhMuc", cauHoi.getMaDanhMuc());

        if(isUpdate)
        {
            db.update("CauHoi", values, "maCauHoi=?", new String[]{ String.valueOf(cauHoi.getMaCauHoi())});
        }
        else
        {
            System.out.println("Thêm câu hỏi");
            long kq = db.insert("CauHoi", null, values);
            System.out.println("Kết quả thêm: "+ kq);
        }
    }

    public void deleteQuestion(int maCauHoi)
    {
        db.delete("CauHoi", "maCauHoi=?", new String[]{ String.valueOf(maCauHoi) });
    }
}
