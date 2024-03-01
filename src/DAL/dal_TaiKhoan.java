package DAL;

import DTO.dto_TaiKhoan;

import java.io.*;
import java.util.StringTokenizer;

import static BLL.bll_KT.Lay_Cd_ds;

public class dal_TaiKhoan {
    public static dto_TaiKhoan arr_TK[] = null;
    public static BufferedReader br = null;

    public dal_TaiKhoan() {
    }

    public static dto_TaiKhoan[] DocFile_TK() {
        String chuoi;
        try {
            Reader rd = new FileReader("src/Data/TaiKhoan.txt");
            int cd_DSTK = Lay_Cd_ds(rd);                                  // Truyền vào đường dẫn đễ lấy số dòng
            arr_TK = new dto_TaiKhoan[cd_DSTK];                                   // Khởi tạo mảng dssv

            rd = new FileReader("src/Data/TaiKhoan.txt");           // Khởi tạo lại đường dẫn để add vào mảng
            br = new BufferedReader(rd);
            br.readLine();
            int vt = 0;
            while ((chuoi = br.readLine()) != null) { // chuoi= 1-QuangNgocTrieu-Nam-DCT11810-VN-0845814481-12/07/2000
               if (chuoi.length()>0){Luu_TK(chuoi, vt);                                              // Lưu từng dòng vào mảng
                vt++;}
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Đường dẫn đọc file sai ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr_TK;
    }


    public static boolean GhiFile_TK(dto_TaiKhoan TK) throws IOException {
        BufferedWriter bw = null;
        TK.setId(tangId());
        try {
            FileWriter fw = new FileWriter("src/Data/TaiKhoan.txt", true);
            bw = new BufferedWriter(fw);
            bw.newLine();                   // NEWLINE sẽ enter xuống dòng khi mình nhập chuỗi
            String s = TK.getId() + "-" +
                    TK.getUsername() + "-" +
                    TK.getPassword();
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

    public boolean Ghi_Sua_TK(dto_TaiKhoan[] TK) throws IOException {
        BufferedWriter bw = null;
        int cd_DSTK = TK.length;
        try {
            FileWriter fw = new FileWriter("src/Data/TaiKhoan.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "ID        -    Username       -   Password";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/TaiKhoan.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_DSTK; i++) {
                bw.newLine();
                String s = TK[i].getId() + "-" +
                        TK[i].getUsername() + "-" +
                        TK[i].getPassword();
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

    public boolean Ghi_Xoa_TK(dto_TaiKhoan[] TK) throws IOException {
        BufferedWriter bw = null;
        int cd_DSTK = TK.length;
        try {
            FileWriter fw = new FileWriter("src/Data/TaiKhoan.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "ID        -    Username       -   Password";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/TaiKhoan.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_DSTK; i++) {
                bw.newLine();
                String s = TK[i].getId() + "-" +
                        TK[i].getUsername() + "-" +
                        TK[i].getPassword();
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
//    private static int Lay_Cd_DSTK(Reader reader) throws IOException {
//        String chuoi;
//        br = new BufferedReader(reader);
//        br.readLine();
//        int cd_DSTK = 0;
//        while ((chuoi = br.readLine()) != null) {
//            cd_DSTK++;
//        }
//        return cd_DSTK;
//    }


    private static void Luu_TK(String chuoi, int TK) {
        StringTokenizer st = new StringTokenizer(chuoi, "-");
        while (st.hasMoreTokens()) {
            arr_TK[TK] = new dto_TaiKhoan();  // arr_SV[0] = new dto_SV()
            arr_TK[TK].setId(st.nextToken()); // arr_SV[0].setIdSV
            arr_TK[TK].setUsername(st.nextToken());
            arr_TK[TK].setPassword(st.nextToken());
        }
    }

    private static String tangId() {
        dto_TaiKhoan TK[] = DocFile_TK();
        int cd = TK.length;
        int id = Integer.parseInt(TK[cd - 1].getId());
        id = id + 1;
        return String.valueOf(id);
    }


}
