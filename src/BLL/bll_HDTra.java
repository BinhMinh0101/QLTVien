package BLL;

import DAL.dal_HDTra;
import DTO.dto_HDNhap;
import DTO.dto_HDTra;
import GUI.gui_CTHDTra;

import java.io.IOException;
import java.util.Scanner;

import static BLL.bll_KT.SoGioiHan;
import static DAL.dal_HDTra.DocFile_HDTra;
import static DAL.dal_HDTra.GhiFile_HDTra;


public class bll_HDTra implements bll_HoaDon{
    dal_HDTra dal_HDT =new dal_HDTra();
    dto_HDTra dto_HDT =null;
    @Override
    public void them(Object object) {
//        dto_HDT = (dto_HDNhap) object;
        try {
            if (GhiFile_HDTra((dto_HDTra) object))
                System.out.println("Thêm thành công");
            else
                System.out.println("Thêm thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        gui_CTHDTra cthdt=new gui_CTHDTra();
        int t=0;
        while(t==0) {
            cthdt.them();
            System.out.println("Bạn có muốn nhập tiếp ");
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Chắc");
            System.out.println("2. Không");
            String lc2 = sc.nextLine();
            while (!SoGioiHan(lc2, 1, 2)) {
                System.out.println("Nhập sai mời nhập lại lựa chọn: ");
                lc2 = sc.nextLine();
            }
            if(lc2.equals("2"))
                t=1;
            else
                t=0;
        }


    }

    @Override
    public void sua(Object object, int id) {
        dto_HDTra obj = (dto_HDTra) object;                   // ép kiểu object về sv
        dto_HDTra DSHDT_Cu[] = DocFile_HDTra();
//        setDataNull(id, obj, DSSV_Cu);
        int cd_DSHDT = DSHDT_Cu.length;
        dto_HDTra hdn[] = new dto_HDTra[cd_DSHDT];                  // mảng Hóa đơn trả mới chứa mảng sv cũ và

        for (int i = 0; i < cd_DSHDT; i++) {
            hdn[i] = new dto_HDTra();
            int tam = Integer.parseInt(DSHDT_Cu[i].getIdHD());
            if (tam != id)
                hdn[i] = DSHDT_Cu[i];
            else {                                                                      // dssv cũ và id mà mình muốn sửa
                hdn[i].setIdHD(String.valueOf(id));
                hdn[i].setIdNV(obj.getIdNV());
                hdn[i].setIdSV(obj.getIdSV());
                hdn[i].setTongSach(obj.getTongSach());
                hdn[i].setTongtienSach(obj.getTongtienSach());
                hdn[i].setNgayTra(obj.getNgayTra());
                hdn[i].setTienPhat(obj.getTienPhat());

            }
        }

        try {
            if (dal_HDT.Ghi_Sua_HDTra(hdn))
                System.out.println("Sửa thành công");
            else
                System.out.println("Sửa thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        gui_CTHDTra cthdt=new gui_CTHDTra();
        int t=0;
        while(t==0) {
            cthdt.sua();
            System.out.println("Bạn có muốn nhập tiếp ");
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Chắc");
            System.out.println("2. Không");
            String lc2 = sc.nextLine();
            while (!SoGioiHan(lc2, 1, 2)) {
                System.out.println("Nhập sai mời nhập lại lựa chọn: ");
                lc2 = sc.nextLine();
            }
            if(lc2.equals("2"))
                t=1;
            else
                t=0;
        }
    }

    @Override
    public void xoa(int id) {
        dto_HDTra DSHDT_CU[] = DocFile_HDTra();
        int cd_DSHDT = DSHDT_CU.length;
        dto_HDTra hdn[] = new dto_HDTra[cd_DSHDT - 1];
        int c = 0, getid;

        for (int i = 0; i < cd_DSHDT; i++) {
            getid = Integer.parseInt(DSHDT_CU[i].getIdHD());
            if (id != getid) {
                hdn[c] = DSHDT_CU[i];
                c++;
            }
        }
        try {
            if (dal_HDT.Ghi_Xoa_HDTra(hdn))
                System.out.println("Xóa thành công");
            else
                System.out.println("Xóa thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Thêm chi tiết

        gui_CTHDTra cthdt=new gui_CTHDTra();
        int t=0;
        while(t==0) {
            cthdt.xoa();
            System.out.println("Bạn có muốn nhập tiếp ");
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Chắc");
            System.out.println("2. Không");
            String lc2 = sc.nextLine();
            while (!SoGioiHan(lc2, 1, 2)) {
                System.out.println("Nhập sai mời nhập lại lựa chọn: ");
                lc2 = sc.nextLine();
            }
            if(lc2.equals("2"))
                t=1;
            else
                t=0;
        }
    }

    @Override
    public void trove() {

    }
}
