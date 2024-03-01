package BLL;

import DAL.dal_QuyDinh;
import DTO.dto_QuyDinh;
import GUI.gui_QuyDinh;

import java.io.IOException;

import static DAL.dal_QuyDinh.*;

public class bll_QuyDinh extends bll_Abstract {


    @Override
    public void them(Object object) {
        try {
            if (GhiFile_QD((dto_QuyDinh) object))
                System.out.println("Thêm thành công");
            else
                System.out.println("Thêm thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void xoa(int id) {
        dto_QuyDinh DSQD_Cu[] = DocFile_QD();
        int cd_DSQD = DSQD_Cu.length;
        dto_QuyDinh QD[] = new dto_QuyDinh[cd_DSQD - 1];
        int c = 0, getidqd;

        for (int i = 0; i < cd_DSQD; i++) {
            getidqd = Integer.parseInt(DSQD_Cu[i].getIdQuyDinh());
            if (id != getidqd) {
                QD[c] = DSQD_Cu[i];
                c++;
            }
        }
        try {
            if (Ghi_Xoa_QD(QD))
                System.out.println("Xóa thành công");
            else
                System.out.println("Xóa thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sua(Object object, int id) {
        dto_QuyDinh obj = (dto_QuyDinh) object;                   // ép kiểu object về sv
        dto_QuyDinh DSQD_Cu[] = dal_QuyDinh.DocFile_QD();
        setDataNull(id, obj, DSQD_Cu);
        int cd_DSQD = DSQD_Cu.length;
        dto_QuyDinh QD[] = new dto_QuyDinh[cd_DSQD];                  // mảng sinh viên mới chứa mảng sv cũ và

        for (int i = 0; i < cd_DSQD; i++) {
            QD[i] = new dto_QuyDinh();
            int tam = Integer.parseInt(DSQD_Cu[i].getIdQuyDinh());
            if (tam != id)
                QD[i] = DSQD_Cu[i];
            else {                                                                      // dssv cũ và id mà mình muốn sửa
                QD[i].setIdQuyDinh(String.valueOf(id));
                QD[i].setTenQuyDinh(obj.getTenQuyDinh());
                QD[i].setTienPhat(obj.getTienPhat());
            }
        }

        try {
            if (Ghi_Sua_QD(QD))
                System.out.println("Sửa thành công");
            else
                System.out.println("Sửa thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setDataNull(int id, dto_QuyDinh obj, dto_QuyDinh[] DSQD_Cu) {            // nếu người nhaaph enter khi sửa thì nó sẽ hiểu là lấy giá trị cũ
        if (obj.getIdQuyDinh() == null)
            obj.setIdQuyDinh(DSQD_Cu[id].getIdQuyDinh());
        if (obj.getTenQuyDinh() == "")
            obj.setTenQuyDinh(DSQD_Cu[id].getTenQuyDinh());
       /* if (obj.getTienPhat() == "")
            obj.setTienPhat(DSQD_Cu[id].getTienPhat());
    */
    }

    @Override
    public void TroLai() {

    }
}
