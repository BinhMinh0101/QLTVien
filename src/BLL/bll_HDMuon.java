package BLL;

import DAL.dal_HDMuon;
import DTO.dto_HDMuon;
import GUI.gui_CTHDMuon;
import GUI.gui_CTHDNhap;

import java.io.IOException;
import java.util.Scanner;

import static BLL.bll_KT.SoGioiHan;
import static DAL.dal_HDMuon.DocFile_HDMuon;
import static DAL.dal_HDMuon.GhiFile_HDMuon;

public class bll_HDMuon implements bll_HoaDon{
    dal_HDMuon dal_HDM =new dal_HDMuon();
    dto_HDMuon dto_HDM =null;
    @Override
    public void them(Object object) {
//        dto_HDM = (dto_HDNhap) object;
        try {
            if (GhiFile_HDMuon((dto_HDMuon) object))
                System.out.println("Thêm thành công");
            else
                System.out.println("Thêm thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // Thêm cthd
        gui_CTHDMuon cthdn=new gui_CTHDMuon();
        int t=0;
        while(t==0) {
            cthdn.them();
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
        dto_HDMuon obj = (dto_HDMuon) object;                   // ép kiểu object về sv
        dto_HDMuon DSHDN_Cu[] = DocFile_HDMuon();
//        setDataNull(id, obj, DSSV_Cu);
        int cd_DSHDN = DSHDN_Cu.length;
        dto_HDMuon hdm[] = new dto_HDMuon[cd_DSHDN];                  // mảng Hóa đơn nhập mới chứa mảng sv cũ và

        for (int i = 0; i < cd_DSHDN; i++) {
            hdm[i] = new dto_HDMuon();
            int tam = Integer.parseInt(DSHDN_Cu[i].getIdHD());
            if (tam != id)
                hdm[i] = DSHDN_Cu[i];
            else {                                                                      // dssv cũ và id mà mình muốn sửa
                hdm[i].setIdHD(String.valueOf(id));
                hdm[i].setIdNV(obj.getIdNV());
                hdm[i].setIdSV(obj.getIdSV());
                hdm[i].setNgayLap(obj.getNgayLap());
                hdm[i].setTongSach(obj.getTongSach());
                hdm[i].setTongtienSach(obj.getTongtienSach());
                hdm[i].setTienDatCoc(obj.getTienDatCoc());
            }
        }

        try {
            if (dal_HDM.Ghi_Sua_HDMuon(hdm))
                System.out.println("Sửa thành công");
            else
                System.out.println("Sửa thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        gui_CTHDMuon cthdn=new gui_CTHDMuon();
        int t=0;
        while(t==0) {
            cthdn.sua();
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
        dto_HDMuon DSHDM_CU[] = DocFile_HDMuon();
        int cd_DSHDM = DSHDM_CU.length;
        dto_HDMuon hdm[] = new dto_HDMuon[cd_DSHDM - 1];
        int c = 0, getid;

        for (int i = 0; i < cd_DSHDM; i++) {
            getid = Integer.parseInt(DSHDM_CU[i].getIdHD());
            if (id != getid) {
                hdm[c] = DSHDM_CU[i];
                c++;
            }
        }
        try {
            if (dal_HDM.Ghi_Xoa_HDMuon(hdm))
                System.out.println("Xóa thành công");
            else
                System.out.println("Xóa thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        gui_CTHDMuon cthdn=new gui_CTHDMuon();
        int t=0;
        while(t==0) {
            cthdn.xoa();
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
