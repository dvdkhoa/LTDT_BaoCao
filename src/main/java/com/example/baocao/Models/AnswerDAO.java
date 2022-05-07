package com.example.baocao.Models;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.baocao.DbHelper;
import com.example.baocao.Models.Entities.CauHoi;
import com.example.baocao.Models.Entities.TraLoi;

import java.util.ArrayList;
import java.util.List;

public class AnswerDAO {
    private SQLiteDatabase db;

    public AnswerDAO(Context context)
    {
        this.db = (new DbHelper(context)).getWritableDatabase();
    }

    private Cursor readCursor(String tableName)
    {
        String query = "SELECT * FROM " + tableName;

        Cursor cursor = db.rawQuery(query, null);

        return cursor;
    }

    public List<TraLoi> getAnswer()
    {
        List<TraLoi> answers = new ArrayList<>();

        Cursor cursor = readCursor("TraLoi");
        if(cursor.moveToFirst())
        {
            do
            {
                TraLoi traLoi = new TraLoi();
                traLoi.setMaTraLoi(cursor.getInt(0));
                traLoi.setChiTiet(cursor.getString(1));
                traLoi.setMaCauHoi(cursor.getInt(2));

                answers.add(traLoi);
            }while (cursor.moveToNext());
        }
        return answers;
    }

    public void insertUpdateAnswer(TraLoi traLoi, boolean isUpdate)
    {
        ContentValues values = new ContentValues();
        values.put("chiTiet", traLoi.getChiTiet());
        values.put("maCauHoi", traLoi.getMaCauHoi());

        if(isUpdate)
        {
            db.update("TraLoi", values, "maTraLoi=?", new String[]{ String.valueOf(traLoi.getMaTraLoi())});
        }
        else
        {
            System.out.println("Thêm câu trả lời");
            long kq = db.insert("TraLoi", null, values);
            System.out.println("Kết quả thêm: "+ kq);
        }
    }

    public void deleteQuestion(int maTraLoi)
    {
        db.delete("TraLoi", "maTraLoi=?", new String[]{ String.valueOf(maTraLoi) });
    }
}
