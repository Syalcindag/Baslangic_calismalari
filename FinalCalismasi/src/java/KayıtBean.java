
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.sql.rowset.CachedRowSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sefa
 */
@ManagedBean(name = "bean", eager = true)
public class KayıtBean {
    private String firstname;
    private String lastname;
    private String city;
    private String street;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    public ResultSet getAddresses() throws SQLException
 {
 // check whether dataSource was injected by the server
 String url ="jdbc:derby://localhost:1527/final";
        String user ="final";
        String password ="final";
 // obtain a connection from the connection pool
 Connection connection =DriverManager.getConnection(url, user, password);

 // check whether connection was successful
 if ( connection == null )
 throw new SQLException( "Unable to connect to DataSource" );

 try
 {
     // sql cümlesi yazmak için PreparedStatement oluşturmalıyız.    
 // create a PreparedStatement to select the records
 PreparedStatement object1 = connection.prepareStatement("SELECT isim, soyisim, sehir, sokak FROM KAYIT" );
 CachedRowSet resultSet1 = new com.sun.rowset.CachedRowSetImpl();
  resultSet1.populate( object1.executeQuery() );
  return resultSet1;
 } // end try
 finally
 {
 connection.close(); // return this connection to pool
 } // end finally
 } // end method getAddresses

    public String save() throws SQLException{
        Connection con=null;
        
        String url ="jdbc:derby://localhost:1527/final";
        String user ="final";
        String password ="final";
        try {
            con =DriverManager.getConnection(url, user, password);
            PreparedStatement pre = con.prepareStatement("INSERT INTO KAYIT(isim, soyisim, sehir, sokak) VALUES(?, ?, ?, ?)");
            pre.setString(1, getFirstname());
            pre.setString(2, getLastname());
            pre.setString(3, getCity());
            pre.setString(4, getStreet());
            pre.executeUpdate();
            con.close();
            return "kayıt.xhtml";
            
        } catch (SQLException ex) {
            Logger.getLogger(KayıtBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return "index.xhtml";
        
    }
}
