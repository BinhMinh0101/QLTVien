package DAL;

import DTO.dto_LoaiSach;

import java.io.*;
import java.util.StringTokenizer;

import static BLL.bll_KT.Lay_Cd_ds;

public class dal_LoaiSach {
    public static dto_LoaiSach arr_LoaiSach[] = null;
    public static BufferedReader br = null;

    public dal_LoaiSach() {
    }

    public static dto_LoaiSach[] DocFile_LoaiSach() {
        String chuoi;
        try {
            Reader rd = new FileReader("src/Data/LoaiSach.txt");
            int cd_LoaiSach = Lay_Cd_ds(rd);                                  // Truyền vào đường dẫn đễ lấy số dòng
            arr_LoaiSach = new dto_LoaiSach[cd_LoaiSach];                                   // Khởi tạo mảng dssv

            rd = new FileReader("src/Data/LoaiSach.txt");           // Khởi tạo lại đường dẫn để add vào mảng
            br = new BufferedReader(rd);
            br.readLine();
            int vt = 0;
            while ((chuoi = br.readLine()) != null) {
                if (chuoi.length() > 0) {
                    Luu_LoaiSach(chuoi, vt);                                              // Lưu từng dòng vào mảng
                    vt++;
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Đường dẫn đọc file sai ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr_LoaiSach;
    }

    public static boolean GhiFile_LoaiSach(dto_LoaiSach loaisach) throws IOException {
        BufferedWriter bw = null;
        loaisach.setIdLoai(tangId());
        try {
            FileWriter fw = new FileWriter("src/Data/LoaiSach.txt", true);
            bw = new BufferedWriter(fw);
            bw.newLine();                   // NEWLINE sẽ enter xuống dòng khi mình nhập chuỗi
            String s = loaisach.getIdLoai() + "-" +
                    loaisach.getTenLoai();
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

    public static boolean Ghi_Sua_LoaiSach(dto_LoaiSach[] loaisach) throws IOException {
        BufferedWriter bw = null;
        int cd_Sach = loaisach.length;
        try {
            FileWriter fw = new FileWriter("src/Data/LoaiSach.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "IdLoai     -     TenLoai";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/LoaiSach.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_Sach; i++) {
                bw.newLine();
                String s = loaisach[i].getIdLoai() + "-" +
                        loaisach[i].getTenLoai();
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

    public static boolean Ghi_Xoa_LoaiSach(dto_LoaiSach[] loaisach) throws IOException {
        BufferedWriter bw = null;
        int cd_Sach = loaisach.length;
        try {
            FileWriter fw = new FileWriter("src/Data/LoaiSach.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "IdLoai     -     TenLoai";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/LoaiSach.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_Sach; i++) {
                bw.newLine();
                String s = loaisach[i].getIdLoai() + "-" +
                        loaisach[i].getTenLoai();
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

    private static int Lay_Cd_LoaiSach(Reader reader) throws IOException {
        String chuoi;
        br = new BufferedReader(reader);
        br.readLine();
        int cd_LoaiSach = 0;
        while ((chuoi = br.readLine()) != null) {
            cd_LoaiSach++;
        }
        return cd_LoaiSach;
    }

    private static void Luu_LoaiSach(String chuoi, int vt) {
        StringTokenizer st = new StringTokenizer(chuoi, "-");
        while (st.hasMoreTokens()) {
            arr_LoaiSach[vt] = new dto_LoaiSach();  // arr_SV[0] = new dto_SV()
            arr_LoaiSach[vt].setIdLoai(st.nextToken()); // arr_SV[0].setIdSV
            arr_LoaiSach[vt].setTenLoai(st.nextToken());
        }
    }

    private static String tangId() {
        dto_LoaiSach loaisach[] = DocFile_LoaiSach();
        int cd = loaisach.length;
        int id = Integer.parseInt(loaisach[cd - 1].getIdLoai());
        id = id + 1;
        return String.valueOf(id);
    }

//    public static void main(String[] args) throws IOException {
//        dal_LoaiSach loaisach = new dal_LoaiSach();
////      dto_LoaiSach sv1=new dto_Sach("1","1","1","1","1","1",null);
//        loaisach.DocFile_LoaiSach();
//    }
}
