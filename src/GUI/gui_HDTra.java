package GUI;

import BLL.bll_HDTra;
import BLL.bll_HoaDon;
import DTO.dto_HDTra;

import java.util.Date;
import java.util.Scanner;

import static BLL.bll_KT.*;
import static DAL.dal_HDTra.DocFile_HDTra;

public class gui_HDTra {

    Scanner sc = new Scanner(System.in);
    bll_HoaDon bll_hdTra = new bll_HDTra();
    dto_HDTra dto_hdTra = new dto_HDTra();

    public gui_HDTra() {
    }

    public void TrangHDTra() {
        System.out.println("-------------     Chào Mừng Bạn Đến Với Trang Hóa đơn trả       -------------");
        System.out.println("1. Hiển thị danh sách Hóa đơn trả ");
        System.out.println("2. Thêm một Hóa đơn trả ");
        System.out.println("3. Sửa một Hóa đơn trả");
        System.out.println("4. Xóa một Hóa đơn trả ");
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
                System.out.println("---------Hiển thị danh dách một Hóa đơn trả -------------");
                HienThiDanhSach();
                TrangHDTra();
                break;
            case 2:
                System.out.println("---------Thêm một Hóa đơn trả -------------");
                them();

                TrangHDTra();
                break;
            case 3:
                System.out.println("---------Sửa một Hóa đơn trả -------------");
                sua();
                TrangHDTra();
                break;
            case 4:
                System.out.println("---------Xóa một Hóa đơn trả -------------");
                xoa();
                TrangHDTra();
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
        String MaNV, MaSV, Soluong, TienPhat, TongGia, NgTam;
        Date NgTra;
        boolean check;
        System.out.println("Xin mời nhập Mã nhân viên: ");
        MaNV = sc.nextLine();

        System.out.println("Xin mời nhập Mã sinh viên: ");
        MaSV = sc.nextLine();

        NgTam="";
        boolean tam=false;
        while (!tam){
            System.out.println("Xin mời nhập Ngày trả hóa đơn: ");
            NgTam = sc.nextLine();
            tam=checkngay(NgTam);
        }
        NgTra = Chuyen_String_Date(NgTam);

        System.out.println("Xin mời nhập Số lượng sách: ");
        Soluong = sc.nextLine();
        check = Check_Num(Soluong);
        while (!check) {
            System.out.println("Nhập sai mời nhập lại Số lượng sách: ");
            Soluong = sc.nextLine();
            check = Check_Num(Soluong);
        }

        System.out.println("Xin mời nhập Tiền phạt: ");
        TienPhat = sc.nextLine();
        check = Check_Num(TienPhat);
        while (!check) {
            System.out.println("Nhập sai mời nhập lại Tiền phạt: ");
            TienPhat = sc.nextLine();
            check = Check_Num(TienPhat);
        }

        System.out.println("Xin mời nhập Tổng tiền: ");
        TongGia = sc.nextLine();
        check = Check_Num(TongGia);
        while (!check) {
            System.out.println("Nhập sai mời nhập lại Tổng tiền: ");
            TongGia = sc.nextLine();
            check = Check_Num(TongGia);
        }


        dto_hdTra = new dto_HDTra(null, MaNV, MaSV,NgTra, Integer.parseInt(Soluong),
                Integer.parseInt(TienPhat), Integer.parseInt(TongGia));           //   3-A-A-A-A-A-12/07/2001
        bll_hdTra.them(dto_hdTra);
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
            String MaNV, MaSV, Soluong, TienPhat, TongGia, NgTam;
            Date NgTra;
            boolean check;
            System.out.println("Xin mời nhập Mã nhân viên: ");
            MaNV = sc.nextLine();

            System.out.println("Xin mời nhập Mã sinh viên: ");
            MaSV = sc.nextLine();

            NgTam="";
            boolean tam=false;
            while (!tam){
                System.out.println("Xin mời nhập lại Ngày trả hóa đơn: ");
                NgTam = sc.nextLine();
                tam=checkngay(NgTam);
            }
            NgTra = Chuyen_String_Date(NgTam);

            System.out.println("Xin mời nhập Số lượng sách: ");
            Soluong = sc.nextLine();
            check = Check_Num(Soluong);
            while (!check) {
                System.out.println("Nhập sai mời nhập lại Số lượng sách: ");
                Soluong = sc.nextLine();
                check = Check_Num(Soluong);
            }

            System.out.println("Xin mời nhập Tiền phạt: ");
            TienPhat = sc.nextLine();
            check = Check_Num(TienPhat);
            while (!check) {
                System.out.println("Nhập sai mời nhập lại Tiền phạt: ");
                TienPhat = sc.nextLine();
                check = Check_Num(TienPhat);
            }

            System.out.println("Xin mời nhập Tổng tiền: ");
            TongGia = sc.nextLine();
            check = Check_Num(TongGia);
            while (!check) {
                System.out.println("Nhập sai mời nhập lại Tổng tiền: ");
                TongGia = sc.nextLine();
                check = Check_Num(TongGia);
            }


            dto_hdTra = new dto_HDTra(null, MaNV, MaSV,NgTra, Integer.parseInt(Soluong),
                    Integer.parseInt(TienPhat), Integer.parseInt(TongGia));              //   3-A-A-A-A-A-12/07/2001
            bll_hdTra.sua(dto_hdTra, id);


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
            bll_hdTra.xoa(i);
        }
    }

    public void HienThiDanhSach() {
        dto_HDTra hdn[] = DocFile_HDTra();
        System.out.println("MaHD  - MaNV -   MSSV   -   ngayTra -   tongSach   - tienPhat   -  tongtienSach");
        for (int i = 0; i < hdn.length; i++)
            System.out.println(" " + hdn[i].getIdHD() + "    " +
                    hdn[i].getIdNV() + "      " +
                    hdn[i].getIdSV() + "      " +
                    Chuyen_Date_String(hdn[i].getNgayTra()) + "      " +
                    hdn[i].getTongSach() + "         " +
                    hdn[i].getTienPhat()+"   "+
                    hdn[i].getTongtienSach());
        gui_CTHDTra cthdt=new gui_CTHDTra();
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
        gui_HDTra sv = new gui_HDTra();
        sv.TrangHDTra();
    }
}
