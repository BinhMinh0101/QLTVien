package DTO;

public class dto_LoaiSach {
    private String IdLoai;
    private String TenLoai;

    public dto_LoaiSach() {
    }

    public dto_LoaiSach(String idLoai, String tenLoai) {
        IdLoai = idLoai;
        TenLoai = tenLoai;
    }

    public String getIdLoai() {
        return IdLoai;
    }

    public void setIdLoai(String idLoai) {
        IdLoai = idLoai;
    }

    public String getTenLoai() {
        return TenLoai;
    }

    public void setTenLoai(String tenLoai) {
        TenLoai = tenLoai;
    }
}
