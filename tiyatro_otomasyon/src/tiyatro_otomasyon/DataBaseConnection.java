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
    
    public void biletci_duzenle(String ad_soyad ,String telefon,int maas,String is_baslangic_tarih,int izin_sayisi,String adres,String ad_sec) {
        try {            
            Connection con = getDataBaseConnection();
            PreparedStatement pst = null;           
            pst = (PreparedStatement) con.prepareStatement("UPDATE biletci SET B_AD=?,B_TELEFON=?,B_MAAS=?,B_BASLANGIC=?,B_IZIN=?,B_ADRES=? WHERE B_AD=?" ) ;
            pst.setString(1, ad_soyad);
            pst.setString(2, telefon);   
            pst.setInt(3, maas);
            pst.setString(4,is_baslangic_tarih);
            pst.setInt(5, izin_sayisi);
            pst.setString(6, adres);   
            pst.setString(7, ad_sec);
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Bağlanılamadı");
        }
    }
    
      public void biletci_sil(String biletci_ad) {
        try {            
            Connection con = getDataBaseConnection();
            PreparedStatement pst = null;           
            pst = (PreparedStatement) con.prepareStatement  ("DELETE FROM biletci WHERE B_AD = ? ");
           
             
            pst.setString(1, biletci_ad); 
            
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Bağlanılamadı");
        }
    }
        public void salon_ekle(String salonAd ,int kapasite) {
        try {            
            Connection con = getDataBaseConnection();
            PreparedStatement pst = null;           
            pst = (PreparedStatement) con.prepareStatement("INSERT INTO salon(AD,KAPASITE) VALUES(?,?)");
            pst.setString(1, salonAd);
            pst.setInt(2, kapasite);            
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Bağlanılamadı");
        }
    }
        public void salon_duzenle(String salon_ad,int salon_kapasite,String salon_sec ) {
        try {            
            Connection con = getDataBaseConnection();
            PreparedStatement pst = null;           
            pst = (PreparedStatement) con.prepareStatement("UPDATE salon SET AD = ?,KAPASITE=? WHERE AD = ? ");
            pst.setString(1,salon_ad);
            pst.setInt(2,salon_kapasite);
            pst.setString(3, salon_sec);
                   
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Bağlanılamadı");
        }
    }
    
     public void salon_sil(String salon_ad) {
        try {            
            Connection con = getDataBaseConnection();
            PreparedStatement pst = null;           
            pst = (PreparedStatement) con.prepareStatement("DELETE FROM salon WHERE AD = ? ");
            pst.setString(1,salon_ad);
                   
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Bağlanılamadı");
        }
    }

      public void seans_ekle(String saat ) {
        try {            
            Connection con = getDataBaseConnection();
            PreparedStatement pst = null;           
            pst = (PreparedStatement) con.prepareStatement("INSERT INTO seans(SEANS_SAATI) VALUES(?)");
            pst.setString(1,saat);
                   
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Bağlanılamadı");
        }
    }
}
