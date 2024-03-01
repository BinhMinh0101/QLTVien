package DAL;

import DTO.dto_CTHDNhap;

import java.io.*;
import java.util.StringTokenizer;

import static BLL.bll_KT.*;

public class dal_CTHDNhap {
    public static dto_CTHDNhap arr_CTHDNhap[] = null;
    public static BufferedReader br = null;

    public dal_CTHDNhap() {
    }

    public static dto_CTHDNhap[] DocFile_CTHDNhap() {
        String chuoi;
        try {
            Reader rd = new FileReader("src/Data/CTHDNhap.txt");
            int cd_CTHDN = Lay_Cd_ds(rd);                                  // Truyền vào đường dẫn đễ lấy số dòng
            arr_CTHDNhap = new dto_CTHDNhap[cd_CTHDN];                                   // Khởi tạo mảng dssv
            rd = new FileReader("src/Data/CTHDNhap.txt");           // Khởi tạo lại đường dẫn để add vào mảng
            br = new BufferedReader(rd);
            br.readLine();

            int vt = 0;
            while ((chuoi = br.readLine()) != null) {   // chuoi= 1-QuangNgocTrieu-Nam-DCT11810-VN-0845814481-12/07/2000
                if (chuoi.length() > 0) {
                    Luu_CTHDNhap(chuoi, vt);                                              // Lưu từng dòng vào mảng
                    vt++;
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Đường dẫn đọc file sai ");
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println(" hai ba "+arr_HDN.length);
        return arr_CTHDNhap;
    }


    public static boolean GhiFile_CTHDNhap(dto_CTHDNhap cthdn) throws IOException {
        BufferedWriter bw = null;
        cthdn.setIdHDNhap(tangId());
        try {
            FileWriter fw = new FileWriter("src/Data/CTHDNhap.txt", true);
            bw = new BufferedWriter(fw);
            bw.newLine();                   // NEWLINE sẽ enter xuống dòng khi mình nhập chuỗi
            String s = cthdn.getIdHDNhap() + "-" +
                    cthdn.getIdSach() + "-" +
                    cthdn.getSoLuong() + "-" +
                    cthdn.getGia() + "-" +
                    cthdn.getTongGia();
            bw.write(s);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
        return true;

    }

    public boolean Ghi_Sua_CTHDNhap(dto_CTHDNhap[] cthdn) throws IOException {
        BufferedWriter bw = null;
        int cd_DSCTHDN = cthdn.length;
        try {
            FileWriter fw = new FileWriter("src/Data/CTHDNhap.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "MaHD  -  MaSach - Số lượng -   Giá   - Tổng Tiền";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/CTHDNhap.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_DSCTHDN; i++) {
                bw.newLine();
                String s = cthdn[i].getIdHDNhap() + "-" +
                        cthdn[i].getIdSach() + "-" +
                        cthdn[i].getSoLuong() + "-" +
                        cthdn[i].getGia() + "-" +
                        cthdn[i].getTongGia();
                bw.write(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
        return true;
    }

    public boolean Ghi_Xoa_CTHDNhap(dto_CTHDNhap[] cthdn) throws IOException {
        BufferedWriter bw = null;
        int cd_DSCTHDN = cthdn.length;
        try {
            FileWriter fw = new FileWriter("src/Data/CTHDNhap.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "MaHD  - MaNV -   MaLoai   -   Tổng Sách -   Tổng giá   - Ngày nhập";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/CTHDNhap.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_DSCTHDN; i++) {
                bw.newLine();
                String s = cthdn[i].getIdHDNhap() + "-" +
                        cthdn[i].getIdSach() + "-" +
                        cthdn[i].getSoLuong() + "-" +
                        cthdn[i].getGia() + "-" +
                        cthdn[i].getTongGia();
                bw.write(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            if (bw != null) {
                bw.close();
            }
        }
        return true;
    }


    private static void Luu_CTHDNhap(String chuoi, int vt) {
        StringTokenizer st = new StringTokenizer(chuoi, "-");
        while (st.hasMoreTokens()) {
            arr_CTHDNhap[vt] = new dto_CTHDNhap();  // arr_SV[0] = new dto_SV()
            arr_CTHDNhap[vt].setIdHDNhap(st.nextToken()); // arr_SV[0].setIdSV
            arr_CTHDNhap[vt].setIdSach(st.nextToken());
            arr_CTHDNhap[vt].setGia(Integer.parseInt(st.nextToken()));
            arr_CTHDNhap[vt].setSoLuong(Integer.parseInt(st.nextToken()));
            arr_CTHDNhap[vt].setTongGia(Integer.parseInt(st.nextToken()));


        }
    }

    private static String tangId() {
        dto_CTHDNhap hdn[] = DocFile_CTHDNhap();
        int cd = hdn.length;
        int id = Integer.parseInt(hdn[cd - 1].getIdHDNhap());
        id = id + 1;
        return String.valueOf(id);
    }

//    public static void main(String[] args) throws IOException {
//        dal_HDNhap sv = new dal_HDNhap();
//
//        sv.DocFile_HDN();
//    }
}

