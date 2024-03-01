package DTO;

import java.util.Date;

public class dto_ConNguoi {
    private String HoTen,Phai,DiaChi,Sdt;
    private Date NgaySinh;

    public dto_ConNguoi(String hoTen, String phai, String diaChi, String sdt, Date ngaySinh) {
        HoTen = hoTen;
        Phai = phai;
        DiaChi = diaChi;
        Sdt = sdt;
        NgaySinh = ngaySinh;
    }

    public dto_ConNguoi() {

    }

    public String getHoTen() {
        return HoTen;
    }

    public void setHoTen(String hoTen) {
        HoTen = hoTen;
    }

    public String getPhai() {
        return Phai;
    }

    public void setPhai(String phai) {
        Phai = phai;
    }

    public String getSdt() {
        return Sdt;
    }

    public void setSdt(String sdt) {
        Sdt = sdt;
    }

    public Date getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        NgaySinh = ngaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String diaChi) {
        DiaChi = diaChi;
    }



}
