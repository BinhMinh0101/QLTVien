package GUI;

import BLL.bll_Sach;
import DTO.dto_HDMuon;
import DTO.dto_HDTra;
import DTO.dto_Sach;

import java.util.Date;
import java.util.Scanner;

import static BLL.bll_KT.*;
import static DAL.dal_HDMuon.DocFile_HDMuon;
import static DAL.dal_HDTra.DocFile_HDTra;

public class gui_ThongKeMuon {
    Scanner sc = new Scanner(System.in);
    public gui_ThongKeMuon() {
    }
    public void TrangThongKeMuon() {
        System.out.println("-------------     Chào Mừng Bạn Đến Với Trang thống kê Mượn    -------------");
        System.out.println("1. Thống kê theo quý ");
        System.out.println("2. Thống kê theo năm ");
        System.out.println("3. Thống kê theo ngày");
        System.out.println("4. Về màn hình chính");
        System.out.println("5. Thoát ");
        System.out.println("---------Mời bạn nhập lựa chọn--------");
        String lc;
        lc = sc.nextLine();
        int toithieu = 1;
        int toida = 5;
        while (!SoGioiHan(lc, toithieu, toida)) {
            System.out.println("---------Bạn đã nhập số lựa chọn không chính xác--------");
            System.out.println("---------Mời bạn nhập lựa chọn--------");
            lc = sc.nextLine();

        }

        switch (Integer.parseInt(lc)) {
            case 1:
                System.out.println("---------Thống kê theo quý -------------");
                TK_Quy();
                TrangThongKeMuon() ;
                break;
            case 2:
                System.out.println("---------Thống kê theo năm -------------");
                TK_Nam();
                TrangThongKeMuon() ;
                break;
            case 3:
                System.out.println("---------Thống kê theo ngày -------------");
                TK_Ngay();
                TrangThongKeMuon() ;
                break;
            case 4:
                System.out.println("---------Quay về màn hình chính -------------");
                quayvemanhinhchinh();
                break;
            case 5:
                thoat();
                break;

        }
    }
    public void TK_Quy() {
        Date d1, d2;
        System.out.println("Xin mời nhâp năm: ");
        String nam = sc.nextLine();
        String namtam = nam;
        nam = "1/1/" + nam;

        while (!checkngay(nam)) {
            System.out.println("Nhập sai mời nhập lại năm: ");
            nam = sc.nextLine();
        }

        System.out.println("Xin mời nhâp quý: ");
        System.out.println("1. Qúy 1");
        System.out.println("2. Qúy 2");
        System.out.println("3. Qúy 3");
        System.out.println("4. Qúy 4");
        String quy = sc.nextLine();
        while (!SoGioiHan(quy, 1, 4)) {
            System.out.println("Nhập sai mời nhập lại lựa chọn: ");
            quy = sc.nextLine();
        }
        switch (Integer.parseInt(quy)) {
            case 1:
                d1 = Chuyen_String_Date(nam);
                System.out.println(nam);
                quy = "1/3/" + namtam;
                d2 = Chuyen_String_Date(quy);
                System.out.println(quy);
                TK_NgayMuon(d1, d2);
                break;
            case 2:
                d1 = Chuyen_String_Date(nam);
                quy = "1/6/" + namtam;
                d2 = Chuyen_String_Date(quy);
                TK_NgayMuon(d1, d2);
                break;
            case 3:
                d1 = Chuyen_String_Date(nam);
                quy = "1/9/" + namtam;
                d2 = Chuyen_String_Date(quy);
                TK_NgayMuon(d1, d2);
                break;
            case 4:
                d1 = Chuyen_String_Date(nam);
                quy = "1/12/" + namtam;
                d2 = Chuyen_String_Date(quy);
                TK_NgayMuon(d1, d2);
                break;
        }
    }
    public void TK_Nam() {
        Date d1;
        Date d2 = new Date();
        System.out.println("Xin mời nhâp năm: ");
        String nam = sc.nextLine();
        String namtam = nam;
        nam = "1/1/" + nam;

        while (!checkngay(nam)) {
            System.out.println("Nhập sai mời nhập lại năm: ");
            nam = sc.nextLine();
        }
        d1 = Chuyen_String_Date(nam);
        TK_NgayMuon(d1, d2);
    }
    public void TK_Ngay() {
        Date d1,d2;
        System.out.println("Xin mời nhâp từ ngày tháng năm : ");
        String ngaybd = sc.nextLine();

        while (!checkngay(ngaybd)) {
            System.out.println("Nhập sai mời nhập lại thời gian: ");
            ngaybd = sc.nextLine();

        }
        d1 = Chuyen_String_Date(ngaybd);
        System.out.println("Xin mời nhâp đến ngày tháng năm : ");
        String ngaykt = sc.nextLine();

        while (!checkngay(ngaykt)) {
            System.out.println("Nhập sai mời nhập lại : ");
            ngaykt = sc.nextLine();

        }
        d2 = Chuyen_String_Date(ngaykt);
        TK_NgayMuon(d1, d2);
    }
    public void TK_NgayMuon(Date d1, Date d2) {
        dto_HDMuon hdn[] = DocFile_HDMuon();
        int tongsach = 0, solan = 0;
        System.out.println("MaHD  - MaNV -  MaSV  - Ngày Lập HĐ - Tổng Sách   -   Tổng tiền sách - Tiền đặt cọc");
        for (int i = 0; i < hdn.length; i++) {
            Date ngay = hdn[i].getNgayLap();

            if (d1.before(ngay) && d2.after(ngay)) {

                System.out.println(" " + hdn[i].getIdHD() + "        " +
                        hdn[i].getIdNV() + "       " +
                        hdn[i].getIdSV() + "       " +
                        Chuyen_Date_String(hdn[i].getNgayLap()) + "      " +
                        hdn[i].getTongSach() + "             " +
                        hdn[i].getTongtienSach() + "               " +
                        hdn[i].getTienDatCoc());
                tongsach = tongsach + hdn[i].getTongSach();
                solan++;
            }
        }
        System.out.println("Tổng Sách   -  Số lần");
        System.out.println(tongsach + "             " + solan);
    }
    public void thoat() {
        System.out.println("xin chào và hen gặp lại ");
    }
    public void quayvemanhinhchinh() {
        Main m = new Main();
        m.TrangChinh();

    }
}
