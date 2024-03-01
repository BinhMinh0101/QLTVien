package DTO;
import java.util.Date;

public class dto_HDTra extends dto_HoaDon{
    private String IdSV;
    private Date NgayTra;
    private int TongSach;
    private int TienPhat, TongtienSach;
    public dto_HDTra() {

    }

    public dto_HDTra(String idHD, String idNV, String idSV, Date ngayTra, int tongSach, int tienPhat, int tongtienSach) {
        super(idHD, idNV);
        IdSV = idSV;
        NgayTra = ngayTra;
        TongSach = tongSach;
        TienPhat = tienPhat;
        TongtienSach = tongtienSach;
    }

    public String getIdSV() {
        return IdSV;
    }

    public void setIdSV(String idSV) {
        IdSV = idSV;
    }

    public Date getNgayTra() {
        return NgayTra;
    }

    public void setNgayTra(Date ngayTra) {
        NgayTra = ngayTra;
    }

    public int getTongSach() {
        return TongSach;
    }

    public void setTongSach(int tongSach) {
        TongSach = tongSach;
    }

    public int getTienPhat() {
        return TienPhat;
    }

    public void setTienPhat(int tienPhat) {
        TienPhat = tienPhat;
    }

    public int getTongtienSach() {
        return TongtienSach;
    }

    public void setTongtienSach(int tongtienSach) {
        TongtienSach = tongtienSach;
    }
}
