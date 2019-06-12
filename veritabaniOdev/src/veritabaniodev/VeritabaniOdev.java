package veritabaniodev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sefa
 */
public class VeritabaniOdev {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int secim;
        boolean bayrak = true;
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String user = "postgres";
        String password = "1234";
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VeritabaniOdev.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger.getLogger(VeritabaniOdev.class.getName()).log(Level.SEVERE, null, ex);
        }
        while (bayrak) {
            System.out.println("ANA MENU\n"
                    + "1-Listele\n"
                    + "2-Ekle\n"
                    + "3-Sil\n"
                    + "4-Guncelle\n"
                    + "0-Cikis\n"
                    + "Secim Yapiniz?\n");
            secim = scanner.nextInt();
            switch (secim) {
                case 1:
                    try {
                        int hNo;
                        String hAdi, HdgmYeri;
                        String sqlSorgu = "select * from teacher;";
                        Statement sttm = con.createStatement();
                        ResultSet rs = sttm.executeQuery(sqlSorgu);
                        System.out.println("---------------------------------------------");
                        System.out.println("Hocano      HocaAdi      HocaDogumYeri");
                        while (rs.next()) {
                            System.out.println(rs.getInt(1) + "          " + rs.getString(2) + "         " + rs.getString(3) + "\n");
                        }
                        System.out.println("---------------------------------------------");
                        rs.close();
                        sttm.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(VeritabaniOdev.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 2:
                    try {
                        boolean hata = false;
                        int hocaNo;
                        String hocaAdi;
                        String hocaDogumYeri;
                        System.out.println("Hoca numarası giriniz : ");
                        hocaNo = scanner.nextInt();
                        System.out.println("Hoca adı giriniz : ");
                        hocaAdi = scanner.next();
                        System.out.println("Hoca dogum yeri giriniz : ");
                        hocaDogumYeri = scanner.next();
                        String sqlSorgu2 = "select * from teacher;";
                        Statement sttm2 = con.createStatement();
                        ResultSet rs = sttm2.executeQuery(sqlSorgu2);
                        while (rs.next()) {
                            if (rs.getInt(1) == hocaNo) {
                                hata = true;
                            }
                        }
                        if (hata) {
                            System.out.println("--------------------------------");
                            System.out.println(hocaNo + "  numaralı hocanolu hoca var!! kayıt yapılmadı");
                            System.out.println("--------------------------------");
                        } else {
                            System.out.println("\n");
                            String sqlSorgu = "insert into teacher values(" + hocaNo + ",' " + hocaAdi + "', ' " + hocaDogumYeri + "');";
                            Statement sttm = con.createStatement();
                            sttm.execute(sqlSorgu);
                            System.out.println("--------------------------------");
                            System.out.println(hocaAdi + "  basarili bir sekilde eklendi. \n\n");
                            System.out.println("--------------------------------");
                            sttm.close();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(VeritabaniOdev.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 3:
                    try {
                        System.out.println("Hoca No giriniz : ");
                        int dHocaNo = scanner.nextInt();
                        String dHocaAdi = null;
                        boolean hata = true;
                        System.out.println("\n");
                        String sqlSorgu2 = "select * from teacher;";
                        Statement sttm2 = con.createStatement();
                        ResultSet rs = sttm2.executeQuery(sqlSorgu2);
                        while (rs.next()) {
                            if (rs.getInt(1) == dHocaNo) {
                                dHocaAdi = rs.getString(2);
                                hata = false;
                            }
                        }
                        if (hata) {
                            System.out.println("--------------------------------");
                            System.out.println(dHocaNo + "  numaralı hoca bulunamadı!!!");
                            System.out.println("--------------------------------");
                        } else {
                            String sqlSorgu = "delete from teacher where tid = " + dHocaNo + ";";
                            Statement sttm = con.createStatement();
                            sttm.execute(sqlSorgu);
                            System.out.println("--------------------------------");
                            System.out.println(dHocaAdi + "  adlı hoca silindi\n\n");
                            System.out.println("--------------------------------");
                            sttm.close();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(VeritabaniOdev.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 4:
                    try {
                        boolean hata = true;
                        int hocaNo;
                        String hocaAdi;
                        String hocaDogumYeri;
                        System.out.println("Hoca numarası giriniz : ");
                        hocaNo = scanner.nextInt();
                        System.out.println("Hoca adı giriniz : ");
                        hocaAdi = scanner.next();
                        System.out.println("Hoca dogum yeri giriniz : ");
                        hocaDogumYeri = scanner.next();
                        System.out.println("\n");
                        String sqlSorgu2 = "select * from teacher;";
                        Statement sttm2 = con.createStatement();
                        ResultSet rs = sttm2.executeQuery(sqlSorgu2);
                        while (rs.next()) {
                            if (rs.getInt(1) == hocaNo) {

                                hata = false;
                            }
                        }
                        if (hata) {
                            System.out.println("--------------------------------");
                            System.out.println(hocaNo + "  nolu hoca bulunamadi !!!  Guncelleme yapilamadi");
                            System.out.println("--------------------------------");
                        } else {
                            String sqlSorgu = "update  teacher set tid = " + hocaNo + ",hAdi = ' " + hocaAdi + "',hDgmYeri = '" + hocaDogumYeri + "' where tid = " + hocaNo + ";";
                            Statement sttm = con.createStatement();
                            sttm.execute(sqlSorgu);
                            System.out.println("--------------------------------");
                            System.out.println(hocaAdi + "  basarili bir sekilde eklendi. \n\n");
                            System.out.println("--------------------------------");
                            sttm.close();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(VeritabaniOdev.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 0:
                    bayrak = false;
                    break;
            }
        }
    }
}
