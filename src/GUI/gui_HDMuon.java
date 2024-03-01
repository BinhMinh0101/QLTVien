package GUI;

import BLL.bll_HDMuon;
import BLL.bll_HoaDon;
import DTO.dto_HDMuon;

import java.util.Date;
import java.util.Scanner;

import static BLL.bll_KT.*;
import static DAL.dal_HDMuon.DocFile_HDMuon;

public class gui_HDMuon {
    Scanner sc = new Scanner(System.in);
    bll_HoaDon bll_hdMuon = new bll_HDMuon();
    dto_HDMuon dto_hdMuon = new dto_HDMuon();

    public gui_HDMuon() {
    }

    public void TrangHDMuon() {
        System.out.println("-------------     Chào Mừng Bạn Đến Với Trang Hóa đơn mượn       -------------");
        System.out.println("1. Hiển thị danh sách Hóa đơn mượn ");
        System.out.println("2. Thêm một Hóa đơn mượn ");
        System.out.println("3. Sửa một Hóa đơn mượn");
        System.out.println("4. Xóa một Hóa đơn mượn ");
        System.out.println("5. Về màn hình chính");
        System.out.println("6. Thoát ");
        System.out.println("---------Mời bạn nhập lựa chọn--------");
        String lc;
        lc = sc.nextLine();
        int toithieu = 1;
        int toida = 6;
        while (!SoGioiHan(lc, toithieu, toida)) {
            System.out.println("---------Bạn đã nhập số lựa chọn không chính xác--------");
            System.out.println("---------Mời bạn nhập lựa chọn--------");
            lc = sc.nextLine();

        }

        switch (Integer.parseInt(lc)) {
            case 1:
                System.out.println("---------Hiển thị danh dách một Hóa đơn mượn -------------");
                HienThiDanhSach();
                TrangHDMuon();
                break;
            case 2:
                System.out.println("---------Thêm một Hóa đơn mượn -------------");
                them();
                TrangHDMuon();
                break;
            case 3:
                System.out.println("---------Sửa một Hóa đơn mượn -------------");
                sua();
                TrangHDMuon();
                break;
            case 4:
                System.out.println("---------Xóa một Hóa đơn mượn -------------");
                xoa();
                TrangHDMuon();
                break;
            case 5:
                System.out.println("---------Quay về màn hình chính -------------");
                quayvemanhinhchinh();
                break;
            case 6:
                thoat();
                break;
        }
    }

    public void them() {
//        dto_Sach dto_sach[]=DocFile_Sach();
        String MaNV, MaSV, Soluong, TienCoc, TongGia, NgTam;
        Date NgLapHD;
        boolean check;
        System.out.println("Xin mời nhập Mã nhân viên: ");
        MaNV = sc.nextLine();

        System.out.println("Xin mời nhập Mã sinh viên: ");
        MaSV = sc.nextLine();

        NgTam="";
        boolean tam=false;
        while (!tam){
            System.out.println("Xin mời nhập lại Ngày lập hóa đơn: ");
            NgTam = sc.nextLine();
            tam=checkngay(NgTam);
        }

        NgLapHD = Chuyen_String_Date(NgTam);

        System.out.println("Xin mời nhập Số lượng sách: ");
        Soluong = sc.nextLine();
        check = Check_Num(Soluong);
        while (!check) {
            System.out.println("Nhập sai mời nhập lại Số lượng sách: ");
            Soluong = sc.nextLine();
            check = Check_Num(Soluong);
        }

        System.out.println("Xin mời nhập Tổng tiền: ");
        TongGia = sc.nextLine();
        check = Check_Num(TongGia);
        while (!check) {
            System.out.println("Nhập sai mời nhập lại Tổng tiền: ");
            TongGia = sc.nextLine();
            check = Check_Num(TongGia);
        }

        System.out.println("Xin mời nhập Tiền đặt cọc sách: ");
        TienCoc = sc.nextLine();
        check = Check_Num(TienCoc);
        while (!check) {
            System.out.println("Nhập sai mời nhập lại Tiền đặt cọc sách: ");
            TienCoc = sc.nextLine();
            check = Check_Num(TienCoc);
        }
        dto_hdMuon = new dto_HDMuon(null, MaNV, MaSV,NgLapHD, Integer.parseInt(Soluong),
                Integer.parseInt(TienCoc), Integer.parseInt(TongGia));           //   3-A-A-A-A-A-12/07/2001
        bll_hdMuon.them(dto_hdMuon);
    }

    public void sua() {
        System.out.println("Mời bạn nhập id muốn sửa ");
        int id = sc.nextInt();
        System.out.println("Bạn chắc chứ: ");
        System.out.println("1. Chắc");
        System.out.println("2. Chưa");
        String lc = sc.nextLine();
        while (!SoGioiHan(lc, 1, 2)) {
            System.out.println("Nhập sai mời nhập lại lựa chọn: ");
            lc = sc.nextLine();
        }
        if (lc.equals("1")) {
            String MaNV, MaSV, Soluong, TienCoc, TongGia, NgTam;
            Date NgLapHD;
            boolean check;
            System.out.println("Xin mời nhập Mã nhân viên: ");
            MaNV = sc.nextLine();

            System.out.println("Xin mời nhập Mã sinh viên: ");
            MaSV = sc.nextLine();

            System.out.println("Xin mời nhập Lập hóa đơn: ");
            NgTam = sc.nextLine();
            NgLapHD = Chuyen_String_Date(sc.nextLine());

            System.out.println("Xin mời nhập Số lượng sách: ");
            Soluong = sc.nextLine();
            check = Check_Num(Soluong);
            while (!check) {
                System.out.println("Nhập sai mời nhập lại Số lượng sách: ");
                Soluong = sc.nextLine();
                check = Check_Num(Soluong);
            }

            System.out.println("Xin mời nhập Tổng tiền: ");
            TongGia = sc.nextLine();
            check = Check_Num(TongGia);
            while (!check) {
                System.out.println("Nhập sai mời nhập lại Tổng tiền: ");
                TongGia = sc.nextLine();
                check = Check_Num(TongGia);
            }

            System.out.println("Xin mời nhập Tiền đặt cọc sách: ");
            TienCoc = sc.nextLine();
            check = Check_Num(TienCoc);
            while (!check) {
                System.out.println("Nhập sai mời nhập lại Tiền đặt cọc sách: ");
                TienCoc = sc.nextLine();
                check = Check_Num(TienCoc);
            }
            dto_hdMuon = new dto_HDMuon(null, MaNV, MaSV,NgLapHD, Integer.parseInt(Soluong),
                    Integer.parseInt(TienCoc), Integer.parseInt(TongGia));             //   3-A-A-A-A-A-12/07/2001
            bll_hdMuon.sua(dto_hdMuon, id);


        }

    }
    public void xoa() {
        System.out.println("Mời bạn nhập id muốn xóa ");
        int i = sc.nextInt();
        System.out.println("Bạn chắc chứ: ");
        System.out.println("1. Chắc");
        System.out.println("2. Chưa");
        String lc = sc.nextLine();
        while (!SoGioiHan(lc, 1, 2)) {
            System.out.println("Nhập sai mời nhập lại lựa chọn: ");
            lc = sc.nextLine();
        }

        if (lc.equals("1")) {
            bll_hdMuon.xoa(i);
        }
    }
    public void HienThiDanhSach() {
        dto_HDMuon hdn[] = DocFile_HDMuon();
        System.out.println("MaHD  - MaNV -  MaSV  - Ngày Lập HĐ - Tổng Sách   -   Tổng tiền sách - Tiền đặt cọc");
        for (int i = 0; i < hdn.length; i++)
            System.out.println(" " + hdn[i].getIdHD() + "        " +
                                    hdn[i].getIdNV() + "         " +
                                    hdn[i].getIdSV() + "       " +
                                    Chuyen_Date_String(hdn[i].getNgayLap()) + "      " +
                                    hdn[i].getTongSach() + "             " +
                                    hdn[i].getTongtienSach()+"   "+
                                    hdn[i].getTienDatCoc());
        gui_CTHDNhap cthdt=new gui_CTHDNhap();
        cthdt.HienThiDanhSach();
    }

    public void thoat() {
        System.out.println("xin chào và hen gặp lại ");
    }

    public void quayvemanhinhchinh() {
        Main m=new Main();
        m.TrangChinh();

    }


//    public static void main(String[] args) {
//        gui_CTHDNhap sv = new gui_CTHDNhap();
//        sv.TrangCTHDN();
//    }
}
