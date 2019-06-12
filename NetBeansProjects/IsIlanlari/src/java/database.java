/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Sefa
 */
public class database {
    String url = "jdbc:derby://localhost:1527/giris";
    String name = "giris";
    String password = "giris";
    Connection con = null;
    PreparedStatement ps = null;
    
    con = DriverManager.getConnection(url, name, password);
    
}
