package DAL;

import DTO.dto_CTHDTra;

import java.io.*;
import java.util.StringTokenizer;

import static BLL.bll_KT.Lay_Cd_ds;

public class dal_CTHDTra {
    public static dto_CTHDTra arr_CTHDT[] = null;
    public static BufferedReader br = null;


    public dal_CTHDTra() {
    }

    public static dto_CTHDTra[] DocFile_CTHDTra() {
        String chuoi;
        try {
            Reader rd = new FileReader("src/Data/CTHDTra.txt");
            int cd_CTHDN = Lay_Cd_ds(rd);                                  // Truyền vào đường dẫn đễ lấy số dòng
            arr_CTHDT = new dto_CTHDTra[cd_CTHDN];                                   // Khởi tạo mảng dssv
            rd = new FileReader("src/Data/CTHDTra.txt");           // Khởi tạo lại đường dẫn để add vào mảng
            br = new BufferedReader(rd);
            br.readLine();

            int vt = 0;
            while ((chuoi = br.readLine()) != null) {   // chuoi= 1-QuangNgocTrieu-Nam-DCT11810-VN-0845814481-12/07/2000
                if (chuoi.length() > 0) {
                    Luu_CTHDN(chuoi, vt);                                              // Lưu từng dòng vào mảng
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
        return arr_CTHDT;
    }


    public static boolean GhiFile_CTHDTra(dto_CTHDTra cthdt) throws IOException {
        BufferedWriter bw = null;
        cthdt.setIdHD(tangId());
        try {
            FileWriter fw = new FileWriter("src/Data/CTHDTra.txt", true);
            bw = new BufferedWriter(fw);
            bw.newLine();                   // NEWLINE sẽ enter xuống dòng khi mình nhập chuỗi
            String s =  cthdt.getIdHD() + "-" +
                        cthdt.getIdSach() + "-" +
                        cthdt.getIdNCC() + "-" +
                        cthdt.getIdQuyDinh() + "-" +
                        cthdt.getSoLuong() + "-" +
                        cthdt.getGiaSach() + "-" +
                        cthdt.getTongGia() + "-" +
                        cthdt.getIdSach();
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

    public boolean Ghi_Sua_CTHDTra(dto_CTHDTra[] cthdt) throws IOException {
        BufferedWriter bw = null;
        int cd_DSCTHDN = cthdt.length;
        try {
            FileWriter fw = new FileWriter("src/Data/CTHDTra.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "MaHD  -  MaSach - Số lượng -   Giá   - Tổng Tiền";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/CTHDTra.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_DSCTHDN; i++) {
                bw.newLine();
                String s =  cthdt[i].getIdHD() + "-" +
                            cthdt[i].getIdSach() + "-" +
                            cthdt[i].getIdNCC() + "-" +
                            cthdt[i].getIdQuyDinh() + "-" +
                            cthdt[i].getSoLuong() + "-" +
                            cthdt[i].getGiaSach() + "-" +
                            cthdt[i].getTongGia() + "-" +
                            cthdt[i].getIdSach();
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

    public boolean Ghi_Xoa_CTHDTra(dto_CTHDTra[] cthdt) throws IOException {
        BufferedWriter bw = null;
        int cd_DSCTHDT = cthdt.length;
        try {
            FileWriter fw = new FileWriter("src/Data/CTHDTra.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "MaHD  -  MaSach - MaNCC - Quy Định - Số Lượng - Giá - Tổng giá - Tiền Phạt";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/CTHDTra.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_DSCTHDT; i++) {
                bw.newLine();
                String s =  cthdt[i].getIdHD() + "-" +
                            cthdt[i].getIdSach() + "-" +
                            cthdt[i].getIdNCC() + "-" +
                            cthdt[i].getIdQuyDinh() + "-" +
                            cthdt[i].getSoLuong() + "-" +
                            cthdt[i].getGiaSach() + "-" +
                            cthdt[i].getTongGia() + "-" +
                            cthdt[i].getIdSach();
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


    private static void Luu_CTHDN(String chuoi, int vt) {
        StringTokenizer st = new StringTokenizer(chuoi, "-");
        while (st.hasMoreTokens()) {
            arr_CTHDT[vt] = new dto_CTHDTra();  // arr_SV[0] = new dto_SV()
            arr_CTHDT[vt].setIdHD(st.nextToken()); // arr_SV[0].setIdSV
            arr_CTHDT[vt].setIdSach(st.nextToken());
            arr_CTHDT[vt].setIdNCC(st.nextToken());
            arr_CTHDT[vt].setIdQuyDinh(st.nextToken());
            arr_CTHDT[vt].setSoLuong(Integer.parseInt(st.nextToken()));
            arr_CTHDT[vt].setGiaSach(Integer.parseInt(st.nextToken()));
            arr_CTHDT[vt].setTongGia(Integer.parseInt(st.nextToken()));
            arr_CTHDT[vt].setTienPhat(Integer.parseInt(st.nextToken()));

        }
    }

    private static String tangId() {
        dto_CTHDTra hdn[] = DocFile_CTHDTra();
        int cd = hdn.length;
        int id = Integer.parseInt(hdn[cd - 1].getIdHD());
        id = id + 1;
        return String.valueOf(id);
    }

//    public static void main(String[] args) throws IOException {
//        dal_HDNhap sv = new dal_HDNhap();
//
//        sv.DocFile_HDN();
//    }
}

