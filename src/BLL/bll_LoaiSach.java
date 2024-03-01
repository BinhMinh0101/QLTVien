package BLL;

import DAL.dal_LoaiSach;
import DTO.dto_LoaiSach;
import GUI.gui_LoaiSach;

import java.io.IOException;

import static DAL.dal_LoaiSach.*;

public class bll_LoaiSach extends bll_Abstract {

    @Override
    public void them(Object object) {

        try {
            if (GhiFile_LoaiSach((dto_LoaiSach) object))
                System.out.println("Thêm thành công");
            else
                System.out.println("Thêm thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoa(int id) {
        dto_LoaiSach DSLS_Cu[] = DocFile_LoaiSach();
        int cd_LoaiSach = DSLS_Cu.length;
        dto_LoaiSach loaisach[] = new dto_LoaiSach[cd_LoaiSach - 1];
        int c = 0, getIdLoai;

        for (int i = 0; i < cd_LoaiSach; i++) {
            getIdLoai = Integer.parseInt(DSLS_Cu[i].getIdLoai());
            if (id != getIdLoai) {
                loaisach[c] = DSLS_Cu[i];
                c++;
            }
        }
        try {
            if (Ghi_Xoa_LoaiSach(loaisach))
                System.out.println("Xóa thành công");
            else
                System.out.println("Xóa thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void sua(Object object, int id) {
        dto_LoaiSach obj = (dto_LoaiSach) object;                   // ép kiểu object về sach
        dto_LoaiSach DSLS_Cu[] = DocFile_LoaiSach();
        //setDataNull(id, obj, DSLS_Cu);
        int cd_LoaiSach = DSLS_Cu.length;
        dto_LoaiSach loaisach[] = new dto_LoaiSach[cd_LoaiSach];                  // mảng Hóa đơn nhập mới chứa mảng sv cũ và

        for (int i = 0; i < cd_LoaiSach; i++) {
            loaisach[i] = new dto_LoaiSach();
            int tam = Integer.parseInt(DSLS_Cu[i].getIdLoai());
            if (tam != id)
                loaisach[i] = DSLS_Cu[i];
            else {                                                                      // dssv cũ và id mà mình muốn sửa
                loaisach[i].setIdLoai(String.valueOf(id));
                loaisach[i].setTenLoai(obj.getTenLoai());
            }
        }

        try {
            if (Ghi_Sua_LoaiSach(loaisach))
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
