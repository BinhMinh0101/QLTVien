package BLL;

import DAL.dal_Sach;
import DTO.dto_Sach;
import GUI.gui_Sach;

import java.io.IOException;

import static DAL.dal_Sach.*;

public class bll_Sach extends bll_Abstract{


    @Override
    public void them(Object object) {
        try {
            if (GhiFile_Sach((dto_Sach) object))
                System.out.println("Thêm thành công");
            else
                System.out.println("Thêm thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void xoa( int id)  {
        dto_Sach DSS_Cu[] = DocFile_Sach();
        int cd_Sach = DSS_Cu.length;
        dto_Sach sach[] = new dto_Sach[cd_Sach - 1];
        int c = 0, getIdSach;

        for (int i = 0; i < cd_Sach; i++) {
            getIdSach = Integer.parseInt(DSS_Cu[i].getIdSach());
            if (id != getIdSach) {
                sach[c] = DSS_Cu[i];
                c++;
            }
        }
        try {
            if (Ghi_Xoa_Sach(sach))
                System.out.println("Xóa thành công");
            else
                System.out.println("Xóa thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void sua(Object object, int id)  {
        dto_Sach obj = (dto_Sach) object;                   // ép kiểu object về sach
        dto_Sach DSS_Cu[] = DocFile_Sach();
        setDataNull(id, obj, DSS_Cu);
        int cd_Sach = DSS_Cu.length;
        dto_Sach sach[] = new dto_Sach[cd_Sach];                  // mảng Hóa đơn nhập mới chứa mảng sv cũ và

        for (int i = 0; i < cd_Sach; i++) {
            sach[i] = new dto_Sach();
            int tam = Integer.parseInt(DSS_Cu[i].getIdSach());
            if (tam != id)
                sach[i] = DSS_Cu[i];
            else {                                                                      // dssv cũ và id mà mình muốn sửa
                sach[i].setIdSach(String.valueOf(id));
                sach[i].setTenSach(obj.getTenSach());
                sach[i].setIdNCC(obj.getIdNCC());
                sach[i].setSoLuongSach(obj.getSoLuongSach());
                sach[i].setGiaSach(obj.getGiaSach());
                sach[i].setIdLoai(obj.getIdLoai());
            }
        }

        try {
            if (Ghi_Sua_Sach(sach))
                System.out.println("Sửa thành công");
            else
                System.out.println("Sửa thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void setDataNull(int id, dto_Sach obj, dto_Sach[] DSS_Cu) {            // nếu người nhập enter khi sửa thì nó sẽ hiểu là lấy giá trị cũ
        if (obj.getIdSach() == null)
            obj.setIdSach(DSS_Cu[id].getIdSach());
        if (obj.getTenSach() == "")
            obj.setTenSach(DSS_Cu[id].getTenSach());
        if (obj.getIdNCC() == "")
            obj.setIdNCC(DSS_Cu[id].getIdNCC());
        /*
        if (obj.getSoLuongSach() == "")
            obj.setSoLuongSach(DSS_Cu[id].getSoLuongSach());
        if (obj.getGiaSach() == "")
            obj.setGiaSach(DSS_Cu[id].getGiaSach());
    */
    }
    @Override
    public void TroLai() {
        gui_Sach sach=new gui_Sach();
        sach.TrangSach();
    }
}

