package BLL;

import DAL.dal_CTHDMuon;
import DTO.dto_CTHDMuon;
import DTO.dto_CTHDNhap;

import java.io.IOException;

import static DAL.dal_CTHDMuon.DocFile_CTHDMuon;
import static DAL.dal_CTHDMuon.GhiFile_CTHDMuon;
import static DAL.dal_CTHDNhap.DocFile_CTHDNhap;

public class bll_CTHDMuon extends bll_Abstract{
    dal_CTHDMuon dal_CTHDM =new dal_CTHDMuon();
    dto_CTHDMuon dto_CTHDM =null;
    @Override
    public void them(Object object) {
//        dto_CTHDM = (dto_CTHDNhap) object;
        try {
            if (GhiFile_CTHDMuon((dto_CTHDMuon) object))
                System.out.println("Thêm thành công");
            else
                System.out.println("Thêm thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void sua(Object object, int id) {
        dto_CTHDMuon obj = (dto_CTHDMuon) object;                   // ép kiểu object về sv
        dto_CTHDMuon DSCTHDM_Cu[] = DocFile_CTHDMuon();
//        setDataNull(id, obj, DSSV_Cu);
        int cd_DSHDN = DSCTHDM_Cu.length;
        dto_CTHDMuon hdn[] = new dto_CTHDMuon[cd_DSHDN];                  // mảng Hóa đơn nhập mới chứa mảng sv cũ và

        for (int i = 0; i < cd_DSHDN; i++) {
            hdn[i] = new dto_CTHDMuon();
            int tam = Integer.parseInt(DSCTHDM_Cu[i].getIdHD());
            if (tam != id)
                hdn[i] = DSCTHDM_Cu[i];
            else {                                                                      // dssv cũ và id mà mình muốn sửa
                hdn[i].setIdHD(String.valueOf(id));
                hdn[i].setIdSach(obj.getIdSach());
                hdn[i].setIdNCC(obj.getIdNCC());
                hdn[i].setSoLuong(obj.getSoLuong());
                hdn[i].setGiaSach(obj.getGiaSach());
                hdn[i].setTongGia(obj.getTongGia());
            }
        }

        try {
            if (dal_CTHDM.Ghi_Sua_CTHDMuon(hdn))
                System.out.println("Sửa thành công");
            else
                System.out.println("Sửa thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void xoa(int id) {
        dto_CTHDMuon DSCTHDM_CU[] = DocFile_CTHDMuon();
        int cd_DSCTHDM = DSCTHDM_CU.length;
        dto_CTHDMuon cthdm[] = new dto_CTHDMuon[cd_DSCTHDM - 1];
        int c = 0, getid;

        for (int i = 0; i < cd_DSCTHDM; i++) {
            getid = Integer.parseInt(DSCTHDM_CU[i].getIdHD());
            if (id != getid) {
                cthdm[c] = DSCTHDM_CU[i];
                c++;
            }
        }
        try {
            if (dal_CTHDM.Ghi_Xoa_CTHDMuon(cthdm))
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
