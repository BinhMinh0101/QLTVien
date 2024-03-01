package GUI;

import BLL.bll_LoaiSach;
import DTO.dto_LoaiSach;

import java.util.Scanner;

import static BLL.bll_KT.SoGioiHan;
import static DAL.dal_LoaiSach.DocFile_LoaiSach;
//import static DAL.dal_LoaiSach.DocFile;

public class gui_LoaiSach {
    Scanner sc = new Scanner(System.in);
    bll_LoaiSach bll_loaisach = new bll_LoaiSach();
    dto_LoaiSach dto_loaisach = new dto_LoaiSach();

    public gui_LoaiSach() {
    }

    public void TrangLoaiSach() {
        System.out.println("-------------     Chào Mừng Bạn Đến Với Loại Sách      -------------");
        System.out.println("1. Hiển thị danh sách Loại sách ");
        System.out.println("2. Thêm một Loại sách ");
        System.out.println("3. Sửa một Loại sách");
        System.out.println("4. Xóa một Loại sách ");
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
                System.out.println("---------Hiển thị một Loại sách -------------");
                HienThiDanhSach();
                break;
            case 2:
                System.out.println("---------Thêm một Loại sách -------------");
                them();
                break;
            case 3:
                System.out.println("---------Sửa một Loại sách -------------");
                sua();
                break;
            case 4:
                System.out.println("---------Xóa một Loại sách -------------");
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
        //String IdLoai;
        String TenLoai;
        /*
        System.out.println("Xin mời nhập Id Loại Sách: ");
        IdLoai = sc.nextLine();
        */
        System.out.println("Xin mời nhập Tên Loại Sách: ");
        TenLoai = sc.nextLine();
        dto_loaisach = new dto_LoaiSach(null, TenLoai);
        bll_loaisach.them(dto_loaisach);
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
            //String IdLoai;
            String TenLoai;
            /*
            System.out.println("Xin mời nhập Id Loại Sách: ");
            IdLoai = sc.nextLine();
            */

            System.out.println("Xin mời nhập Tên Loại Sách: ");
            TenLoai = sc.nextLine();
            dto_loaisach = new dto_LoaiSach( String.valueOf(id), TenLoai);
            bll_loaisach.sua(dto_loaisach, id);
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
            bll_loaisach.xoa(i);
        }
    }
    public void HienThiDanhSach(){
        dto_LoaiSach loaisach[] = DocFile_LoaiSach();
        System.out.println("IdLoai     -     TenLoai");
        for(int i = 0; i< loaisach.length; i++)
            System.out.println(loaisach[i].getIdLoai() + "    " + loaisach[i].getTenLoai());
    }

    public void thoat() {
        System.out.println("xin chào và hen gặp lại ");
    }

    public void quayvemanhinhchinh() {
        Main m=new Main();
        m.TrangChinh();

    }

    public static void main(String[] args) {
        gui_LoaiSach loaisach = new gui_LoaiSach();
        loaisach.TrangLoaiSach();
        //loaisach.them();
        //loaisach.xoa();
//        loaisach.sua();
    }
}
