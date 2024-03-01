package DAL;

import DTO.dto_CTHDMuon;

import java.io.*;
import java.util.StringTokenizer;

import static BLL.bll_KT.Lay_Cd_ds;

public class dal_CTHDMuon {
    public static dto_CTHDMuon arr_CTHDMuon[] = null;
    public static BufferedReader br = null;

    public dal_CTHDMuon() {
    }

    public static dto_CTHDMuon[] DocFile_CTHDMuon() {
        String chuoi;
        try {
            Reader rd = new FileReader("src/Data/CTHDMuon.txt");
            int cd_CTHDTra = Lay_Cd_ds(rd);                                  // Truyền vào đường dẫn đễ lấy số dòng
            arr_CTHDMuon = new dto_CTHDMuon[cd_CTHDTra];                                   // Khởi tạo mảng dssv
            rd = new FileReader("src/Data/CTHDMuon.txt");           // Khởi tạo lại đường dẫn để add vào mảng
            br = new BufferedReader(rd);
            br.readLine();

            int vt = 0;
            while ((chuoi = br.readLine()) != null) {   // chuoi= 1-QuangNgocTrieu-Nam-DCT11810-VN-0845814481-12/07/2000
                if (chuoi.length() > 0) {
                    Luu_CTHDTra(chuoi, vt);                                              // Lưu từng dòng vào mảng
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
        return arr_CTHDMuon;
    }


    public static boolean GhiFile_CTHDMuon(dto_CTHDMuon cthdm) throws IOException {
        BufferedWriter bw = null;
        cthdm.setIdHD(tangId());
        try {
            FileWriter fw = new FileWriter("src/Data/CTHDMuon.txt", true);
            bw = new BufferedWriter(fw);
            bw.newLine();                   // NEWLINE sẽ enter xuống dòng khi mình nhập chuỗi
            String s = cthdm.getIdHD() + "-" +
                    cthdm.getIdSach() + "-" +
                    cthdm.getIdNCC() + "-" +
                    cthdm.getSoLuong() + "-" +
                    cthdm.getGiaSach() + "-" +
                    cthdm.getTongGia();
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

    public boolean Ghi_Sua_CTHDMuon(dto_CTHDMuon[] cthdm) throws IOException {
        BufferedWriter bw = null;
        int cd_DSCTHDM = cthdm.length;
        try {
            FileWriter fw = new FileWriter("src/Data/CTHDMuon.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "MaHD  -  MaSach - MaNCC - Số Lượng - Giá - Tổng giá";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/CTHDMuon.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_DSCTHDM; i++) {
                bw.newLine();
                String s = cthdm[i].getIdHD() + "-" +
                        cthdm[i].getIdSach() + "-" +
                        cthdm[i].getIdNCC() + "-" +
                        cthdm[i].getSoLuong() + "-" +
                        cthdm[i].getGiaSach() + "-" +
                        cthdm[i].getTongGia();
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

    public boolean Ghi_Xoa_CTHDMuon(dto_CTHDMuon[] cthdm) throws IOException {
        BufferedWriter bw = null;
        int cd_DSCTHDM = cthdm.length;
        try {
            FileWriter fw = new FileWriter("src/Data/CTHDMuon.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "MaHD  -  MaSach - MaNCC - Số Lượng - Giá - Tổng giá";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/CTHDMuon.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_DSCTHDM; i++) {
                bw.newLine();
                String s = cthdm[i].getIdHD() + "-" +
                        cthdm[i].getIdSach() + "-" +
                        cthdm[i].getIdNCC() + "-" +
                        cthdm[i].getSoLuong() + "-" +
                        cthdm[i].getGiaSach() + "-" +
                        cthdm[i].getTongGia();
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


    private static void Luu_CTHDTra(String chuoi, int vt) {
        StringTokenizer st = new StringTokenizer(chuoi, "-");
        while (st.hasMoreTokens()) {
            arr_CTHDMuon[vt] = new dto_CTHDMuon();  // arr_SV[0] = new dto_SV()
            arr_CTHDMuon[vt].setIdHD(st.nextToken()); // arr_SV[0].setIdSV
            arr_CTHDMuon[vt].setIdSach(st.nextToken());
            arr_CTHDMuon[vt].setIdNCC(st.nextToken());
            arr_CTHDMuon[vt].setSoLuong(Integer.parseInt(st.nextToken()));
            arr_CTHDMuon[vt].setGiaSach(Integer.parseInt(st.nextToken()));
            arr_CTHDMuon[vt].setTongGia(Integer.parseInt(st.nextToken()));


        }
    }

    private static String tangId() {
        dto_CTHDMuon hdm[] = DocFile_CTHDMuon();
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

