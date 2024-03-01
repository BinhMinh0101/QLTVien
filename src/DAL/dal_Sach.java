package DAL;

import DTO.dto_Sach;

import java.io.*;
import java.util.StringTokenizer;

import static BLL.bll_KT.Lay_Cd_ds;

public class dal_Sach {
    public static dto_Sach arr_Sach[] = null;
    public static BufferedReader br = null;

    public dal_Sach() {
    }

    public static dto_Sach[] DocFile_Sach() {
        String chuoi;
        try {
            Reader rd = new FileReader("src/Data/Sach.txt");
            int cd_Sach = Lay_Cd_ds(rd);                                  // Truyền vào đường dẫn đễ lấy số dòng
            arr_Sach = new dto_Sach[cd_Sach];                                   // Khởi tạo mảng dssv

            rd = new FileReader("src/Data/Sach.txt");           // Khởi tạo lại đường dẫn để add vào mảng
            br = new BufferedReader(rd);
            br.readLine();
            int vt = 0;
            while ((chuoi = br.readLine()) != null) {
                if (chuoi.length() > 0) {
                    Luu_Sach(chuoi, vt);                                              // Lưu từng dòng vào mảng
                    vt++;
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Đường dẫn đọc file sai ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr_Sach;
    }

    public static boolean GhiFile_Sach(dto_Sach sach) throws IOException {
        BufferedWriter bw = null;
        sach.setIdSach(tangId());
        try {
            FileWriter fw = new FileWriter("src/Data/Sach.txt", true);
            bw = new BufferedWriter(fw);
            bw.newLine();                   // NEWLINE sẽ enter xuống dòng khi mình nhập chuỗi
            String s = sach.getIdSach() + "-" +
                    sach.getTenSach() + "-" +
                    sach.getIdNCC() + "-" +
                    sach.getSoLuongSach() + "-" +
                    sach.getGiaSach() + "-"+
                    sach.getIdLoai();
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

    public static boolean Ghi_Sua_Sach(dto_Sach[] sach) throws IOException {
        BufferedWriter bw = null;
        int cd_Sach = sach.length;
        try {
            FileWriter fw = new FileWriter("src/Data/Sach.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "IdSach     -    TênSach     -   IdNCC   -   SoLuongTrang   -   GiaSach";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/Sach.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_Sach; i++) {
                bw.newLine();
                String s = sach[i].getIdSach() + "-" +
                        sach[i].getTenSach() + "-" +
                        sach[i].getIdNCC() + "-" +
                        sach[i].getSoLuongSach() + "-" +
                        sach[i].getGiaSach() + "-"+
                        sach[i].getIdLoai();
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

    public static boolean Ghi_Xoa_Sach(dto_Sach[] sach) throws IOException {
        BufferedWriter bw = null;
        int cd_Sach = sach.length;
        try {
            FileWriter fw = new FileWriter("src/Data/Sach.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "IdSach        -    TênSach       -   IdNCC   -   SoLuongTrang -   GiaSach";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/Sach.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_Sach; i++) {
                bw.newLine();
                String s = sach[i].getIdSach() + "-" +
                        sach[i].getTenSach() + "-" +
                        sach[i].getIdNCC() + "-" +
                        sach[i].getSoLuongSach() + "-" +
                        sach[i].getGiaSach() + "-"+
                        sach[i].getIdLoai();
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

    private static int Lay_Cd_Sach(Reader reader) throws IOException {
        String chuoi;
        br = new BufferedReader(reader);
        br.readLine();
        int cd_Sach = 0;
        while ((chuoi = br.readLine()) != null) {
            cd_Sach++;
        }
        return cd_Sach;
    }

    private static void Luu_Sach(String chuoi, int vt) {
        StringTokenizer st = new StringTokenizer(chuoi, "-");
        while (st.hasMoreTokens()) {
            arr_Sach[vt] = new dto_Sach();  // arr_SV[0] = new dto_SV()
            arr_Sach[vt].setIdSach(st.nextToken()); // arr_SV[0].setIdSV
            arr_Sach[vt].setTenSach(st.nextToken());
            arr_Sach[vt].setIdNCC(st.nextToken());
            arr_Sach[vt].setSoLuongSach(Integer.parseInt(st.nextToken()));
            arr_Sach[vt].setGiaSach(Integer.parseInt(st.nextToken()));
            arr_Sach[vt].setIdLoai(st.nextToken());
        }
    }

    private static String tangId() {
        dto_Sach sach[] = DocFile_Sach();
        int cd = sach.length;
        int id = Integer.parseInt(sach[cd - 1].getIdSach());
        id = id + 1;
        return String.valueOf(id);
    }

//    public static void main(String[] args) throws IOException {
//        dal_Sach sach = new dal_Sach();
////        dto_Sach sv1=new dto_Sach("1","1","1","1","1","1",null);
//        sach.DocFile_Sach();
//    }
}
