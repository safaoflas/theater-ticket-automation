package tiyatro_otomasyon;

/**
 *
 * @author abdullahyar
 */
import com.mysql.jdbc.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseConnection {

    private Connection getDataBaseConnection() {

        try {

            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/tiyatro_otomasyon";
            Connection con = null;
            PreparedStatement pst = null;
            return DriverManager.getConnection(url, "root", "");

        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Sürücü proje (Connector) eklenmemiş");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Bağlantı sağlanamdı");
        }
        return null;

    }

    public String kullanici_kontrol(String kullanici_ad) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/tiyatro_otomasyon";
            Connection con = null;
            PreparedStatement pst = null;
            con = DriverManager.getConnection(url, "root", "");
            pst = (PreparedStatement) con.prepareStatement("SELECT * from KULLANICI k where k.KULLANICI_AD = ?");
            pst.setString(1, kullanici_ad);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                return rs.getString("SIFRE");
            }
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Sürücü proje (Connector) eklenmemiş");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Bağlantı sağlanamdı");
        }
        return null;

    }

    public void biletci_ekle(String ad_soyad, String telefon, int maas, String is_baslangic_tarih, int izin_sayisi, String adres) {

        try {
            Connection con = getDataBaseConnection();
            PreparedStatement pst = null;
            pst = (PreparedStatement) con.prepareStatement("INSERT INTO biletci(B_AD,B_TELEFON,B_MAAS,B_BASLANGIC,B_IZIN,B_ADRES) VALUES(?,?,?,?,?,?)");
            pst.setString(1, ad_soyad);
            pst.setString(2, telefon);
            pst.setInt(3, maas);
            pst.setString(4, is_baslangic_tarih);
            pst.setInt(5, izin_sayisi);
            pst.setString(6, adres);
            pst.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Bağlanılamadı");

        }
    }

}
