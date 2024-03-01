package GUI;

import java.io.IOException;
import java.util.Scanner;

import static BLL.bll_KT.SoGioiHan;

public class Main {
    public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.TrangChinh();
    }
    Scanner sc = new Scanner(System.in);
    public void TrangChinh() {
        System.out.println("-------------     Chào Mừng Bạn Bạn muốn chọn    -------------");
        System.out.println("1. Sinh Viên ");
        System.out.println("2. Nhân Viên ");
        System.out.println("3. Hóa Đơn Mượn ");
        System.out.println("4. Hóa Đơn Trả ");
        System.out.println("5. Hóa đơn Nhập ");
        System.out.println("6. Sách ");
        System.out.println("7. Loại Sách ");
        System.out.println("8. NCC ");
        System.out.println("9. Quy Định ");
        System.out.println("10. Thống kê ");
        System.out.println("11. Thoát ");
        System.out.println("---------Mời bạn nhập lựa chọn--------");
        String lc;
        lc = sc.nextLine();
        int toithieu = 1;
        int toida = 9;
        if (!lc.equals("10") && !lc.equals("11"))
            while (!SoGioiHan(lc, toithieu, toida)) {
                System.out.println("---------Bạn đã nhập số lựa chọn không chính xác--------");
                System.out.println("---------Mời bạn nhập lựa chọn--------");
                lc = sc.nextLine();

            }

        switch (Integer.parseInt(lc)) {
            case 1:
                System.out.println("--------- Sinh viên -------------");
                gui_SinhVien sv = new gui_SinhVien();
                sv.TrangSinhVien();
                break;
            case 2:
                System.out.println("--------- Nhân Viên -------------");
                gui_NhanVien nv = new gui_NhanVien();
                nv.TrangNhanVien();
                break;
            case 3:
                System.out.println("--------- Hóa Đơn Mượn -------------");
                gui_HDMuon hdm = new gui_HDMuon();
                hdm.TrangHDMuon();
                break;
            case 4:
                System.out.println("--------- Hóa Đơn Trả -------------");
                gui_HDTra hdt = new gui_HDTra();
                hdt.TrangHDTra();
                break;
            case 5:
                System.out.println("--------- Hóa đơn Nhập -------------");
                gui_HDNhap hdn = new gui_HDNhap();
                hdn.TrangHDN();
                break;
            case 6:
                System.out.println("--------- Sách -------------");
                gui_Sach sach = new gui_Sach();
                sach.TrangSach();
                break;
            case 7:
                System.out.println("--------- Loại Sách -------------");
                gui_LoaiSach loaiSach = new gui_LoaiSach();
                loaiSach.TrangLoaiSach();
                break;
            case 8:
                System.out.println("--------- Nhà cung cấp -------------");
                gui_NCC ncc = new gui_NCC();
                ncc.TrangLoaiSach();
                break;
            case 9:
                System.out.println("--------- Quy định -------------");
                gui_QuyDinh qd = new gui_QuyDinh();
                qd.TrangQuyDinh();
                break;
            case 10:
                System.out.println("--------- Thống kê -------------");
                gui_ThongKe tk = new gui_ThongKe();
                tk.TrangThongKe();
                break;
            case 11:
                thoat();
                break;

        }
    }
    public void thoat() {
        System.out.println("xin chào và hẹn gặp lại ");
    }
}
