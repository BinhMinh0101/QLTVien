package DAL;

import DTO.dto_HDTra;

import java.io.*;
import java.util.Date;
import java.util.StringTokenizer;

import static BLL.bll_KT.*;

public class dal_HDTra {
    public static dto_HDTra arr_HDTra[] = null;
    public static BufferedReader br = null;
//    public static dto_SinhVien arr_SV[]= DocFile_SV();
    public dal_HDTra() {
    }

    public static dto_HDTra[] DocFile_HDTra() {
        String chuoi;
        try {
            Reader rd = new FileReader("src/Data/HoaDonTra.txt");
            int cd_DSSV = Lay_Cd_ds(rd);                                  // Truyền vào đường dẫn đễ lấy số dòng
            arr_HDTra = new dto_HDTra[cd_DSSV];                                   // Khởi tạo mảng dssv
            rd = new FileReader("src/Data/HoaDonTra.txt");           // Khởi tạo lại đường dẫn để add vào mảng
            br = new BufferedReader(rd);
            br.readLine();
            int vt = 0;
            while ((chuoi = br.readLine()) != null) { // chuoi= 1-QuangNgocTrieu-Nam-DCT11810-VN-0845814481-12/07/2000
                if (chuoi.length()>0){
                    Luu_sv(chuoi, vt);                                              // Lưu từng dòng vào mảng
                    vt++;
                }

            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Đường dẫn đọc file sai ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr_HDTra;
    }


    public static boolean GhiFile_HDTra(dto_HDTra HDT) throws IOException {        // HDT là Hóa đơn trả
        BufferedWriter bw = null;
        HDT.setIdHD(tangId());                  // Tăng ID HD
        try {
            FileWriter fw = new FileWriter("src/Data/HoaDonTra.txt", true);
            bw = new BufferedWriter(fw);
            bw.newLine();                   // NEWLINE sẽ enter xuống dòng khi mình nhập chuỗi
            String s =
                    HDT.getIdHD()+"-"+
                    HDT.getIdSV() + "-" +
                    HDT.getIdNV() + "-" +
                    Chuyen_Date_String(HDT.getNgayTra()) + "-" +
//                            "12/07/2001"+
                    HDT.getTongSach() + "-" +
                    HDT.getTienPhat() + "-" +
                    HDT.getTongtienSach();
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

    public static boolean Ghi_Sua_HDTra(dto_HDTra[] HDT) throws IOException {
        BufferedWriter bw = null;
        int cd_DSSV = HDT.length;
        try {
            FileWriter fw = new FileWriter("src/Data/HoaDonTra.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "MaHD  - MaNV -   MSSV   -   ngayTra -   tongSach   - tienPhat   -  tongtienSach";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/HoaDonDTra.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_DSSV; i++) {
                bw.newLine();
                String s =
                        HDT[i].getIdHD()+"-"+
                        HDT[i].getIdSV() + "-" +
                        HDT[i].getIdNV() + "-" +
                        Chuyen_Date_String(HDT[i].getNgayTra()) + "-" +
                        HDT[i].getTongSach() + "-" +
                        HDT[i].getTienPhat() + "-" +
                        HDT[i].getTongtienSach();
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

    public static boolean Ghi_Xoa_HDTra(dto_HDTra[] HDT) throws IOException {
        BufferedWriter bw = null;
        int cd_DSSV = HDT.length;
        try {
            FileWriter fw = new FileWriter("src/Data/HoaDonTra.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "MaHD  - MaNV -   MSSV   -   ngayTra -   tongSach   - tienPhat   -  tongtienSach";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/HoaDonTra.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_DSSV; i++) {
                bw.newLine();
                String s =
                        HDT[i].getIdHD()+"-"+
                        HDT[i].getIdSV() + "-" +
                        HDT[i].getIdNV() + "-" +
                        Chuyen_Date_String(HDT[i].getNgayTra()) + "-" +
                        HDT[i].getTongSach() + "-" +
                        HDT[i].getTienPhat() + "-" +
                        HDT[i].getTongtienSach();
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




    private static void Luu_sv(String chuoi, int vt) {
        StringTokenizer st = new StringTokenizer(chuoi, "-");
        while (st.hasMoreTokens()) {
            arr_HDTra[vt] = new dto_HDTra();  // arr_SV[0] = new dto_SV()
            arr_HDTra[vt].setIdHD(st.nextToken());
            arr_HDTra[vt].setIdSV(st.nextToken());
            arr_HDTra[vt].setIdNV(st.nextToken()) ;
            String ngay = st.nextToken();       //   12/07/2001
            Date ngTra = Chuyen_String_Date(ngay);
            arr_HDTra[vt].setNgayTra(ngTra);
            arr_HDTra[vt].setTongSach(Integer.parseInt(st.nextToken()));
            arr_HDTra[vt].setTienPhat(Integer.parseInt(st.nextToken())) ;
            arr_HDTra[vt].setTongtienSach(Integer.parseInt(st.nextToken()));
        }
    }

    private static String tangId() {
        dto_HDTra HDT[] = DocFile_HDTra();
        int cd = HDT.length;
        int id = Integer.parseInt(HDT[cd - 1].getIdHD());
        id = id + 1;
        return String.valueOf(id);
    }

    public static void main(String[] args) throws IOException {
        dal_HDTra sv = new dal_HDTra();
//        DocFile_HDTra();
//        dto_HDTra[] SC = DocFile_HDTra();;
//        System.out.println("hai "+SC.length);
//        Date a=new Date();
//       dto_HDTra dto_hdTra=new dto_HDTra(null,"1","1",null,1,1,1);
//       sv.GhiFile_HDTra(dto_hdTra);
//       System.out.println("ba ");

    }
}

