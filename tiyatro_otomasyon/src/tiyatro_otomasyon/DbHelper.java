/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tiyatro_otomasyon;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author abdullahyar
 */
public class DbHelper {
    private String url = "jdbc:mysql://localhost:3306/tiyatro_otomasyon";
     private String user = "root";
     private String password = "";
     
     public Connection getConnnection()throws SQLException{
         
      return (Connection) DriverManager.getConnection(url,user,password);   
     }
     
   
public void showErrorMessage(SQLException exception){
    
    System.out.println("Error:"+exception.getMessage());
    System.out.println("Error Code:"+exception.getErrorCode());
}
    
}
    

