
package Model;

import Helper.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class Katagori {
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            st.close();
            rs.close();
            con.close();
            
        }
        return list;
       
        
        
        
        
    }
        public Katagori getFetch(int id){
            Connection con =conn.connDb();
            Katagori k=new Katagori();
            
        try {
           
            st=con.createStatement();
            rs=st.executeQuery("SELECT * FROM  katagori  WHERE id=" + id);
            while(rs.next()){
               k.setId(rs.getInt("id"));
               k.setName(rs.getString("name"));
                break;
            }
        } catch (SQLException e1) {
           e1.printStackTrace();
        }
            return k;
        }
        
        
        
        
        
        public boolean addKatagori(String name) throws SQLException{
        String query="INSERT INTO katagori"+"(name) VALUES "+"(?)";
        boolean key=false;
        Connection con =conn.connDb();
          try {
        st=con.createStatement(); 
        preparedStatement=con.prepareStatement(query);
        preparedStatement.setString(1, name);
   
        preparedStatement.executeUpdate();
        key=true;
        
          } catch (SQLException e) {
              e.printStackTrace();
          }
          if (key) 
              return  true;
          
          else
              return false;
          
        
          
          
    }
        public boolean deleteKatagori(int id) throws SQLException{
        String query="DELETE FROM katagori WHERE id = ?";
        boolean key=false;
        Connection con =conn.connDb();
          try {
        st=con.createStatement(); 
        preparedStatement=con.prepareStatement(query);
        preparedStatement.setInt(1, id);
   
        preparedStatement.executeUpdate();
        key=true;
        
          } catch (SQLException e) {
              e.printStackTrace();
          }
          if (key) 
              return  true;
          
          else
              return false;
          
          
          
          
        
    }
         public boolean updataKatagori(int id,String name) throws SQLException{
        String query= "UPDATE katagori SET name=? WHERE id = ?";
        Connection con =conn.connDb();
        boolean key=false;
          try {
        st=con.createStatement(); 
        preparedStatement=con.prepareStatement(query);
        preparedStatement.setString(1,name);
        preparedStatement.setInt(2, id);
 
        preparedStatement.executeUpdate();
        key=true;
        
          } catch (SQLException e) {
              e.printStackTrace();
          }
          if (key) 
              return  true;
          
          else
              return false;
          
        
    }
    
         
         
         
    
    public Katagori(int id,String name){
        
        
        this.id=id;
        this.name=name;
        
    }
    public Katagori(){
        
    }
    


    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

    
    public String getName() {
        return name;
    }

  
    public void setName(String name) {
        this.name = name;
    }
    
    
}
