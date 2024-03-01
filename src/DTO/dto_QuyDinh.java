package DTO;

public class dto_QuyDinh {
    private String idQuyDinh, TenQuyDinh;
    private int TienPhat;

    public dto_QuyDinh(String idQuyDinh, String tenQuyDinh, int tienPhat) {
        this.idQuyDinh = idQuyDinh;
        TenQuyDinh = tenQuyDinh;
        TienPhat = tienPhat;
    }

    public dto_QuyDinh() {
    }

    public String getIdQuyDinh() {
        return idQuyDinh;
    }

    public void setIdQuyDinh(String idQuyDinh) {
        this.idQuyDinh = idQuyDinh;
    }

    public String getTenQuyDinh() {
        return TenQuyDinh;
    }

    public void setTenQuyDinh(String tenQuyDinh) {
        TenQuyDinh = tenQuyDinh;
    }

    public int getTienPhat() {
        return TienPhat;
    }

    public void setTienPhat(int tienPhat) {
        TienPhat = tienPhat;
    }
}
