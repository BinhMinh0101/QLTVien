package DTO;

public class dto_CTHDNhap {
    private String IdHDNhap, IdSach;
    private int SoLuong, Gia, TongGia;

    public dto_CTHDNhap(String idHDNhap, String idSach, int soLuong, int gia, int tongGia) {
        IdHDNhap = idHDNhap;
        IdSach = idSach;
        SoLuong = soLuong;
        Gia = gia;
        TongGia = tongGia;
    }

    public dto_CTHDNhap() {
    }

    public String getIdHDNhap() {
        return IdHDNhap;
    }

    public void setIdHDNhap(String idHDNhap) {
        IdHDNhap = idHDNhap;
    }

    public String getIdSach() {
        return IdSach;
    }

    public void setIdSach(String idSach) {
        IdSach = idSach;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public int getGia() {
        return Gia;
    }

    public void setGia(int gia) {
        Gia = gia;
    }

    public int getTongGia() {
        return TongGia;
    }

    public void setTongGia(int tongGia) {
        TongGia = tongGia;
    }
}
