package com.example.baocao.Models.Entities;

public class CauHoi
{
    private int maCauHoi;
    private String tenCauHoi;
    private int maDanhMuc;

    public int getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(int maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

    public String getTenCauHoi() {
        return tenCauHoi;
    }

    public void setTenCauHoi(String tenCauHoi) {
        this.tenCauHoi = tenCauHoi;
    }

    public int getMaDanhMuc() {
        return maDanhMuc;
    }

    public void setMaDanhMuc(int maDanhMuc) {
        this.maDanhMuc = maDanhMuc;
    }

    public CauHoi(int maCauHoi, String tenCauHoi, int maDanhMuc) {
        this.maCauHoi = maCauHoi;
        this.tenCauHoi = tenCauHoi;
        this.maDanhMuc = maDanhMuc;
    }

    public CauHoi() {
    }
}
