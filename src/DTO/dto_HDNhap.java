package DTO;

import java.util.Date;

public class dto_HDNhap extends dto_HoaDon{
    private String idLoai;
    private int TongSach, TongGia;
    private Date NgayNhap;

    public dto_HDNhap() {
    }

    public dto_HDNhap(String idHD, String idNV, String idLoai, int tongSach, int tongGia, Date ngayNhap) {
        super(idHD, idNV);
        this.idLoai = idLoai;
        TongSach = tongSach;
        TongGia = tongGia;
        NgayNhap = ngayNhap;
    }

    public String getIdLoai() {
        return idLoai;
    }

    public void setIdLoai(String idLoai) {
        this.idLoai = idLoai;
    }

    public int getTongSach() {
        return TongSach;
    }

    public void setTongSach(int tongSach) {
        TongSach = tongSach;
    }

    public int getTongGia() {
        return TongGia;
    }

    public void setTongGia(int tongGia) {
        TongGia = tongGia;
    }

    public Date getNgayNhap() {
        return NgayNhap;
    }

    public void setNgayNhap(Date ngayNhap) {
        NgayNhap = ngayNhap;
    }
}
