package BLL;

import DAL.dal_TaiKhoan;
import DTO.dto_TaiKhoan;
import GUI.gui_TK;

import java.io.IOException;

import static DAL.dal_TaiKhoan.DocFile_TK;
import static DAL.dal_TaiKhoan.GhiFile_TK;

public class bll_TaiKhoan implements bll_ConNguoi {
    private  dal_TaiKhoan dal_TK=new dal_TaiKhoan();

    @Override
    public void them(Object object) throws IOException {
        if (GhiFile_TK((dto_TaiKhoan) object))
            System.out.println("Thêm thành công");
        else
            System.out.println("Thêm thất bại ");
    }

    @Override
    public void xoa(int id) throws IOException {
        dto_TaiKhoan DSTK_Cu[] = DocFile_TK();
        int cd_DSTK = DSTK_Cu.length;
        dto_TaiKhoan TK[] = new dto_TaiKhoan[cd_DSTK - 1];
        int c = 0, getid;

        for (int i = 0; i < cd_DSTK; i++) {
            getid = Integer.parseInt(DSTK_Cu[i].getId());
            if (id != getid) {
                TK[c] = DSTK_Cu[i];
                c++;
            }
        }
        if (dal_TK.Ghi_Xoa_TK(TK))
            System.out.println("Xóa thành công");
        else
            System.out.println("Xóa thất bại ");

    }

    @Override
    public void sua(Object object, int id) throws IOException {
        dto_TaiKhoan obj = (dto_TaiKhoan) object;                   // ép kiểu object về sv
        dto_TaiKhoan DSTK_Cu[] = DocFile_TK();
        setDataNull(id, obj, DSTK_Cu);
        int cd_DSTK = DSTK_Cu.length;
        dto_TaiKhoan TK[] = new dto_TaiKhoan[cd_DSTK];                  // mảng sinh viên mới chứa mảng sv cũ và

        for (int i = 0; i < cd_DSTK; i++) {
            TK[i] = new dto_TaiKhoan();
            int tam = Integer.parseInt(DSTK_Cu[i].getId());
            if (tam != id)
                TK[i] = DSTK_Cu[i];
            else {                                                                      // dssv cũ và id mà mình muốn sửa
                TK[i].setId(obj.getId());
                TK[i].setUsername(obj.getUsername());
                TK[i].setPassword(obj.getPassword());
            }
        }

        if (dal_TK.Ghi_Sua_TK(TK))
            System.out.println("Sửa thành công");
        else
            System.out.println("Sửa thất bại ");

    }


    private void setDataNull(int id, dto_TaiKhoan obj, dto_TaiKhoan[] DSTK_Cu) {            // nếu người nhaaph enter khi sửa thì nó sẽ hiểu là lấy giá trị cũ
        if (obj.getUsername() == "")
            obj.setUsername(DSTK_Cu[id].getUsername());
        if (obj.getPassword() == "")
            obj.setPassword(DSTK_Cu[id].getPassword());
    }


    @Override
    public void TroLai() {
        gui_TK sv=new gui_TK();
        sv.TrangTaiKhoan();
    }
}
