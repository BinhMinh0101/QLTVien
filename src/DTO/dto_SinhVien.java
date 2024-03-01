package DTO;

import java.util.Date;

public class dto_SinhVien extends dto_ConNguoi{
    private String idSV;
    private String Lop;

    public dto_SinhVien(String idSV, String hoTen, String phai, String lop, String diaChi, String sdt, Date ngaySinh ) {
        super(hoTen, phai, diaChi, sdt, ngaySinh);
        this.idSV = idSV;
        Lop = lop;
    }

    public dto_SinhVien() {
    }

    public String getIdSV() {
        return idSV;
    }

    public void setIdSV(String idSV) {
        this.idSV = idSV;
    }

    public String getLop() {
        return Lop;
    }

    public void setLop(String lop) {
        Lop = lop;
    }
}
