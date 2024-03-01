package DTO;

import java.util.Date;

public class dto_NhanVien extends dto_ConNguoi {
    private String idNV;
    private Date NgayVaoLam;

    public dto_NhanVien(String maNV, String hoTen, String phai, String diaChi, String sdt, Date ngaySinh, Date ngayVaoLam) {
        super(hoTen, phai, diaChi, sdt, ngaySinh);
        idNV = maNV;
        NgayVaoLam = ngayVaoLam;
    }

    public dto_NhanVien() {
    }

    public String getIdNV() {
        return idNV;
    }

    public void setIdNV(String idNV) {
        this.idNV = idNV;
    }

    public Date getNgayVaoLam() {
        return NgayVaoLam;
    }

    public void setNgayVaoLam(Date ngayVaoLam) {
        NgayVaoLam = ngayVaoLam;
    }

}
