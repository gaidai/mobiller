/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapp1;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author user
 */
public class SQLins {
    
    static Connection con = null;
    static Statement stm = null;
    
    public static void insertsql (String a,String b,String c,String d) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
                
        System.out.println("Connecting to database...");
        con = DriverManager.getConnection(JavaFXApp1.host,JavaFXApp1.login,JavaFXApp1.password);
        System.out.println("Creating statement...");
        stm = con.createStatement();
        System.out.println("Created inser statement...");
        String sql;
        sql = "INSERT INTO mobiller VALUES('" + a +"','" +b +"','"+ c +"','"+ d +"');";
        
        int rs = stm.executeUpdate(sql);
        
        stm.close();
        con.close();
        System.out.println("updated"+ rs);
    //finally block used to close resources
      try{
         if(stm!=null)
            stm.close();
      }catch(SQLException se2){
      }// nothing we can do// nothing we can do
        if (con!=null) {
            try {
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(SQLins.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    } 
}
