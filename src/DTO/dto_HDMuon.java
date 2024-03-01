package DTO;

import java.util.Date;

public class dto_HDMuon extends dto_HoaDon{
    private String IdSV;
    private Date NgayLap;
    private int TienDatCoc, TongtienSach;
    private int TongSach;

    public dto_HDMuon() {
    }

    public dto_HDMuon(String idHD, String idNV, String idSV, Date ngayLap, int tienDatCoc, int tongtienSach, int tongSach) {
        super(idHD, idNV);
        IdSV = idSV;
        NgayLap = ngayLap;
        TienDatCoc = tienDatCoc;
        TongtienSach = tongtienSach;
        TongSach = tongSach;
    }

    public String getIdSV() {
        return IdSV;
    }

    public void setIdSV(String idSV) {
        IdSV = idSV;
    }

    public Date getNgayLap() {
        return NgayLap;
    }

    public void setNgayLap(Date ngayLap) {
        NgayLap = ngayLap;
    }

    public int getTienDatCoc() {
        return TienDatCoc;
    }

    public void setTienDatCoc(int tienDatCoc) {
        TienDatCoc = tienDatCoc;
    }

    public int getTongtienSach() {
        return TongtienSach;
    }

    public void setTongtienSach(int tongtienSach) {
        TongtienSach = tongtienSach;
    }

    public int getTongSach() {
        return TongSach;
    }

    public void setTongSach(int tongSach) {
        TongSach = tongSach;
    }
}
