package Controller;

import Model.*;
import View.*;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;

public class Controller {

    static DataBaseHandler conn = new DataBaseHandler();
    public static int id;
    public static String name, email1, password1;

    public static CategoryUser LogIn(String email, String password) {
        Login login = new Login();
        UpdateData updatedata = new UpdateData();
        conn.connect();
        String query = "SELECT * FROM user Where email = '" + email + "' AND password = '" + password + "'";
        CategoryUser user = new CategoryUser();
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.last();
            if (rs.getRow() == 1) {
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setIdCategory(rs.getInt("idCategory"));
                id = rs.getInt("id");
                name = rs.getString("name");
                email1 = rs.getString("email");
                password1 = rs.getString("password");
                JOptionPane.showMessageDialog(null, "Berhasil Login");
                updatedata.UpdateData();
            } else {
                login.Login();
                JOptionPane.showMessageDialog(null, "Gagal Login");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return (user);
    }

    public static boolean UpdateProfil(CategoryUser user) {
        conn.connect();
        user.setId(id);
        String query = "UPDATE user SET name='" + user.getName() + "', "
                + "email='" + user.getEmail() + "', "
                + "password='" + user.getPassword() + "', "
                + "idCategory='" + user.getIdCategory() + "' "
                + "WHERE id='" + user.getId() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Disimpan");
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal Disimpan");
            return (false);
        }
    }

    public static boolean DeleteProfil(CategoryUser user) {
        MainMenu main = new MainMenu();
        conn.connect();
        user.setId(id);
        String query = "DELETE FROM user WHERE id='" + user.getId() + "'";
        try {
            Statement stmt = conn.con.createStatement();
            stmt.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
            main.MainMenu();
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Gagal Dihapus");
            return (false);
        }
    }

    public static boolean Register(CategoryUser user) {
        conn.connect();
        String query = "INSERT INTO user VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = conn.con.prepareStatement(query);
            stmt.setInt(1, user.getId());
            stmt.setString(2, user.getName());
            stmt.setString(3, user.getEmail());
            stmt.setString(4, user.getPassword());
            stmt.setInt(5, user.getIdCategory());
            stmt.setString(6, user.getPhoto());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Berhasil Register");
            return (true);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal Register");
            e.printStackTrace();
            return (false);
        }
    }

    public static boolean LihatUser(int inputCategory) {
        conn.connect();
        int i = 0;
        String query = "SELECT * FROM User Where idCategory='" + inputCategory + "'";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                JOptionPane.showMessageDialog(null, "id :" + rs.getInt("ID"));
                JOptionPane.showMessageDialog(null, "Name : " + rs.getString("Name"));
                JOptionPane.showMessageDialog(null, "Email : " + rs.getString("Email"));
                JOptionPane.showMessageDialog(null, "id Category :" + rs.getInt("idCategory"));
                i = 1;
            }
            if (i == 0) {
                JOptionPane.showMessageDialog(null, "Not Found");
                i = 0;
            }
            return (true);
        } catch (SQLException e) {
            e.printStackTrace();
            return (false);
        }
    }

    public static ArrayList<CategoryUser> getCategoryUser() {
        ArrayList<CategoryUser> category = new ArrayList<>();
        conn.connect();
        String query = "SELECT * FROM categoryuser";
        try {
            Statement stmt = conn.con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                CategoryUser categories = new CategoryUser();
                categories.setIdCategory(rs.getInt("idCategory"));
                categories.setNameCategory(rs.getString("name"));
                category.add(categories);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (category);
    }
}
