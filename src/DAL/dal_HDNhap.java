package DAL;

import DTO.dto_HDNhap;
import java.io.*;
import java.util.Date;
import java.util.StringTokenizer;

import static BLL.bll_KT.*;

public class dal_HDNhap {
    public static dto_HDNhap arr_HDNhap[] = null;
    public static BufferedReader br = null;

    public dal_HDNhap() {
    }

    public static dto_HDNhap[] DocFile_HDNhap() {
        String chuoi;
        try {
            Reader rd = new FileReader("src/Data/HoaDonNhap.txt");
            int cd_DSSV = Lay_Cd_ds(rd);                                  // Truyền vào đường dẫn đễ lấy số dòng

            arr_HDNhap = new dto_HDNhap[cd_DSSV];                                   // Khởi tạo mảng dssv

            rd = new FileReader("src/Data/HoaDonNhap.txt");           // Khởi tạo lại đường dẫn để add vào mảng
            br = new BufferedReader(rd);
            br.readLine();

            int vt = 0;
            while ((chuoi = br.readLine()) != null) {   // chuoi= 1-QuangNgocTrieu-Nam-DCT11810-VN-0845814481-12/07/2000
                if (chuoi.length() > 0) {
                    Luu_HDNhap(chuoi, vt);                                              // Lưu từng dòng vào mảng
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
        return arr_HDNhap;
    }


    public static boolean GhiFile_HDNhap(dto_HDNhap hdn) throws IOException {
        BufferedWriter bw = null;
        hdn.setIdHD(tangId());
        try {
            FileWriter fw = new FileWriter("src/Data/HoaDonNhap.txt", true);
            bw = new BufferedWriter(fw);
            bw.newLine();                   // NEWLINE sẽ enter xuống dòng khi mình nhập chuỗi
            String s = hdn.getIdHD() + "-" +
                    hdn.getIdNV() + "-" +
                    hdn.getIdLoai() + "-" +
                    hdn.getTongSach() + "-" +
                    hdn.getTongGia() + "-" +
                    Chuyen_Date_String(hdn.getNgayNhap());
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

    public boolean Ghi_Sua_HDNhap(dto_HDNhap[] hdn) throws IOException {
        BufferedWriter bw = null;
        int cd_DSSV = hdn.length;
        try {
            FileWriter fw = new FileWriter("src/Data/HoaDonNhap.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "MaHD  - MaNV -   MaLoai   -   Tổng Sách -   Tổng giá   - Ngày nhập";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/HoaDonNhap.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_DSSV; i++) {
                bw.newLine();
                String s = hdn[i].getIdHD() + "-" +
                        hdn[i].getIdNV() + "-" +
                        hdn[i].getIdLoai() + "-" +
                        hdn[i].getTongSach() + "-" +
                        hdn[i].getTongGia() + "-" +
                        Chuyen_Date_String(hdn[i].getNgayNhap());
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

    public boolean Ghi_Xoa_HDNhap(dto_HDNhap[] hdn) throws IOException {
        BufferedWriter bw = null;
        int cd_DSSV = hdn.length;
        try {
            FileWriter fw = new FileWriter("src/Data/HoaDonNhap.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "MaHD  - MaNV -   MaLoai   -   Tổng Sách -   Tổng giá   - Ngày nhập";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/HoaDonNhap.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_DSSV; i++) {
                bw.newLine();
                String s = hdn[i].getIdHD() + "-" +
                        hdn[i].getIdNV() + "-" +
                        hdn[i].getIdLoai() + "-" +
                        hdn[i].getTongSach() + "-" +
                        hdn[i].getTongGia() + "-" +
                        Chuyen_Date_String(hdn[i].getNgayNhap());
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


    private static void Luu_HDNhap(String chuoi, int vt) {
        StringTokenizer st = new StringTokenizer(chuoi, "-");
        while (st.hasMoreTokens()) {
            arr_HDNhap[vt] = new dto_HDNhap();  // arr_SV[0] = new dto_SV()
            arr_HDNhap[vt].setIdHD(st.nextToken()); // arr_SV[0].setIdSV
            arr_HDNhap[vt].setIdNV(st.nextToken());
            arr_HDNhap[vt].setIdLoai(st.nextToken());
            arr_HDNhap[vt].setTongSach(Integer.parseInt(st.nextToken()));
            arr_HDNhap[vt].setTongGia(Integer.parseInt(st.nextToken()));
            String ngay = st.nextToken();       //   12/07/2001
            Date ngNhap = Chuyen_String_Date(ngay);
            arr_HDNhap[vt].setNgayNhap(ngNhap);

        }
    }

    private static String tangId() {
        dto_HDNhap hdn[] = DocFile_HDNhap();
        int cd = hdn.length;
        int id = Integer.parseInt(hdn[cd - 1].getIdHD());
        id = id + 1;
        return String.valueOf(id);
    }

    public static void main(String[] args) throws IOException {
        dal_HDNhap sv = new dal_HDNhap();

                sv.DocFile_HDNhap();
    }
}

