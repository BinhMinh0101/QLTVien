package BLL;

import DAL.dal_CTHDTra;
import DTO.dto_CTHDTra;

import java.io.IOException;

import static DAL.dal_CTHDTra.DocFile_CTHDTra;
import static DAL.dal_CTHDTra.GhiFile_CTHDTra;

public class bll_CTHDTra extends bll_Abstract{
    dal_CTHDTra dal_CTHDTra =new dal_CTHDTra();
    dto_CTHDTra dto_CTHDT =null;
    @Override
    public void them(Object object) {
//        dto_CTHDN = (dto_CTHDNhap) object;
        try {
            if (GhiFile_CTHDTra((dto_CTHDTra)  object))
                System.out.println("Thêm thành công");
            else
                System.out.println("Thêm thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sua(Object object, int id) {
        dto_CTHDTra obj = (dto_CTHDTra) object;                   // ép kiểu object về sv
        dto_CTHDTra DSCTHDN_Cu[] = DocFile_CTHDTra();
//        setDataNull(id, obj, DSSV_Cu);
        int cd_DSHDN = DSCTHDN_Cu.length;
        dto_CTHDTra hdt[] = new dto_CTHDTra[cd_DSHDN];                  // mảng Hóa đơn nhập mới chứa mảng sv cũ và

        for (int i = 0; i < cd_DSHDN; i++) {
            hdt[i] = new dto_CTHDTra();
            int tam = Integer.parseInt(DSCTHDN_Cu[i].getIdHD());
            if (tam != id)
                hdt[i] = DSCTHDN_Cu[i];
            else {                                                                      // dssv cũ và id mà mình muốn sửa
                hdt[i].setIdHD(String.valueOf(id));
                hdt[i].setIdSach(obj.getIdSach());
                hdt[i].setIdNCC(obj.getIdNCC());
                hdt[i].setIdQuyDinh(obj.getIdQuyDinh());
                hdt[i].setSoLuong(obj.getSoLuong());
                hdt[i].setGiaSach(obj.getGiaSach());
                hdt[i].setTongGia(obj.getTongGia());
                hdt[i].setTienPhat(obj.getTienPhat());
            }
        }

        try {
            if (dal_CTHDTra.Ghi_Sua_CTHDTra(hdt))
                System.out.println("Sửa thành công");
            else
                System.out.println("Sửa thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void xoa(int id) {
        dto_CTHDTra DSCTHDN_CU[] = DocFile_CTHDTra();
        int cd_DSCTHDN = DSCTHDN_CU.length;
        dto_CTHDTra cthdn[] = new dto_CTHDTra[cd_DSCTHDN - 1];
        int c = 0, getid;

        for (int i = 0; i < cd_DSCTHDN; i++) {
            getid = Integer.parseInt(DSCTHDN_CU[i].getIdHD());
            if (id != getid) {
                cthdn[c] = DSCTHDN_CU[i];
                c++;
            }
        }
        try {
            if (dal_CTHDTra.Ghi_Xoa_CTHDTra(cthdn))
                System.out.println("Xóa thành công");
            else
                System.out.println("Xóa thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void TroLai() {

    }


}
