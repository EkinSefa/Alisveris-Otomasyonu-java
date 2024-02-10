
package Model;

import Helper.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Helper.Item;


public class Müsteri extends User{
    
    public Müsteri(int id, String nickname, String password, String name, String type) {
        super(id, nickname, password, name, type);
    }
   
    
    public Müsteri(){
        
        
    }
    
    
    
    
    private int id;
    private String name;
    
    DBConnection conn=new DBConnection();
       
        Statement st=null;
        ResultSet rs=null;
        PreparedStatement preparedStatement=null;
    
        public ArrayList<Katagori> getList() throws SQLException{
        ArrayList<Katagori> list = new ArrayList<>();

        Katagori obj;
       Connection con =conn.connDb();
    
        try {
             
            st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM  katagori");
        while(rs.next()){
            obj=new Katagori();
            obj.setId(rs.getInt("Id"));
            obj.setName(rs.getString("name"));
            list.add(obj);
        }
        } catch (SQLException e2) {
           
        }
        finally{
            st.close();
            rs.close();
            con.close();
            
        }
        return list;
       
        
        
    }
    
    
    
    
    
    

}
