package BLL;

import DAL.dal_CTHDNhap;
import DTO.dto_CTHDNhap;

import java.io.IOException;

import static DAL.dal_CTHDNhap.DocFile_CTHDNhap;
import static DAL.dal_CTHDNhap.GhiFile_CTHDNhap;

public class bll_CTHDNhap extends bll_Abstract{
    dal_CTHDNhap dal_CTHDN =new dal_CTHDNhap();
    dto_CTHDNhap dto_CTHDN =null;
    @Override
    public void them(Object object) {
        dto_CTHDN = (dto_CTHDNhap) object;
        try {
            if (GhiFile_CTHDNhap((dto_CTHDNhap) object))
                System.out.println("Thêm thành công");
            else
                System.out.println("Thêm thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sua(Object object, int id) {
        dto_CTHDNhap obj = (dto_CTHDNhap) object;                   // ép kiểu object về sv
        dto_CTHDNhap DSCTHDN_Cu[] = DocFile_CTHDNhap();
//        setDataNull(id, obj, DSSV_Cu);
        int cd_DSHDN = DSCTHDN_Cu.length;
        dto_CTHDNhap hdn[] = new dto_CTHDNhap[cd_DSHDN];                  // mảng Hóa đơn nhập mới chứa mảng sv cũ và

        for (int i = 0; i < cd_DSHDN; i++) {
            hdn[i] = new dto_CTHDNhap();
            int tam = Integer.parseInt(DSCTHDN_Cu[i].getIdHDNhap());
            if (tam != id)
                hdn[i] = DSCTHDN_Cu[i];
            else {                                                                      // dssv cũ và id mà mình muốn sửa
                hdn[i].setIdHDNhap(String.valueOf(id));
                hdn[i].setIdSach(obj.getIdSach());
                hdn[i].setSoLuong(obj.getSoLuong());
                hdn[i].setGia(obj.getGia());
                hdn[i].setTongGia(obj.getTongGia());
            }
        }

        try {
            if (dal_CTHDN.Ghi_Sua_CTHDNhap(hdn))
                System.out.println("Sửa thành công");
            else
                System.out.println("Sửa thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void xoa(int id) {
        dto_CTHDNhap DSCTHDN_CU[] = DocFile_CTHDNhap();
        int cd_DSCTHDN = DSCTHDN_CU.length;
        dto_CTHDNhap cthdn[] = new dto_CTHDNhap[cd_DSCTHDN - 1];
        int c = 0, getid;

        for (int i = 0; i < cd_DSCTHDN; i++) {
            getid = Integer.parseInt(DSCTHDN_CU[i].getIdHDNhap());
            if (id != getid) {
                cthdn[c] = DSCTHDN_CU[i];
                c++;
            }
        }
        try {
            if (dal_CTHDN.Ghi_Xoa_CTHDNhap(cthdn))
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
