package com.example.baocao.Models.Entities;

public class TraLoi
{
    private int maTraLoi;
    private String ChiTiet;
    private int maCauHoi;

    public int getMaTraLoi() {
        return maTraLoi;
    }

    public void setMaTraLoi(int maTraLoi) {
        this.maTraLoi = maTraLoi;
    }

    public String getChiTiet() {
        return ChiTiet;
    }

    public void setChiTiet(String chiTiet) {
        ChiTiet = chiTiet;
    }

    public int getMaCauHoi() {
        return maCauHoi;
    }

    public void setMaCauHoi(int maCauHoi) {
        this.maCauHoi = maCauHoi;
    }

    public TraLoi() {
    }

    public TraLoi(int maTraLoi, String chiTiet, int maCauHoi) {
        this.maTraLoi = maTraLoi;
        ChiTiet = chiTiet;
        this.maCauHoi = maCauHoi;
    }
}
