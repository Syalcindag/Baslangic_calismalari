/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package databaseconnect;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;



public class DatabaseConnect {

    
    public static void main(String[] args) {
       try{
           String host = "jdbc:derby://localhost:1527/admin";
        String uName = "Sefa";
        String uPass = "123";
        Connection con = DriverManager.getConnection(host);
       }
       catch(SQLException e)
       {
           System.out.println("hata : " + e.getMessage());
       }
        
    }
    
}
