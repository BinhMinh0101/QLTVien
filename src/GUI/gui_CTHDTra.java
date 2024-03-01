package GUI;

import BLL.bll_CTHDTra;
import DTO.dto_CTHDMuon;
import DTO.dto_CTHDTra;

import java.util.Scanner;

import static BLL.bll_KT.Check_Num;
import static BLL.bll_KT.SoGioiHan;
import static DAL.dal_CTHDMuon.DocFile_CTHDMuon;
import static DAL.dal_CTHDTra.DocFile_CTHDTra;

public class gui_CTHDTra {

    Scanner sc = new Scanner(System.in);
    bll_CTHDTra bll_CTHDTra = new bll_CTHDTra();
    dto_CTHDTra dto_cthdTra = new dto_CTHDTra();

    public gui_CTHDTra() {
    }

    public void TrangHDTra() {
        System.out.println("-------------     Chào Mừng Bạn Đến Với Trang Chi tiết hóa đơn trả       -------------");
        System.out.println("1. Hiển thị danh sách Chi tiết hóa đơn trả ");
        System.out.println("2. Thêm một Chi tiết hóa đơn trả ");
        System.out.println("3. Sửa một Chi tiết hóa đơn trả");
        System.out.println("4. Xóa một Chi tiết hóa đơn trả ");
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
                System.out.println("---------Hiển thị danh dách một Chi tiết hóa đơn trả -------------");
                HienThiDanhSach();
                TrangHDTra();
                break;
            case 2:
                System.out.println("---------Thêm một Chi tiết hóa đơn trả -------------");
                them();
                TrangHDTra();
                break;
            case 3:
                System.out.println("---------Sửa một Chi tiết hóa đơn trả -------------");
                sua();
                TrangHDTra();
                break;
            case 4:
                System.out.println("---------Xóa một Chi tiết hóa đơn trả -------------");
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
        String Masach, NCC,MaQD, Soluong, Tiensach, TongGia, Tienphat;
        boolean check;
        System.out.println("Xin mời nhập Mã Sách: ");
        Masach = sc.nextLine();

        System.out.println("Xin mời nhập NCC: ");
        NCC = sc.nextLine();

        System.out.println("Xin mời nhập Mã quy định: ");
        MaQD = sc.nextLine();

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

        System.out.println("Xin mời nhập Tiền phạt: ");
        Tienphat = sc.nextLine();
        check = Check_Num(Tienphat);
        while (!check) {
            System.out.println("Nhập sai mời nhập lại Tiền phạt: ");
            Tienphat = sc.nextLine();
            check = Check_Num(Tienphat);
        }

        dto_cthdTra = new dto_CTHDTra(null, Masach,NCC,MaQD, Integer.parseInt(Soluong),
                Integer.parseInt(Tiensach), Integer.parseInt(TongGia),Integer.parseInt(TongGia));           //   3-A-A-A-A-A-12/07/2001
        bll_CTHDTra.them(dto_cthdTra);
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
            String Masach, NCC,MaQD, Soluong, Tiensach, TongGia, Tienphat;
            boolean check;
            System.out.println("Xin mời nhập Mã Sách: ");
            Masach = sc.nextLine();

            System.out.println("Xin mời nhập NCC: ");
            NCC = sc.nextLine();

            System.out.println("Xin mời nhập Mã quy định: ");
            MaQD = sc.nextLine();

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

            System.out.println("Xin mời nhập Tiền phạt: ");
            Tienphat = sc.nextLine();
            check = Check_Num(Tienphat);
            while (!check) {
                System.out.println("Nhập sai mời nhập lại Tiền phạt: ");
                Tienphat = sc.nextLine();
                check = Check_Num(Tienphat);
            }

            dto_cthdTra = new dto_CTHDTra(null, Masach,NCC,MaQD, Integer.parseInt(Soluong),
                    Integer.parseInt(Tiensach), Integer.parseInt(TongGia),Integer.parseInt(TongGia));                //   3-A-A-A-A-A-12/07/2001
            bll_CTHDTra.sua(dto_cthdTra, id);


        }

    }

    public void xoa() {
        System.out.println("Mời bạn nhập id chi tiết muốn xóa ");
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
            bll_CTHDTra.xoa(i);
        }
    }

    public void HienThiDanhSach() {
        dto_CTHDTra hdn[] = DocFile_CTHDTra();
        System.out.println("MaHD  -  MaSach - MaNCC - Quy Định - Số Lượng - Giá - Tổng giá - Tiền Phạt");
        for (int i = 0; i < hdn.length; i++)
            System.out.println(" "+ hdn[i].getIdHD() + "    " +
                                    hdn[i].getIdSach() + "      " +
                                    hdn[i].getIdNCC() + "          " +
                                    hdn[i].getIdQuyDinh() + "          "+
                                    hdn[i].getSoLuong() +"         " +
                                    hdn[i].getGiaSach()+ "         " +
                                    hdn[i].getTongGia() + "          "+
                                    hdn[i].getTienPhat());
    }

    public void thoat() {
        System.out.println("xin chào và hen gặp lại ");
    }

    public void quayvemanhinhchinh() {
        Main m=new Main();
        m.TrangChinh();

    }

//    public static void main(String[] args) {
//        gui_CTHDTra ct=new gui_CTHDTra();
//        ct.TrangHDTra();
//    }

}

