package DAL;

import DTO.dto_NhanVien;
import DTO.dto_SinhVien;

import java.io.*;
import java.util.Date;
import java.util.StringTokenizer;

import static BLL.bll_KT.*;

public class dal_NhanVien {
    public static dto_NhanVien arr_NV[] = null;
    public static BufferedReader br = null;

    public dal_NhanVien() {
    }

    public static dto_NhanVien[] DocFile_NV() {
        String chuoi;
        try {
            Reader rd = new FileReader("src/Data/NhanVien.txt");
            int cd_DSNV = Lay_Cd_ds(rd);                                  // Truyền vào đường dẫn đễ lấy số dòng

            arr_NV = new dto_NhanVien[cd_DSNV];                                   // Khởi tạo mảng dssv

            rd = new FileReader("src/Data/NhanVien.txt");           // Khởi tạo lại đường dẫn để add vào mảng
            br = new BufferedReader(rd);
            br.readLine();

            int vt = 0;
            while ((chuoi = br.readLine()) != null) {   // chuoi= 1-QuangNgocTrieu-Nam-DCT11810-VN-0845814481-12/07/2000
                if (chuoi.length() > 0) {
                    Luu_NV(chuoi, vt);                                              // Lưu từng dòng vào mảng
                    vt++;
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Đường dẫn đọc file sai ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr_NV;
    }


    public static boolean GhiFile_NV(dto_NhanVien nv) throws IOException {
        BufferedWriter bw = null;
        nv.setIdNV(tangId());
        try {
            FileWriter fw = new FileWriter("src/Data/NhanVien.txt", true);
            bw = new BufferedWriter(fw);
            bw.newLine();                   // NEWLINE sẽ enter xuống dòng khi mình nhập chuỗi
            String s = nv.getIdNV() + "-" +
                    nv.getHoTen() + "-" +
                    nv.getPhai() + "-" +
                    nv.getDiaChi() + "-" +
                    nv.getSdt() + "-" +
                    Chuyen_Date_String(nv.getNgaySinh())+"-"+
                    Chuyen_Date_String(nv.getNgaySinh());
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

    public boolean Ghi_Sua_NV(dto_NhanVien[] nv) throws IOException {
        BufferedWriter bw = null;
        int cd_DSSV = nv.length;
        try {
            FileWriter fw = new FileWriter("src/Data/NhanVien.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "MSSV        -    HọTên       -   Phai   -   ĐịaChỉ      -   SĐT     -   NgàySinh - Ngàyvàolàm";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/NhanVien.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_DSSV; i++) {
                bw.newLine();
                String s = nv[i].getIdNV() + "-" +
                        nv[i].getHoTen() + "-" +
                        nv[i].getPhai() + "-" +
                        nv[i].getDiaChi() + "-" +
                        nv[i].getSdt() + "-" +
                        Chuyen_Date_String(nv[i].getNgaySinh())+"-"+
                        Chuyen_Date_String(nv[i].getNgayVaoLam());
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

    public boolean Ghi_Xoa_NV(dto_NhanVien[] nv) throws IOException {
        BufferedWriter bw = null;
        int cd_DSSV = nv.length;
        try {
            FileWriter fw = new FileWriter("src/Data/NhanVien.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "MSSV        -    HọTên       -   Phai   -   ĐịaChỉ      -   SĐT     -   NgàySinh - Ngàyvàolàm";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/NhanVien.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_DSSV; i++) {
                bw.newLine();
                String s = nv[i].getIdNV() + "-" +
                        nv[i].getHoTen() + "-" +
                        nv[i].getPhai() + "-" +
                        nv[i].getDiaChi() + "-" +
                        nv[i].getSdt() + "-" +
                        Chuyen_Date_String(nv[i].getNgaySinh())+"-"+
                        Chuyen_Date_String(nv[i].getNgayVaoLam());
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


    private static void Luu_NV(String chuoi, int vt) {
        StringTokenizer st = new StringTokenizer(chuoi, "-");
        while (st.hasMoreTokens()) {
            arr_NV[vt] = new dto_NhanVien();  // arr_SV[0] = new dto_SV()
            arr_NV[vt].setIdNV(st.nextToken()); // arr_SV[0].setIdSV
            arr_NV[vt].setHoTen(st.nextToken());
            arr_NV[vt].setPhai(st.nextToken());
            arr_NV[vt].setDiaChi(st.nextToken());
            arr_NV[vt].setSdt(st.nextToken());
            String ngay = st.nextToken();       //   12/07/2001
            Date ngsinh = Chuyen_String_Date(ngay);
            arr_NV[vt].setNgaySinh(ngsinh);
            String ngayVL = st.nextToken();       //   12/07/2001
            Date ngVLDATE = Chuyen_String_Date(ngayVL);
            arr_NV[vt].setNgayVaoLam(ngVLDATE);
        }
    }

    private static String tangId() {
        dto_NhanVien sv[] = DocFile_NV();
        int cd = sv.length;
        int id = Integer.parseInt(sv[cd - 1].getIdNV());
        id = id + 1;
        return String.valueOf(id);
    }

//    public static void main(String[] args) throws IOException {
//        dal_SinhVien sv = new dal_SinhVien();
////        dto_SinhVien sv1=new dto_SinhVien("1","1","1","1","1","1",null);
//        sv.DocFile_SV();
//    }
}
