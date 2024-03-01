package GUI;

import BLL.bll_HDNhap;
import BLL.bll_HoaDon;
import DTO.dto_HDNhap;
import java.util.Date;
import java.util.Scanner;
import static BLL.bll_KT.*;
import static DAL.dal_HDNhap.DocFile_HDNhap;

public class gui_HDNhap {
    Scanner sc = new Scanner(System.in);
    bll_HoaDon bll_hdn = new bll_HDNhap();
    dto_HDNhap dto_hdn = new dto_HDNhap();

    public gui_HDNhap() {
    }

    public void TrangHDN() {
        System.out.println("-------------     Chào Mừng Bạn Đến Với Trang Hóa đơn nhập       -------------");
        System.out.println("1. Hiển thị danh sách Hóa đơn nhập ");
        System.out.println("2. Thêm một Hóa đơn nhập ");
        System.out.println("3. Sửa một Hóa đơn nhập");
        System.out.println("4. Xóa một Hóa đơn nhập ");
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
                System.out.println("---------Hiển thị danh dách một Hóa đơn nhập -------------");
                HienThiDanhSach();
                TrangHDN();
                break;
            case 2:
                System.out.println("---------Thêm một Hóa đơn nhập -------------");
                them();
                break;
            case 3:
                System.out.println("---------Sửa một Hóa đơn nhập -------------");
                sua();
                break;
            case 4:
                System.out.println("---------Xóa một Hóa đơn nhập -------------");
                xoa();
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
        String so, Manv, Maloai, Tongsach, TongGia, NgayNhap;
        Date ngayNhap;
        boolean check;
        System.out.println("Xin mời nhập Mã nhân viên: ");
        Manv = sc.nextLine();
        System.out.println("Xin mời nhập Mã loại: ");
        Maloai = sc.nextLine();
        System.out.println("Xin mời nhập Tổng sách: ");
        Tongsach = sc.nextLine();
        check = Check_Num(Tongsach);
        while (!check) {
            System.out.println("Nhập sai mời nhập lại Tổng sách: ");
            Tongsach = sc.nextLine();
            check = Check_Num(Tongsach);
        }

        System.out.println("Xin mời nhập Tổng giá: ");
        TongGia = sc.nextLine();
        check = Check_Num(TongGia);
        while (!check) {
            System.out.println("Nhập sai mời nhập lại Tổng giá: ");
            TongGia = sc.nextLine();
            check = Check_Num(TongGia);
        }

        NgayNhap="";
        boolean tam=false;
        while (!tam){
            System.out.println("Xin mời nhập lại Ngày Nhập: ");
            NgayNhap = sc.nextLine();
            tam=checkngay(NgayNhap);
        }

        ngayNhap = Chuyen_String_Date(NgayNhap);

        dto_hdn = new dto_HDNhap(null, Manv, Maloai, Integer.parseInt(Tongsach), Integer.parseInt(TongGia), ngayNhap);           //   3-A-A-A-A-A-12/07/2001
        bll_hdn.them(dto_hdn);

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
            String so, Manv, Maloai, Tongsach, TongGia, NgayNhap;
            Date ngayNhap;
            boolean check;
            System.out.println("Xin mời nhập Mã nhân viên: ");
            Manv = sc.nextLine();
            System.out.println("Xin mời nhập Mã loại: ");
            Maloai = sc.nextLine();
            System.out.println("Xin mời nhập Tổng sách: ");
            Tongsach = sc.nextLine();
            check = Check_Num(Tongsach);
            while (!check) {
                System.out.println("Nhập sai mời nhập lại Tổng sách: ");
                Tongsach = sc.nextLine();
                check = Check_Num(Tongsach);
            }

            System.out.println("Xin mời nhập Tổng giá: ");
            TongGia = sc.nextLine();
            check = Check_Num(TongGia);
            while (!check) {
                System.out.println("Nhập sai mời nhập lại Tổng giá: ");
                Tongsach = sc.nextLine();
                check = Check_Num(TongGia);
            }

            NgayNhap="";
            boolean tam=false;
            while (!tam){
                System.out.println("Xin mời nhập lại Ngày Nhập: ");
                NgayNhap = sc.nextLine();
                tam=checkngay(NgayNhap);
            }
            ngayNhap = Chuyen_String_Date(NgayNhap);

            dto_hdn = new dto_HDNhap(null, Manv, Maloai, Integer.parseInt(Tongsach), Integer.parseInt(TongGia), ngayNhap);           //   3-A-A-A-A-A-12/07/2001
            // dto_SV(...........), ID
            bll_hdn.sua(dto_hdn, id);


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
            bll_hdn.xoa(i);
        }
    }
    public void HienThiDanhSach() {
        dto_HDNhap hdn[] = DocFile_HDNhap();
        System.out.println("MaHD  - MaNV -   MaLoai   -   Tổng Sách -   Tổng giá   - Ngày nhập");
        for (int i = 0; i < hdn.length; i++)
            System.out.println(hdn[i].getIdHD() + "        " + hdn[i].getIdNV() + "         "
                    + hdn[i].getIdLoai() + "          "
                    + hdn[i].getTongSach() + "         " + hdn[i].getTongGia() + "          "
                    + Chuyen_Date_String(hdn[i].getNgayNhap()));
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



    public static void main(String[] args) {
        gui_HDNhap sv = new gui_HDNhap();
        sv.TrangHDN();
    }
}
