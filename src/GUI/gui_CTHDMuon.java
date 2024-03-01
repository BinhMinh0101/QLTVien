package GUI;

import BLL.bll_CTHDMuon;
import DTO.dto_CTHDMuon;
import DTO.dto_CTHDNhap;

import java.util.Scanner;

import static BLL.bll_KT.Check_Num;
import static BLL.bll_KT.SoGioiHan;
import static DAL.dal_CTHDMuon.DocFile_CTHDMuon;


public class gui_CTHDMuon {

    Scanner sc = new Scanner(System.in);
    bll_CTHDMuon bll_CTHDMuon = new bll_CTHDMuon();
    dto_CTHDMuon dto_cthdMuon = new dto_CTHDMuon();

    public gui_CTHDMuon() {
    }

    public void TrangHDMuon() {
        System.out.println("-------------     Chào Mừng Bạn Đến Với Trang Chi tiết hóa đơn mượn       -------------");
        System.out.println("1. Hiển thị danh sách Chi tiết hóa đơn mượn ");
        System.out.println("2. Thêm một Chi tiết hóa đơn mượn ");
        System.out.println("3. Sửa một Chi tiết hóa đơn mượn");
        System.out.println("4. Xóa một Chi tiết hóa đơn mượn ");
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
                System.out.println("---------Hiển thị danh dách một Chi tiết hóa đơn mượn -------------");
                HienThiDanhSach();
                TrangHDMuon();
                break;
            case 2:
                System.out.println("---------Thêm một Chi tiết hóa đơn mượn -------------");
                them();
                TrangHDMuon();
                break;
            case 3:
                System.out.println("---------Sửa một Chi tiết hóa đơn mượn -------------");
                sua();
                TrangHDMuon();
                break;
            case 4:
                System.out.println("---------Xóa một Chi tiết hóa đơn mượn -------------");
                xoa();
                TrangHDMuon();
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
        String Masach, NCC, Soluong, Tiensach, TongGia;
        boolean check;
        System.out.println("Xin mời nhập Mã Sách: ");
        Masach = sc.nextLine();

        System.out.println("Xin mời nhập NCC: ");
        NCC = sc.nextLine();

        System.out.println("Xin mời nhập Số lượng sách: ");
        Soluong = sc.nextLine();
        check = Check_Num(Soluong);
        while (!check) {
            System.out.println("Nhập sai mời nhập lại Số lượng sách: ");
            Soluong = sc.nextLine();
            check = Check_Num(Soluong);
        }
        System.out.println("Xin mời nhập Tiền sách: ");
        Tiensach = sc.nextLine();
        check = Check_Num(Tiensach);
        while (!check) {
            System.out.println("Nhập sai mời nhập lại Tiền sách: ");
            Tiensach = sc.nextLine();
            check = Check_Num(Tiensach);
        }
//        for(int i=0;)


        System.out.println("Xin mời nhập Tổng tiền: ");
        TongGia = sc.nextLine();
        check = Check_Num(TongGia);
        while (!check) {
            System.out.println("Nhập sai mời nhập lại Tổng tiền: ");
            TongGia = sc.nextLine();
            check = Check_Num(TongGia);
        }
        dto_cthdMuon = new dto_CTHDMuon(null, Masach, NCC, Integer.parseInt(Soluong),
                Integer.parseInt(Tiensach), Integer.parseInt(TongGia));           //   3-A-A-A-A-A-12/07/2001
        bll_CTHDMuon.them(dto_cthdMuon);
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
            String Masach, NCC, Soluong, Tiensach, TongGia;
            boolean check;
            System.out.println("Xin mời nhập Mã Sách: ");
            Masach = sc.nextLine();

            System.out.println("Xin mời nhập NCC: ");
            NCC = sc.nextLine();

            System.out.println("Xin mời nhập Số lượng sách: ");
            Soluong = sc.nextLine();
            check = Check_Num(Soluong);
            while (!check) {
                System.out.println("Nhập sai mời nhập lại Số lượng sách: ");
                Soluong = sc.nextLine();
                check = Check_Num(Soluong);
            }
            System.out.println("Xin mời nhập Tiền sách: ");
            Tiensach = sc.nextLine();
            check = Check_Num(Tiensach);
            while (!check) {
                System.out.println("Nhập sai mời nhập lại Tiền sách: ");
                Tiensach = sc.nextLine();
                check = Check_Num(Tiensach);
            }
//        for(int i=0;)


            System.out.println("Xin mời nhập Tổng tiền: ");
            TongGia = sc.nextLine();
            check = Check_Num(TongGia);
            while (!check) {
                System.out.println("Nhập sai mời nhập lại Tổng tiền: ");
                TongGia = sc.nextLine();
                check = Check_Num(TongGia);
            }
            dto_cthdMuon = new dto_CTHDMuon(null, Masach, NCC, Integer.parseInt(Soluong),
                    Integer.parseInt(Tiensach), Integer.parseInt(TongGia));               //   3-A-A-A-A-A-12/07/2001
            bll_CTHDMuon.sua(dto_cthdMuon, id);


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
            bll_CTHDMuon.xoa(i);
        }
    }

    public void HienThiDanhSach() {
        dto_CTHDMuon hdn[] = DocFile_CTHDMuon();
        System.out.println("MaHD  -  MaSach - MaNCC - Số Lượng - Giá - Tổng giá");
        for (int i = 0; i < hdn.length; i++)
            System.out.println(" " + hdn[i].getIdHD() + "    " + hdn[i].getIdSach() + "      " + hdn[i].getIdNCC() + "          "
                    + hdn[i].getSoLuong() + "         " + hdn[i].getGiaSach() + "         " + hdn[i].getTongGia());
    }

    public void thoat() {
        System.out.println("xin chào và hen gặp lại ");
    }

    public void quayvemanhinhchinh() {
        Main m = new Main();
        m.TrangChinh();

    }


    public static void main(String[] args) {
        gui_CTHDMuon sv = new gui_CTHDMuon();
        sv.TrangHDMuon();
    }
}

