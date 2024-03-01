package GUI;

import BLL.bll_ConNguoi;
import BLL.bll_NhanVien;
import DTO.dto_NhanVien;
import DTO.dto_SinhVien;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static BLL.bll_KT.*;
import static DAL.dal_NhanVien.DocFile_NV;
import static DAL.dal_SinhVien.DocFile_SV;

public class gui_NhanVien {
    Scanner sc = new Scanner(System.in);
    bll_ConNguoi bll_nv = new bll_NhanVien();
    dto_NhanVien dto_nv = new dto_NhanVien();

    public gui_NhanVien() {
    }

    public void TrangNhanVien() {
        System.out.println("-------------     Chào Mừng Bạn Đến Với Trang Nhân viên       -------------");
        System.out.println("1. Hiển thị danh sách Nhân viên ");
        System.out.println("2. Thêm một Nhân viên ");
        System.out.println("3. Sửa một Nhân viên");
        System.out.println("4. Xóa một Nhân viên ");
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
                System.out.println("---------Hiển thị danh dách một Nhân viên -------------");
                HienThiDanhSach();
                TrangNhanVien();
                break;
            case 2:
                System.out.println("---------Thêm một Nhân viên -------------");
                them();
                TrangNhanVien();
                break;
            case 3:
                System.out.println("---------Sửa một Nhân viên -------------");
                sua();
                TrangNhanVien();
                break;
            case 4:
                System.out.println("---------Xóa một Nhân viên -------------");
                xoa();
                TrangNhanVien();
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
        String so;
        String hoTen;
        String phai = null;
        String diaChi;
        String sdt;
        String ngaySinh;
        Date ngaysinhdate;
        String ngayVaoLam;
        Date ngayVLDate;
        System.out.println("Xin mời nhập Họ Và Tên: ");
        hoTen = sc.nextLine();
        System.out.println("Xin mời nhập phái: ");
        System.out.println("1. nam");
        System.out.println("2. nữ");
        System.out.println("3. khác");
        so = sc.nextLine();
        while (!SoGioiHan(so, 1, 3)) {
            System.out.println("Nhập sai mời nhập lại: ");
            System.out.println("Xin mời nhập phái: ");
            System.out.println("1. nam");
            System.out.println("2. nữ");
            System.out.println("3. khác");
            so = sc.nextLine();
        }
        if (so.equals("1"))
            phai = "nam";
        if (so.equals("2"))
            phai = "nữ";
        if (so.equals("3"))
            phai = "khác";

        System.out.println("Xin mời nhập Địa Chỉ: ");
        diaChi = sc.nextLine();
        System.out.println("Xin mời nhập Số điện thoại: ");
        sdt = sc.nextLine();
        while (!SoDienThoai(sdt)) {
            System.out.println("Nhập sai mời nhập lại: ");
            sdt = sc.nextLine();
        }


        ngaySinh="";
        boolean tam=false;
        while (!tam){
            System.out.println("Xin mời nhập lại Ngày Sinh: ");
            ngaySinh = sc.nextLine();
            tam=checkngay(ngaySinh);
        }

        ngaysinhdate = Chuyen_String_Date(ngaySinh);


        ngayVaoLam="";

        tam=false;
        while (!tam){
            System.out.println("Xin mời nhập lại Ngày vào làm: ");
            ngayVaoLam = sc.nextLine();
            tam=checkngay(ngayVaoLam);
        }
        ngayVLDate = Chuyen_String_Date(ngayVaoLam);// dto_SV(...........), ID

        dto_nv=new dto_NhanVien(null,hoTen,phai,diaChi,sdt,ngaysinhdate,ngayVLDate);         //   3-A-A-A-A-A-12/07/2001
        try {
            bll_nv.them(dto_nv);
        } catch (IOException e) {
            e.printStackTrace();
        }

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
            String so;
            String hoTen;
            String phai = null;
            String diaChi;
            String sdt;
            String ngaySinh;
            Date ngaysinhdate;
            String ngayVaoLam;
            Date ngayVLDate;
            System.out.println("Xin mời nhập Họ Và Tên: ");
            hoTen = sc.nextLine();
            System.out.println("Xin mời nhập phái: ");
            System.out.println("1. nam");
            System.out.println("2. nữ");
            System.out.println("3. khác");
            so = sc.nextLine();
            while (!SoGioiHan(so, 1, 3)) {
                System.out.println("Nhập sai mời nhập lại: ");
                System.out.println("Xin mời nhập phái: ");
                System.out.println("1. nam");
                System.out.println("2. nữ");
                System.out.println("3. khác");
                so = sc.nextLine();
            }
            if (so.equals("1"))
                phai = "nam";
            if (so.equals("2"))
                phai = "nữ";
            if (so.equals("3"))
                phai = "khác";

            System.out.println("Xin mời nhập Địa Chỉ: ");
            diaChi = sc.nextLine();
            System.out.println("Xin mời nhập Số điện thoại: ");
            sdt = sc.nextLine();
            while (!SoDienThoai(sdt)) {
                System.out.println("Nhập sai mời nhập lại: ");
                sdt = sc.nextLine();
            }


            ngaySinh="";
            boolean tam=false;
            while (!tam){
                System.out.println("Xin mời nhập Ngày Sinh: ");
                ngaySinh = sc.nextLine();
                tam=checkngay(ngaySinh);
            }

            ngaysinhdate = Chuyen_String_Date(ngaySinh);


            ngayVaoLam="";

            tam=false;
            while (!tam){
                System.out.println("Xin mời nhập Ngày vào làm: ");
                ngayVaoLam = sc.nextLine();
                tam=checkngay(ngayVaoLam);
            }
            ngayVLDate = Chuyen_String_Date(ngayVaoLam);// dto_SV(...........), ID

            dto_nv=new dto_NhanVien(null,hoTen,phai,diaChi,sdt,ngaysinhdate,ngayVLDate);
            try {
                bll_nv.sua(dto_nv, id);
            } catch (IOException e) {
                e.printStackTrace();
            }
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
            try {
                bll_nv.xoa(i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void HienThiDanhSach() {
        dto_NhanVien sv[] = DocFile_NV();
        System.out.println("MSSV   -    HọTên       -   Phai  -   ĐịaChỉ      -         SĐT     -   NgàySinh   -      Ngày vào làm");
        for (int i = 0; i < sv.length; i++)
            System.out.println( sv[i].getIdNV() + "        "
                                + sv[i].getHoTen() + "      "
                                + sv[i].getPhai() + "          "
                                + sv[i].getDiaChi() + "          "
                                + sv[i].getSdt() + "        "
                                + Chuyen_Date_String(sv[i].getNgaySinh())+"   "
                                + Chuyen_Date_String(sv[i].getNgayVaoLam()));
    }

    public void thoat() {
        System.out.println("xin chào và hen gặp lại ");
    }

    public void quayvemanhinhchinh() {
        Main m=new Main();
        m.TrangChinh();

    }

    private static Date Chuyen_String_Date(String ngaySinh) {
        Date ngay = new Date();
        SimpleDateFormat Format = new SimpleDateFormat("dd/MM/yyyy");   // Định dạng ngày tháng trong chuỗi
        Date ngsinh = null;
        try {
            ngsinh = Format.parse(ngaySinh);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return ngsinh;
    }

    public static void main(String[] args) {
        gui_NhanVien nv=new gui_NhanVien();
        nv.TrangNhanVien();
    }
}

