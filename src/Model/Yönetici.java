package Model;

import java.sql.Connection;
import java.util.ArrayList;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javax.swing.table.DefaultTableModel;

public class Yönetici extends User {

    Connection con = conn.connDb();
    Statement st = null;
    ResultSet rs = null;
    PreparedStatement preparedStatement = null;

    public Yönetici(int id, String nickname, String password, String name, String type) {
        super(id, nickname, password, name, type);
    }

    
    
    public Yönetici() {

    }

    
    
    public ArrayList<User> getMüsteriList() throws SQLException {
        ArrayList<User> list = new ArrayList<>();

        User obj;

        try {
            st = con.createStatement(); 
            rs = st.executeQuery("SELECT * FROM user WHERE type = 'Müsteri' ");
            while (rs.next()) {
                obj = new User(rs.getInt("id"), rs.getString("nickname"), rs.getString("password"), rs.getString("name"), rs.getString("type"));
                list.add(obj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;

    }

    public boolean addMüsteri(String nickname, String password, String name, String type) throws SQLException {
        String query = "INSERT INTO user" + "(nickname,password,name,type) VALUES " + "(?,?,?,?)";
        boolean key = false;
        try {
            st = con.createStatement();
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, nickname);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.setString(4, type);

            preparedStatement.executeUpdate();
            key = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (key) {
            return true;
        } else {
            return false;
        }

    }

    public boolean deleteKullanıcı(int id) throws SQLException {
        String query = "DELETE FROM user WHERE id = ?";
        boolean key = false;
        try {
            st = con.createStatement();
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);

            preparedStatement.executeUpdate();
            key = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (key) {
            return true;
        } else {
            return false;
        }

    }

    public boolean UpdataKullanıcı(int id, String nickname, String password, String name, String type) throws SQLException {
        String query = "UPDATE user SET name=?,nickname=?,password=?,type=? WHERE id=?";
        boolean key = false;
        try {
            st = con.createStatement();
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, nickname);
            preparedStatement.setString(3, password);
            preparedStatement.setString(4, type);
            preparedStatement.setInt(5, id);

            preparedStatement.executeUpdate();
            key = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (key) {
            return true;
        } else {
            return false;
        }

    }

}
