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
      public void seans_duzenle(String seans_saati,String seans_saati2 ) {
        try {            
            Connection con = getDataBaseConnection();
            PreparedStatement pst = null;           
            pst = (PreparedStatement) con.prepareStatement("UPDATE seans SET SEANS_SAATI = ? WHERE SEANS_SAATI = ? ");
            pst.setString(1,seans_saati);
            pst.setString(2,seans_saati2);
                   
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Bağlanılamadı");
        }
    }
      public void seans_sil(String seans_saati ) {
        try {            
            Connection con = getDataBaseConnection();
            PreparedStatement pst = null;           
            pst = (PreparedStatement) con.prepareStatement("DELETE FROM seans WHERE SEANS_SAATI = ? ");
            pst.setString(1,seans_saati);
                   
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Bağlanılamadı");
        }
    }
   
     public void oyun_ekle(String salon_ad,String seans_saati,String oyun_ad) {
        try {            
            Connection con = getDataBaseConnection();
            PreparedStatement pst = null;           
            pst = (PreparedStatement) con.prepareStatement("INSERT INTO oyun(SALON_AD,SEANS_SAATI,OYUN_AD) VALUES(?,?,?)");
            pst.setString(1,salon_ad);
            pst.setString(2, seans_saati);   
            pst.setString(3, oyun_ad); 
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Bağlanılamadı");
        }
    }
      public void oyun_duzenle(String salon_ad,String seans_saati,String oyun_ad,String oyun_ad_sec) {
        try {            
            Connection con = getDataBaseConnection();
            PreparedStatement pst = null;           
            pst = (PreparedStatement) con.prepareStatement  ("UPDATE oyun SET OYUN_AD = ?  WHERE SALON_AD = ? AND SEANS_SAATI = ? ");
           
            pst.setString(2,salon_ad);
            pst.setString(3, seans_saati);   
            pst.setString(1, oyun_ad); 
            
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Bağlanılamadı");
        }
    }
      public void oyun_sil(String oyun_ad) {
        try {            
            Connection con = getDataBaseConnection();
            PreparedStatement pst = null;           
            pst = (PreparedStatement) con.prepareStatement  ("DELETE FROM oyun WHERE OYUN_AD = ? ");
           
             
            pst.setString(1, oyun_ad); 
            
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Bağlanılamadı");
        }
    }
       public void musteri_ekle(String m_ad_soyad ,String m_cep,String m_mail,String m_okul,String m_cinsiyet,int ucret,String m_koltuk,String salon_ad,String seans_saati,String oyun_ad,String tarih) {
        try {            
            Connection con = getDataBaseConnection();
            PreparedStatement pst = null;           
            pst = (PreparedStatement) con.prepareStatement("INSERT INTO musteriler(M_AD_SOYAD,M_CEP,M_MAIL,M_OKUL,M_CINSIYET,UCRET,M_KOLTUK,SALON_AD,SEANS_SAATI,OYUN_AD,TARIH) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            pst.setString(1, m_ad_soyad);
            pst.setString(2, m_cep);    
            pst.setString(3, m_mail);
            pst.setString(4, m_okul);
            pst.setString(5, m_cinsiyet);
            pst.setInt(6,ucret); 
            pst.setString(7, m_koltuk);
            pst.setString(8, salon_ad);
            pst.setString(9, seans_saati);
            pst.setString(10, oyun_ad);
            pst.setString(11, tarih);
            
            
            
            
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Bağlanılamadı");
        }
    }
        public void musteri_duzenle(String m_ad_soyad ,String m_cep,String m_mail,String m_okul,String m_cinsiyet,int ucret,String m_koltuk,String salon_ad,String seans_saati,String oyun_ad,String tarih,String koltuk_sec) {
        try {            
            Connection con = getDataBaseConnection();
            PreparedStatement pst = null;           
            pst = (PreparedStatement) con.prepareStatement("UPDATE musteriler SET M_AD_SOYAD,=?,M_CEP,=?,M_MAIL=?,M_OKUL=?,M_CINSIYET=?,UCRET=?,M_KOLTUK=?,SALON_AD=?,SEANS_SAATI=?,OYUN_AD=?,TARIH=? WHERE M_KOLTUK=?");
            
            pst.setString(1, m_ad_soyad);
            pst.setString(2, m_cep);    
            pst.setString(3, m_mail);
            pst.setString(4, m_okul);
            pst.setString(5, m_cinsiyet);
            pst.setInt(6,ucret); 
            pst.setString(7, m_koltuk);
            pst.setString(8, salon_ad);
            pst.setString(9, seans_saati);
            pst.setString(10, oyun_ad);
            pst.setString(11, tarih);
            pst.setString(12, koltuk_sec);
            
            
            
            
            pst.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Bağlanılamadı");
        }
        }
         public void admin_ekle(String ad_soyad, String telefon, int maas, String is_baslangic_tarih, int izin_sayisi, String adres) {

        try {
            Connection con = getDataBaseConnection();
            PreparedStatement pst = null;
            pst = (PreparedStatement) con.prepareStatement("INSERT INTO admin(A_AD,A_TELEFON,A_MAAS,A_BASLANGIC,A_IZIN,A_ADRES) VALUES(?,?,?,?,?,?)");
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


    void musteri_duzenle(String m_ad_soyad, String m_cep, String m_mail, String m_okul, String m_cinsiyet, int ucret, String m_koltuk, String salon_ad, String seans_saati, String oyun_ad, String tarih) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    void musteri_duzenle(String m_ad_soyad, String m_cep, String m_mail, String m_okul, String m_cinsiyet, int ucret, String m_koltuk, String salon_ad, String seans_saati, String oyun_ad, String tarih) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


        
}

