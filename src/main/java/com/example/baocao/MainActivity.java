package com.example.baocao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.baocao.Models.CategoryDAO;
import com.example.baocao.Models.Entities.DanhMuc;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CategoryDAO categoryDAO = new CategoryDAO(MainActivity.this);

        DanhMuc dm = new DanhMuc();
        dm.setTenDanhMuc("Danh mục thứ 3");

        categoryDAO.insertUpdateCategory(dm, false);

        List<DanhMuc> categories = categoryDAO.getCategories();

        System.out.println("danh sách danh mục: "+categories.size());

        for(int i=0; i< categories.size(); i++)
        {
            System.out.println("Danh mục thứ "+(categories.get(i).getMaDanhMuc())+": "+categories.get(i).getTenDanhMuc());
        }
    }
}