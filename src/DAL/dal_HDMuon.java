package DAL;

import DTO.dto_HDMuon;

import java.io.*;
import java.util.Date;
import java.util.StringTokenizer;

import static BLL.bll_KT.*;

public class dal_HDMuon {
    public static dto_HDMuon arr_HDMuon[] = null;
    public static BufferedReader br = null;

    public dal_HDMuon() {
    }

    public static dto_HDMuon[] DocFile_HDMuon() {
        String chuoi;
        try {
            Reader rd = new FileReader("src/Data/HoaDonMuon.txt");
            int cd_DSSV = Lay_Cd_ds(rd);                                  // Truyền vào đường dẫn đễ lấy số dòng

            arr_HDMuon = new dto_HDMuon[cd_DSSV];                                   // Khởi tạo mảng dssv

            rd = new FileReader("src/Data/HoaDonMuon.txt");           // Khởi tạo lại đường dẫn để add vào mảng
            br = new BufferedReader(rd);
            br.readLine();

            int vt = 0;
            while ((chuoi = br.readLine()) != null) {   // chuoi= 1-QuangNgocTrieu-Nam-DCT11810-VN-0845814481-12/07/2000
                if (chuoi.length() > 0) {
                    Luu_HDMuon(chuoi, vt);                                              // Lưu từng dòng vào mảng
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
        return arr_HDMuon;
    }


    public static boolean GhiFile_HDMuon(dto_HDMuon hdm) throws IOException {
        BufferedWriter bw = null;
        hdm.setIdHD(tangId());
        try {
            FileWriter fw = new FileWriter("src/Data/HoaDonMuon.txt", true);
            bw = new BufferedWriter(fw);
            bw.newLine();                   // NEWLINE sẽ enter xuống dòng khi mình nhập chuỗi
            String s = hdm.getIdHD() + "-" +
                    hdm.getIdNV() + "-" +
                    hdm.getIdSV() + "-" +
                    Chuyen_Date_String(hdm.getNgayLap())+"-"+
                    hdm.getTongSach() + "-" +
                    hdm.getTongtienSach() + "-" +
                    hdm.getTienDatCoc();
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

    public boolean Ghi_Sua_HDMuon(dto_HDMuon[] hdm) throws IOException {
        BufferedWriter bw = null;
        int cd_DSSV = hdm.length;
        try {
            FileWriter fw = new FileWriter("src/Data/HoaDonMuon.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "MaHD  - MaNV -  MaSV  - Ngày Lập HĐ - Tổng Sách   -   Tổng tiền sách - Tiền đặt cọc";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/HoaDonMuon.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_DSSV; i++) {
                bw.newLine();
                String s = hdm[i].getIdHD() + "-" +
                        hdm[i].getIdNV() + "-" +
                        hdm[i].getIdSV() + "-" +
                        Chuyen_Date_String(hdm[i].getNgayLap())+"-"+
                        hdm[i].getTongSach() + "-" +
                        hdm[i].getTongtienSach() + "-" +
                        hdm[i].getTienDatCoc();
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

    public boolean Ghi_Xoa_HDMuon(dto_HDMuon[] hdm) throws IOException {
        BufferedWriter bw = null;
        int cd_DSSV = hdm.length;
        try {
            FileWriter fw = new FileWriter("src/Data/HoaDonMuon.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "MaHD  - MaNV -  MaSV  - Ngày Lập HĐ - Tổng Sách   -   Tổng tiền sách - Tiền đặt cọc";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/HoaDonMuon.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_DSSV; i++) {
                bw.newLine();
                String s = hdm[i].getIdHD() + "-" +
                        hdm[i].getIdNV() + "-" +
                        hdm[i].getIdSV() + "-" +
                        Chuyen_Date_String(hdm[i].getNgayLap())+"-"+
                        hdm[i].getTongSach() + "-" +
                        hdm[i].getTongtienSach() + "-" +
                        hdm[i].getTienDatCoc();
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


    private static void Luu_HDMuon(String chuoi, int vt) {
        StringTokenizer st = new StringTokenizer(chuoi, "-");
        while (st.hasMoreTokens()) {
            arr_HDMuon[vt] = new dto_HDMuon();  // arr_SV[0] = new dto_SV()
            arr_HDMuon[vt].setIdHD(st.nextToken()); // arr_SV[0].setIdSV
            arr_HDMuon[vt].setIdNV(st.nextToken());
            arr_HDMuon[vt].setIdSV(st.nextToken());
            String ngay = st.nextToken();       //   12/07/2001
            Date ngNhap = Chuyen_String_Date(ngay);
            arr_HDMuon[vt].setNgayLap(ngNhap);
            arr_HDMuon[vt].setTongSach(Integer.parseInt(st.nextToken()));
            arr_HDMuon[vt].setTongtienSach(Integer.parseInt(st.nextToken()));
            arr_HDMuon[vt].setTienDatCoc(Integer.parseInt(st.nextToken()));


        }
    }

    private static String tangId() {
        dto_HDMuon hdm[] = DocFile_HDMuon();
        int cd = hdm.length;
        int id = Integer.parseInt(hdm[cd - 1].getIdHD());
        id = id + 1;
        return String.valueOf(id);
    }

//    public static void main(String[] args) throws IOException {
//        dal_HDNhap sv = new dal_HDNhap();
//
//        sv.DocFile_HDN();
//    }
}


