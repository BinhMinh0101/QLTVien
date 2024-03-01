package DTO;

public class dto_HoaDon {
    private String IdHD, IdNV;

    public dto_HoaDon() {
    }

    public dto_HoaDon(String idHD, String idNV) {
        IdHD = idHD;
        IdNV = idNV;
    }

    public String getIdHD() {
        return IdHD;
    }

    public void setIdHD(String idHD) {
        IdHD = idHD;
    }

    public String getIdNV() {
        return IdNV;
    }

    public void setIdNV(String idNV) {
        IdNV = idNV;
    }
}
