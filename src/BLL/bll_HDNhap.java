package BLL;

import DAL.dal_HDNhap;
import DTO.dto_HDNhap;
import GUI.gui_CTHDNhap;
import GUI.gui_CTHDTra;


import java.io.IOException;
import java.util.Scanner;


import static BLL.bll_KT.SoGioiHan;
import static DAL.dal_HDNhap.DocFile_HDNhap;
import static DAL.dal_HDNhap.GhiFile_HDNhap;


public class bll_HDNhap implements bll_HoaDon{
    dal_HDNhap dal_HDN =new dal_HDNhap();
    dto_HDNhap dto_HDN=null;
    @Override
    public void them(Object object) {
        dto_HDN= (dto_HDNhap) object;
        try {
            if (GhiFile_HDNhap((dto_HDNhap) object))
                System.out.println("Thêm thành công");
            else
                System.out.println("Thêm thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        gui_CTHDNhap cthdn=new gui_CTHDNhap();
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
        dto_HDNhap obj = (dto_HDNhap) object;                   // ép kiểu object về sv
        dto_HDNhap DSHDN_Cu[] = DocFile_HDNhap();
//        setDataNull(id, obj, DSSV_Cu);
        int cd_DSHDN = DSHDN_Cu.length;
        dto_HDNhap hdn[] = new dto_HDNhap[cd_DSHDN];                  // mảng Hóa đơn nhập mới chứa mảng sv cũ và

        for (int i = 0; i < cd_DSHDN; i++) {
            hdn[i] = new dto_HDNhap();
            int tam = Integer.parseInt(DSHDN_Cu[i].getIdHD());
            if (tam != id)
                hdn[i] = DSHDN_Cu[i];
            else {                                                                      // dssv cũ và id mà mình muốn sửa
                hdn[i].setIdHD(String.valueOf(id));
                hdn[i].setIdNV(obj.getIdNV());
                hdn[i].setIdLoai(obj.getIdLoai());
                hdn[i].setTongSach(obj.getTongSach());
                hdn[i].setTongGia(obj.getTongGia());
                hdn[i].setNgayNhap(obj.getNgayNhap());
            }
        }

        try {
            if (dal_HDN.Ghi_Sua_HDNhap(hdn))
                System.out.println("Sửa thành công");
            else
                System.out.println("Sửa thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        gui_CTHDNhap cthdn=new gui_CTHDNhap();
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
        dto_HDNhap DSHDN_CU[] = DocFile_HDNhap();
        int cd_DSHDN = DSHDN_CU.length;
        dto_HDNhap hdn[] = new dto_HDNhap[cd_DSHDN - 1];
        int c = 0, getid;

        for (int i = 0; i < cd_DSHDN; i++) {
            getid = Integer.parseInt(DSHDN_CU[i].getIdHD());
            if (id != getid) {
                hdn[c] = DSHDN_CU[i];
                c++;
            }
        }
        try {
            if (dal_HDN.Ghi_Xoa_HDNhap(hdn))
                System.out.println("Xóa thành công");
            else
                System.out.println("Xóa thất bại ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        gui_CTHDNhap cthdn=new gui_CTHDNhap();
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
