
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
    
    
    
    private Connection getDataBaseConnection(){
    
    try{
        
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/tiyatro_otomasyon";
        Connection con=null;
        PreparedStatement pst =null;
        return DriverManager.getConnection(url, "root", "");
        
    }   catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            System.out.println("Sürücü proje (Connector) eklenmemiş");
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Bağlantı sağlanamdı");
        }
    return null; 
    
    }
    
    public String kullanici_kontrol(String kullanici_ad){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/tiyatro_otomasyon";
        Connection con=null;
        PreparedStatement pst =null;
        con=DriverManager.getConnection(url,"root","");
        pst = (PreparedStatement) con.prepareStatement("SELECT *from KULLANICI k where k.KULLANICI_AD = ?");
        pst.setString(1,kullanici_ad);
        ResultSet rs =pst.executeQuery();
        
     while (rs.next()){
         
         return rs.getString("SIFRE");
     }   
        
        
    }   catch (ClassNotFoundException ex) {    
            ex.printStackTrace();
            System.out.println("Sürücü proje (Connector) eklenmemiş");     
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Bağlantı sağlanamdı");
        }    
        
        return null;
        
    }
    
    
    
    
    
    
}
