/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pertemuan6;
import java.sql.*;
/**
 *
 * @author User
 */
public class Koneksi {
    static Connection con;
    /**
     * @param args the command line arguments
     */
    public static Connection connection(){
        try{
            // ubah npm jadi npm kalian
            String url = "jdbc:mysql://localhost:3306/sehidup_sesaldo_npm";
            String username = "root";
            String password = "";
            
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Koneksi Berhasil!");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return con;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        connection();
    }
    
}
