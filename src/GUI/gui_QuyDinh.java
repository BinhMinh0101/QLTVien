package GUI;

import BLL.bll_QuyDinh;
import DTO.dto_QuyDinh;

import java.util.Scanner;

import static BLL.bll_KT.SoGioiHan;
import static DAL.dal_QuyDinh.DocFile_QD;


public class gui_QuyDinh {
    Scanner sc = new Scanner(System.in);
    bll_QuyDinh bll_QD = new bll_QuyDinh();
    dto_QuyDinh dto_QD = new dto_QuyDinh();

    public gui_QuyDinh() {
    }

    public void TrangQuyDinh() {
        System.out.println("-------------     Chào Mừng Bạn Đến Với Trang Quy Dinh       -------------");
        System.out.println("1. Hiển thị danh sách quy định ");
        System.out.println("2. Thêm một quy định ");
        System.out.println("3. Sửa một quy định");
        System.out.println("4. Xóa một quy định ");
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
                System.out.println("---------Hiển thị quy định -------------");
                HienThiQuyDinh();
                break;
            case 2:
                System.out.println("---------Thêm một quy định -------------");
                them();
                break;
            case 3:
                System.out.println("---------Sửa một quy định -------------");
                sua();
                break;
            case 4:
                System.out.println("---------Xóa một quy định -------------");
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
        String TenQuyDinh;
        int TienPhat;
        System.out.println("Xin mời nhập Tên Quy Định: ");
        TenQuyDinh = sc.nextLine();
        System.out.println("Xin mời nhập Tiền Phạt: ");
        TienPhat = sc.nextInt();
        dto_QD = new dto_QuyDinh(null, TenQuyDinh, TienPhat);
        bll_QD.them(dto_QD);
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
            String idQuyDinh;
            String TenQuyDinh;
            int TienPhat;
            System.out.println("Xin mới nhập Id Quy Định");
            idQuyDinh = sc.nextLine();
            System.out.println("Xin mời nhập Tên Quy Định: ");
            TenQuyDinh = sc.nextLine();
            System.out.println("Xin mời nhập Tiền Phạt: ");
            TienPhat = sc.nextInt();
            dto_QD = new dto_QuyDinh(idQuyDinh, TenQuyDinh, TienPhat); // dto_SV(...........), I
            bll_QD.sua(dto_QD, id);
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
            bll_QD.xoa(i);
        }
    }

    public void HienThiQuyDinh() {
        dto_QuyDinh QD[] = DocFile_QD();
        System.out.println("IdQuyDinh        -    TênQuyDinh       -   TienPhat");
        for (int i = 0; i < QD.length; i++)
            System.out.println(QD[i].getIdQuyDinh() + "    " + QD[i].getTenQuyDinh() + "    " + QD[i].getTienPhat());
    }


    public void thoat() {
        System.out.println("xin chào và hen gặp lại ");
    }

    public void quayvemanhinhchinh() {
        Main m=new Main();
        m.TrangChinh();

    }

    public static void main(String[] args) {
        gui_QuyDinh QD = new gui_QuyDinh();
        QD.TrangQuyDinh();
    }
}
