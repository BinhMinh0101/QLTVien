package BLL;

import DAL.dal_NhanVien;
import DTO.dto_NhanVien;
import DTO.dto_SinhVien;
import GUI.gui_SinhVien;

import java.io.IOException;

import static DAL.dal_NhanVien.DocFile_NV;
import static DAL.dal_NhanVien.GhiFile_NV;
import static DAL.dal_SinhVien.DocFile_SV;

public class bll_NhanVien implements bll_ConNguoi{
    private dal_NhanVien dal_nv =new dal_NhanVien();

    @Override
    public void them(Object object) throws IOException {
        if (GhiFile_NV((dto_NhanVien) object))
            System.out.println("Thêm thành công");
        else
            System.out.println("Thêm thất bại ");
    }

    @Override
    public void xoa(int id) throws IOException {
        dto_NhanVien DSSV_Cu[] = DocFile_NV();
        int cd_DSSV = DSSV_Cu.length;
        dto_NhanVien sv[] = new dto_NhanVien[cd_DSSV - 1];
        int c = 0, getid;

        for (int i = 0; i < cd_DSSV; i++) {
            getid = Integer.parseInt(DSSV_Cu[i].getIdNV());
            if (id != getid) {
                sv[c] = DSSV_Cu[i];
                c++;
            }
        }
        if (dal_nv.Ghi_Xoa_NV(sv))
            System.out.println("Xóa thành công");
        else
            System.out.println("Xóa thất bại ");

    }

    @Override
    public void sua(Object object, int id) throws IOException {
        dto_NhanVien obj = (dto_NhanVien) object;                   // ép kiểu object về sv
        dto_NhanVien DSSV_Cu[] = DocFile_NV();
//        setDataNull(id, obj, DSSV_Cu);
        int cd_DSSV = DSSV_Cu.length;
        dto_NhanVien sv[] = new dto_NhanVien[cd_DSSV];                  // mảng sinh viên mới chứa mảng sv cũ và

        for (int i = 0; i < cd_DSSV; i++) {
            sv[i] = new dto_NhanVien();
            int tam = Integer.parseInt(DSSV_Cu[i].getIdNV());
            if (tam != id)
                sv[i] = DSSV_Cu[i];
            else {                                                                      // dssv cũ và id mà mình muốn sửa
                sv[i].setIdNV(String.valueOf(id));
                sv[i].setHoTen(obj.getHoTen());
                sv[i].setPhai(obj.getPhai());
                sv[i].setDiaChi(obj.getDiaChi());
                sv[i].setSdt(obj.getSdt());
                sv[i].setNgaySinh(obj.getNgaySinh());
                sv[i].setNgayVaoLam(obj.getNgayVaoLam());
            }
        }

        if (dal_nv.Ghi_Sua_NV(sv))
            System.out.println("Sửa thành công");
        else
            System.out.println("Sửa thất bại ");

    }


    private void setDataNull(int id, dto_SinhVien obj, dto_SinhVien[] DSSV_Cu) {            // nếu người nhaaph enter khi sửa thì nó sẽ hiểu là lấy giá trị cũ
        if (obj.getNgaySinh() == null)
            obj.setNgaySinh(DSSV_Cu[id].getNgaySinh());
        if (obj.getSdt() == "")
            obj.setSdt(DSSV_Cu[id].getSdt());
        if (obj.getPhai() == "")
            obj.setPhai(DSSV_Cu[id].getPhai());
        if (obj.getHoTen() == "")
            obj.setHoTen(DSSV_Cu[id].getHoTen());
        if (obj.getDiaChi() == "")
            obj.setDiaChi(DSSV_Cu[id].getDiaChi());
        if (obj.getLop() == "")
            obj.setLop(DSSV_Cu[id].getLop());
    }


    @Override
    public void TroLai() {
        gui_SinhVien sv=new gui_SinhVien();
        sv.TrangSinhVien();
    }
}
