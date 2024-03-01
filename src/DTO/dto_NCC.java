package DTO;

public class dto_NCC {
    private String IdNCC, TenNCC;

    public dto_NCC() {
    }

    public dto_NCC(String idNCC, String tenNCC) {
        IdNCC = idNCC;
        TenNCC = tenNCC;
    }

    public String getIdNCC() {
        return IdNCC;
    }

    public void setIdNCC(String idNCC) {
        IdNCC = idNCC;
    }

    public String getTenNCC() {
        return TenNCC;
    }

    public void setTenNCC(String tenNCC) {
        TenNCC = tenNCC;
    }
}
