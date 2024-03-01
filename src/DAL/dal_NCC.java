package DAL;

import DTO.dto_NCC;

import java.io.*;
import java.util.StringTokenizer;

import static BLL.bll_KT.*;

public class dal_NCC {
    public static dto_NCC arr_NCC[] = null;
    public static BufferedReader br = null;

    public dal_NCC() {
    }

    public static dto_NCC[] DocFile_NCC() {
        String chuoi;
        try {
            Reader rd = new FileReader("src/Data/NCC.txt");
            int cd_LoaiSach = Lay_Cd_ds(rd);                                  // Truyền vào đường dẫn đễ lấy số dòng
            arr_NCC = new dto_NCC[cd_LoaiSach];                                   // Khởi tạo mảng dssv

            rd = new FileReader("src/Data/NCC.txt");           // Khởi tạo lại đường dẫn để add vào mảng
            br = new BufferedReader(rd);
            br.readLine();
            int vt = 0;
            while ((chuoi = br.readLine()) != null) {
                if (chuoi.length() > 0) {
                    Luu_NCC(chuoi, vt);                                              // Lưu từng dòng vào mảng
                    vt++;
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Đường dẫn đọc file sai ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr_NCC;
    }

    public static boolean GhiFile_NCC(dto_NCC ncc) throws IOException {
        BufferedWriter bw = null;
        ncc.setIdNCC(tangId());
        try {
            FileWriter fw = new FileWriter("src/Data/NCC.txt", true);
            bw = new BufferedWriter(fw);
            bw.newLine();                   // NEWLINE sẽ enter xuống dòng khi mình nhập chuỗi
            String s = ncc.getIdNCC() + "-" +
                        ncc.getTenNCC();
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

    public static boolean Ghi_Sua_NCC(dto_NCC[] ncc) throws IOException {
        BufferedWriter bw = null;
        int cd_ncc = ncc.length;
        try {
            FileWriter fw = new FileWriter("src/Data/NCC.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "MaNCC - TenNCC";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/NCC.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_ncc; i++) {
                bw.newLine();
                String s =  ncc[i].getIdNCC() + "-" +
                            ncc[i].getTenNCC();
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

    public static boolean Ghi_Xoa_NCC(dto_NCC[] ncc) throws IOException {
        BufferedWriter bw = null;
        int cd_Sach = ncc.length;
        try {
            FileWriter fw = new FileWriter("src/Data/NCC.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "IdLoai     -     TenLoai";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/NCC.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_Sach; i++) {
                bw.newLine();
                String s = ncc[i].getIdNCC() + "-" +
                        ncc[i].getTenNCC();
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

    private static void Luu_NCC(String chuoi, int vt) {
        StringTokenizer st = new StringTokenizer(chuoi, "-");
        while (st.hasMoreTokens()) {
            arr_NCC[vt] = new dto_NCC();  // arr_SV[0] = new dto_SV()
            arr_NCC[vt].setIdNCC(st.nextToken()); // arr_SV[0].setIdSV
            arr_NCC[vt].setTenNCC(st.nextToken());
        }
    }

    private static String tangId() {
        dto_NCC dto_ncc[] = DocFile_NCC();
        int cd = dto_ncc.length;
        int id = Integer.parseInt(dto_ncc[cd - 1].getIdNCC());
        id = id + 1;
        return String.valueOf(id);
    }

//    public static void main(String[] args) throws IOException {
//        dal_LoaiSach loaisach = new dal_LoaiSach();
////      dto_LoaiSach sv1=new dto_Sach("1","1","1","1","1","1",null);
//        loaisach.DocFile_LoaiSach();
//    }
}
