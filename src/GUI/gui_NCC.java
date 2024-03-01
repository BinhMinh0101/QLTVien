package GUI;

import BLL.bll_NCC;
import DTO.dto_LoaiSach;
import DTO.dto_NCC;


import java.util.Scanner;

import static BLL.bll_KT.SoGioiHan;
import static DAL.dal_LoaiSach.DocFile_LoaiSach;
import static DAL.dal_NCC.DocFile_NCC;


public class gui_NCC {
    Scanner sc = new Scanner(System.in);
    bll_NCC bll_ncc = new bll_NCC();
    dto_NCC dto_ncc = new dto_NCC();

    public gui_NCC() {
    }

    public void TrangLoaiSach() {
        System.out.println("-------------     Chào Mừng Bạn Đến Với Loại NCC      -------------");
        System.out.println("1. Hiển thị danh NCC Loại NCC ");
        System.out.println("2. Thêm một Loại NCC ");
        System.out.println("3. Sửa một Loại NCC");
        System.out.println("4. Xóa một Loại NCC ");
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
                System.out.println("---------Hiển thị một Loại NCC -------------");
                HienThiDanhSach();
                TrangLoaiSach();
                break;
            case 2:
                System.out.println("---------Thêm một Loại NCC -------------");
                them();
                TrangLoaiSach();
                break;
            case 3:
                System.out.println("---------Sửa một Loại NCC -------------");
                sua();
                TrangLoaiSach();
                break;
            case 4:
                System.out.println("---------Xóa một Loại NCC -------------");
                xoa();
                TrangLoaiSach();
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
        String TenNCC;
        System.out.println("Xin mời nhập Tên Loại NCC: ");
        TenNCC = sc.nextLine();
        dto_ncc = new dto_NCC(null, TenNCC);
        bll_ncc.them(dto_ncc);
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
            String TenNCC;
            System.out.println("Xin mời nhập Tên Loại NCC: ");
            TenNCC = sc.nextLine();
            dto_ncc = new dto_NCC(null, TenNCC);
            bll_ncc.sua(dto_ncc, id);
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
            bll_ncc.xoa(i);
        }
    }
    public void HienThiDanhSach(){
        dto_NCC dto_ncc[] = DocFile_NCC();
        System.out.println("MaNCC  - TenNCC");
        for(int i = 0; i< dto_ncc.length; i++)
            System.out.println(dto_ncc[i].getIdNCC() + "    " + dto_ncc[i].getTenNCC());
    }

    public void thoat() {
        System.out.println("xin chào và hen gặp lại ");
    }

    public void quayvemanhinhchinh() {
        Main m=new Main();
        m.TrangChinh();

    }

    public static void main(String[] args) {
        gui_NCC ncc=new gui_NCC();
        ncc.TrangLoaiSach();
    }
}
