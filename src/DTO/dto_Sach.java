package DTO;

public class dto_Sach {
    private String IdSach, TenSach, IdNCC;
    private int SoLuongSach, GiaSach;
    private String IdLoai;
    public dto_Sach() {
    }

    public dto_Sach(String idSach, String tenSach, String idNCC, int soLuongSach, int giaSach, String idLoai) {
        IdSach = idSach;
        TenSach = tenSach;
        IdNCC = idNCC;
        SoLuongSach = soLuongSach;
        GiaSach = giaSach;
        IdLoai = idLoai;
    }

    public String getIdLoai() {
        return IdLoai;
    }

    public void setIdLoai(String idLoai) {
        IdLoai = idLoai;
    }

    public String getIdSach() {
        return IdSach;
    }

    public void setIdSach(String idSach) {
        IdSach = idSach;
    }

    public String getTenSach() {
        return TenSach;
    }

    public void setTenSach(String tenSach) {
        TenSach = tenSach;
    }

    public String getIdNCC() {
        return IdNCC;
    }

    public void setIdNCC(String idNCC) {
        IdNCC = idNCC;
    }

    public int getSoLuongSach() {
        return SoLuongSach;
    }

    public void setSoLuongSach(int soLuongSach) {
        SoLuongSach = soLuongSach;
    }

    public int getGiaSach() {
        return GiaSach;
    }

    public void setGiaSach(int giaSach) {
        GiaSach = giaSach;
    }
}
