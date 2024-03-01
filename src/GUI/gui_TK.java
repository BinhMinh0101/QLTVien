package GUI;

import BLL.bll_TaiKhoan;
import DTO.dto_TaiKhoan;

import java.io.IOException;
import java.util.Scanner;

import static BLL.bll_KT.SoGioiHan;
import static DAL.dal_TaiKhoan.DocFile_TK;

public class gui_TK {
    Scanner sc = new Scanner(System.in);
    bll_TaiKhoan bll_TK = new bll_TaiKhoan();
    dto_TaiKhoan dto_TK = new dto_TaiKhoan();

    public gui_TK() {
    }

    public void TrangTaiKhoan() {
        System.out.println("-------------     Chào Mừng Bạn Đến Với Trang Tai Khoan       -------------");
        System.out.println("1. Hiển thị danh sách tài khoản ");
        System.out.println("2. Thêm một tài khoản mới ");
        System.out.println("3. Sửa một tài khoản");
        System.out.println("4. Xóa một tài khoản");
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
                System.out.println("---------Hiển thị danh dách tài khoản -------------");
                HienThiTK();
                break;
            case 2:
                System.out.println("---------Thêm một tài khoản mới -------------");
                them();
                break;
            case 3:
                System.out.println("---------Sửa một tài khoản -------------");
                sua();
                break;
            case 4:
                System.out.println("---------Xóa một tài khoản -------------");
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
        String Id;
        String Username;
        String Password;
        System.out.println("Xin mời nhập Username: ");
        Username = sc.nextLine();
        System.out.println("Xin mời nhập Password: ");
        Password = sc.nextLine();
        dto_TK = new dto_TaiKhoan(null, Username, Password);
        try {
            bll_TK.them(dto_TK);
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
            String Id;
            String Username;
            String Password;
            System.out.println("Xin mời nhập Id Tài Khoản: ");
            Id = sc.nextLine();
            System.out.println("Xin mời nhập Username: ");
            Username = sc.nextLine();
            System.out.println("Xin mời nhập Password: ");
            Password = sc.nextLine();
            dto_TK = new dto_TaiKhoan(String.valueOf(id), Username, Password); // dto_SV(...........), ID
            try {
                bll_TK.sua(dto_TK, id);
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
                bll_TK.xoa(i);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void HienThiTK(){
        dto_TaiKhoan TK[] = DocFile_TK();
        System.out.println("Id        -    Username       -   Password");
        for(int i = 0; i< TK.length; i++)
            System.out.println(TK[i].getId() + "    " + TK[i].getUsername() + "    " +  TK[i].getPassword());
    }

    public void thoat() {
        System.out.println("xin chào và hen gặp lại ");
    }

    public void quayvemanhinhchinh() {
        Main m=new Main();
        m.TrangChinh();

    }

    public static void main(String[] args) {
        gui_TK  TK = new gui_TK();
        TK.TrangTaiKhoan();

    }
}

