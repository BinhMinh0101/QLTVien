package DTO;

public class dto_CTHDMuon {
    private String IdHD, IdSach;
    private int SoLuong, GiaSach;
    private int TongGia;
    private String IdNCC;

    public dto_CTHDMuon() {
    }

    public dto_CTHDMuon(String idHD, String idSach, String idNCC, int soLuong, int giaSach, int tongGia) {
        IdHD = idHD;
        IdSach = idSach;
        SoLuong = soLuong;
        GiaSach = giaSach;
        TongGia = tongGia;
        IdNCC = idNCC;
    }

    public String getIdHD() {
        return IdHD;
    }

    public void setIdHD(String idHD) {
        IdHD = idHD;
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

    public int getGiaSach() {
        return GiaSach;
    }

    public void setGiaSach(int giaSach) {
        GiaSach = giaSach;
    }

    public int getTongGia() {
        return TongGia;
    }

    public void setTongGia(int tongGia) {
        TongGia = tongGia;
    }

    public String getIdNCC() {
        return IdNCC;
    }

    public void setIdNCC(String idNCC) {
        IdNCC = idNCC;
    }
}
