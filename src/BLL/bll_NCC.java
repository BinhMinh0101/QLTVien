package BLL;

import DAL.dal_NCC;
import DTO.dto_HDNhap;
import DTO.dto_LoaiSach;
import DTO.dto_NCC;
import DTO.dto_SinhVien;
import GUI.gui_LoaiSach;
import GUI.gui_SinhVien;

import java.io.IOException;

import static DAL.dal_LoaiSach.*;
import static DAL.dal_NCC.*;
import static DAL.dal_SinhVien.DocFile_SV;
import static DAL.dal_SinhVien.GhiFile_SV;

public class bll_NCC extends bll_Abstract{

    @Override
    public void them(Object object) {

        try {
            if (GhiFile_NCC((dto_NCC) object))
                System.out.println("Thêm thành công");
            else
                System.out.println("Thêm thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoa(int id) {
        dto_NCC DSNCC_Cu[] = DocFile_NCC();
        int cd_ncc = DSNCC_Cu.length;
        dto_NCC dto_ncc[] = new dto_NCC[cd_ncc - 1];
        int c = 0, getIdLoai;

        for (int i = 0; i < cd_ncc; i++) {
            getIdLoai = Integer.parseInt(DSNCC_Cu[i].getIdNCC());
            if (id != getIdLoai) {
                dto_ncc[c] = DSNCC_Cu[i];
                c++;
            }
        }
        try {
            if (Ghi_Xoa_NCC(dto_ncc))
                System.out.println("Xóa thành công");
            else
                System.out.println("Xóa thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void sua(Object object, int id) {
        dto_NCC obj = (dto_NCC) object;                   // ép kiểu object về sach
        dto_NCC DSLS_Cu[] = DocFile_NCC();
        //setDataNull(id, obj, DSLS_Cu);
        int cd_ncc = DSLS_Cu.length;
        dto_NCC ncc[] = new dto_NCC[cd_ncc];                  // mảng Hóa đơn nhập mới chứa mảng sv cũ và

        for (int i = 0; i < cd_ncc; i++) {
            ncc[i] = new dto_NCC();
            int tam = Integer.parseInt(DSLS_Cu[i].getIdNCC());
            if (tam != id)
                ncc[i] = DSLS_Cu[i];
            else {                                                                      // dssv cũ và id mà mình muốn sửa
                ncc[i].setIdNCC(String.valueOf(id));
                ncc[i].setTenNCC(obj.getTenNCC());
            }
        }

        try {
            if (Ghi_Sua_NCC(ncc))
                System.out.println("Sửa thành công");
            else
                System.out.println("Sửa thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*
        private void setDataNull ( int id, dto_LoaiSach obj, dto_LoaiSach[] DSLS_Cu)
        {            // nếu người nhập enter khi sửa thì nó sẽ hiểu là lấy giá trị cũ
            if (obj.getIdLoai() == null)
                obj.setIdLoai(DSLS_Cu[id].getIdLoai());
            if (obj.getTenLoai() == "")
                obj.setTenLoai(DSLS_Cu[id].getTenLoai());
        /*
        if (obj.getSoLuongSach() == "")
            obj.setSoLuongSach(DSS_Cu[id].getSoLuongSach());
        if (obj.getGiaSach() == "")
            obj.setGiaSach(DSS_Cu[id].getGiaSach());
    */
    }

    @Override
    public void TroLai() {
        gui_LoaiSach loaisach=new gui_LoaiSach();
        loaisach.TrangLoaiSach();
    }
}
