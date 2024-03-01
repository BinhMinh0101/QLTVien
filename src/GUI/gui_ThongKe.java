package GUI;

import java.util.Scanner;

import static BLL.bll_KT.SoGioiHan;

public class gui_ThongKe {
    Scanner sc = new Scanner(System.in);

    public gui_ThongKe() {
    }

    public void TrangThongKe() {
        System.out.println("-------------     Chào Mừng Bạn Đến Với Trang thống kê   -------------");
        System.out.println("1. Thống kê Nhập ");
        System.out.println("2. Thống kê Mượn ");
        System.out.println("3. Thống kê Trả");
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
                System.out.println("--------------           Thống kê theo Nhập                   -------------");
                gui_TKNhap tkNhap = new gui_TKNhap();
                tkNhap.TrangThongKeNhap();
                TrangThongKe();
                break;
            case 2:
                System.out.println("--------------           Thống kê theo Mượn                   -------------");
                gui_ThongKeMuon tkMuon=new gui_ThongKeMuon();
                tkMuon.TrangThongKeMuon();
                TrangThongKe();
                break;
            case 3:
                System.out.println("--------------           Thống kê theo Trả                    -------------");
                gui_ThongKeTra tkTra=new gui_ThongKeTra();
                tkTra.TrangThongKeTra();
                TrangThongKe();
                break;
            case 4:
                System.out.println("-------------           Quay về màn hình chính                -------------");
                quayvemanhinhchinh();
                break;
            case 5:
                thoat();
                break;
        }
    }
    public void thoat() {
        System.out.println("xin chào và hen gặp lại ");
    }
    public void quayvemanhinhchinh() {
        Main m = new Main();
        m.TrangChinh();

    }

    public static void main(String[] args) {
        gui_ThongKe t=new gui_ThongKe();
        t.TrangThongKe();
    }
}
