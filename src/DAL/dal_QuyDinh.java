package DAL;

import DTO.dto_QuyDinh;

import java.io.*;
import java.util.StringTokenizer;

import static BLL.bll_KT.Lay_Cd_ds;

public class dal_QuyDinh {
    public static dto_QuyDinh arr_QD[] = null;
    public static BufferedReader br = null;

    public dal_QuyDinh() {
    }

    public static dto_QuyDinh[] DocFile_QD() {
        String chuoi;
        try {
            Reader rd = new FileReader("src/Data/QuyDinh.txt");
            int cd_DSQD = Lay_Cd_ds(rd);
//            System.out.println("Chiều dai " + cd_DSQD);                                 // Truyền vào đường dẫn đễ lấy số dòng
            arr_QD = new dto_QuyDinh[cd_DSQD];                                   // Khởi tạo mảng dssv

            rd = new FileReader("src/Data/QuyDinh.txt");           // Khởi tạo lại đường dẫn để add vào mảng
            br = new BufferedReader(rd);
            br.readLine();
            int vt = 0;
            while ((chuoi = br.readLine()) != null) { // chuoi= 1-QuangNgocTrieu-Nam-DCT11810-VN-0845814481-12/07/2000
                if (chuoi.length() > 0) {
                    Luu_QD(chuoi, vt);                                              // Lưu từng dòng vào mảng
                    vt++;
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("Đường dẫn đọc file sai ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr_QD;
    }


    public static boolean GhiFile_QD(dto_QuyDinh QD) throws IOException {
        BufferedWriter bw = null;
        QD.setIdQuyDinh(tangId());
        try {
            FileWriter fw = new FileWriter("src/Data/QuyDinh.txt", true);
            bw = new BufferedWriter(fw);
            bw.newLine();                   // NEWLINE sẽ enter xuống dòng khi mình nhập chuỗi
            String s = QD.getIdQuyDinh() + "-" +
                    QD.getTenQuyDinh() + "-" +
                    QD.getTienPhat();
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

    public static boolean Ghi_Sua_QD(dto_QuyDinh[] QD) throws IOException {
        BufferedWriter bw = null;
        int cd_DSQD = QD.length;
        try {
            FileWriter fw = new FileWriter("src/Data/QuyDinh.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "IdQuyDinh        -    TênQuyDinh       -   TiềnPhạt   ";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/QuyDinh.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_DSQD; i++) {
                bw.newLine();
                String s = QD[i].getIdQuyDinh() + "-" +
                        QD[i].getTenQuyDinh() + "-" +
                        QD[i].getTienPhat();
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

    public static boolean Ghi_Xoa_QD(dto_QuyDinh[] QD) throws IOException {
        BufferedWriter bw = null;
        int cd_DSQD = QD.length;
        try {
            FileWriter fw = new FileWriter("src/Data/QuyDinh.txt");
            bw = new BufferedWriter(fw);
            String dongTieuDe = "IdQuyDinh        -    TênQD       -   TiềnPhạt   ";
            bw.write(dongTieuDe);
            bw.close();
            fw = new FileWriter("src/Data/QuyDinh.txt", true);
            bw = new BufferedWriter(fw);
            for (int i = 0; i < cd_DSQD; i++) {
                bw.newLine();
                String s = QD[i].getIdQuyDinh() + "-" +
                        QD[i].getTenQuyDinh() + "-" +
                        QD[i].getTienPhat();
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
//    private static int Lay_Cd_DSQD(Reader reader) throws IOException {
//        String chuoi;
//        br = new BufferedReader(reader);
//        br.readLine();
//        int cd_DSQD = 0;
//        while ((chuoi = br.readLine()) != null) {
//            cd_DSQD++;
//        }
//        return cd_DSQD;
//    }


    private static void Luu_QD(String chuoi, int vt) {
        StringTokenizer st = new StringTokenizer(chuoi, "-");
        while (st.hasMoreTokens()) {
            arr_QD[vt] = new dto_QuyDinh();  // arr_SV[0] = new dto_SV()
            arr_QD[vt].setIdQuyDinh(st.nextToken()); // arr_SV[0].setIdSV
            arr_QD[vt].setTenQuyDinh(st.nextToken());
            arr_QD[vt].setTienPhat(Integer.parseInt(st.nextToken()));
        }
    }

    private static String tangId() {
        dto_QuyDinh QD[] = DocFile_QD();
        int cd = QD.length;
        int id = Integer.parseInt(QD[cd - 1].getIdQuyDinh());
        id = id + 1;
        return String.valueOf(id);
    }


}
