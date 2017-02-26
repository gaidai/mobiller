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
public class SQLsel {
     
    static Connection conn = null;
    static Statement stmt = null;
    
    public static void selectsql () throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        
        
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(JavaFXApp1.host,JavaFXApp1.login,JavaFXApp1.password);
        System.out.println("Creating statement...");
        stmt = conn.createStatement();
        System.out.println("Created statement...");
        String sql;
        sql = "SELECT*from mobiller;";
        
        ResultSet rs = stmt.executeQuery(sql);
      //System.out.print(rs);
          //STEP 5: Extract data from result set
      while(rs.next()){
         //Retrieve by column name
         String m  = rs.getString("mobil");
         String f = rs.getString("fname");
         String n = rs.getString("name");
         String d = rs.getString("date");

         //Display values
         
         System.out.println(m + " " + f + " " + n + " " + d);
      }
      //STEP 6: Clean-up environment
      rs.close();
      stmt.close();
      conn.close();
    //finally block used to close resources
      try{
         if(stmt!=null)
            stmt.close();
      }catch(SQLException se2){
      }// nothing we can do
      try{
         if(conn!=null)
            conn.close();
      }catch(SQLException se){
         se.printStackTrace();
      }//end finally try
   //end try
   // System.out.println("Goodbye!");//end main

    } 
    
}
