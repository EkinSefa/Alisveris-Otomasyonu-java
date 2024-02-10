
package Helper;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class DBConnection {
    Connection c=null;                      //     connection sınıfını oluşturuyorum
   
    
 public DBConnection(){}
 
 public Connection connDb(){
        try {
            this.c=DriverManager.getConnection("jdbc:mariadb://localhost:3325/alışveriş?user=root&password=12345");
            return c;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
 }
}
