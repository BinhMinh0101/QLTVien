package DAL;

import DTO.dto_SinhVien;

import java.io.*;
import java.util.Date;
import java.util.StringTokenizer;

import static BLL.bll_KT.*;

public class dal_SinhVien {
    public static dto_SinhVien arr_SV[] = null;
    public static BufferedReader br = null;

    public dal_SinhVien() {
    }

    public static dto_SinhVien[] DocFile_SV() {
        String chuoi;
        try {
            Reader rd = new FileReader("src/Data/SinhVien.txt");
            int cd_DSSV = Lay_Cd_ds(rd);                                  // Truyền vào đường dẫn đễ lấy số dòng
            arr_SV = new dto_SinhVien[cd_DSSV];                                   // Khởi tạo mảng dssv

            rd = new FileReader("src/Data/SinhVien.txt");           // Khởi tạo lại đường dẫn để add vào mảng
            br = new BufferedReader(rd);
            br.readLine();

            int vt = 0;
            while ((chuoi = br.readLine()) != null) {   // chuoi= 1-QuangNgocTrieu-Nam-DCT11810-VN-0845814481-12/07/2000
                if (chuoi.length() > 0) {
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
        return arr_SV;
    }


    public static boolean GhiFile_SV(dto_SinhVien sv) throws IOException {
        BufferedWriter bw = null;
        sv.setIdSV(tangId());
        try {
            FileWriter fw = new FileWriter("src/Data/SinhVien.txt", true);
            bw = new BufferedWriter(fw);
            bw.newLine();                   // NEWLINE sẽ enter xuống dòng khi mình nhập chuỗi
            String s = sv.getIdSV() + "-" +
                    sv.getHoTen() + "-" +
                    sv.getPhai() + "-" +
                    sv.getLop() + "-" +
                    sv.getDiaChi() + "-" +
                    sv.getSdt() + "-" +
                    Chuyen_Date_String(sv.getNgaySinh());
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

    public boolean Ghi_Sua_SV(dto_SinhVien[] sv) throws IOException {
        BufferedWriter bw = null;
        int cd_DSSV = sv.length;
        try {
            FileWriter fw = new FileWriter("src/Data/SinhVien.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "MSSV        -    HọTên       -   Phai   -   Lớp -   ĐịaChỉ      -   SĐT     -   NgàySinh";
            bw.write(dongTieuDe);
            bw.close();

            fw = new FileWriter("src/Data/SinhVien.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_DSSV; i++) {
                bw.newLine();
                String s = sv[i].getIdSV() + "-" +
                        sv[i].getHoTen() + "-" +
                        sv[i].getPhai() + "-" +
                        sv[i].getLop() + "-" +
                        sv[i].getDiaChi() + "-" +
                        sv[i].getSdt() + "-" +
                        Chuyen_Date_String(sv[i].getNgaySinh());
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

    public boolean Ghi_Xoa_SV(dto_SinhVien[] sv) throws IOException {
        BufferedWriter bw = null;
        int cd_DSSV = sv.length;
        try {
            FileWriter fw = new FileWriter("src/Data/SinhVien.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "MSSV        -    HọTên       -   Phai   -   Lớp -   ĐịaChỉ      -   SĐT     -   NgàySinh";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/SinhVien.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_DSSV; i++) {
                bw.newLine();
                String s = sv[i].getIdSV() + "-" +
                        sv[i].getHoTen() + "-" +
                        sv[i].getPhai() + "-" +
                        sv[i].getLop() + "-" +
                        sv[i].getDiaChi() + "-" +
                        sv[i].getSdt() + "-" +
                        Chuyen_Date_String(sv[i].getNgaySinh());
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
            arr_SV[vt] = new dto_SinhVien();  // arr_SV[0] = new dto_SV()
            arr_SV[vt].setIdSV(st.nextToken()); // arr_SV[0].setIdSV
            arr_SV[vt].setHoTen(st.nextToken());
            arr_SV[vt].setPhai(st.nextToken());
            arr_SV[vt].setLop(st.nextToken());
            arr_SV[vt].setDiaChi(st.nextToken());
            arr_SV[vt].setSdt(st.nextToken());
            String ngay = st.nextToken();       //   12/07/2001
            Date ngsinh = Chuyen_String_Date(ngay);
            arr_SV[vt].setNgaySinh(ngsinh);
        }
    }

    private static String tangId() {
        dto_SinhVien sv[] = DocFile_SV();
        int cd = sv.length;
        int id = Integer.parseInt(sv[cd - 1].getIdSV());
        id = id + 1;
        return String.valueOf(id);
    }

    public static void main(String[] args) throws IOException {
        dal_SinhVien sv = new dal_SinhVien();
//        dto_SinhVien sv1=new dto_SinhVien("1","1","1","1","1","1",null);
        sv.DocFile_SV();
    }
}
