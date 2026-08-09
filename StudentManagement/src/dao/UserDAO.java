/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;
import db.DBconnection;
import model.User;
import java.sql.*;

/**
 *
 * @author hnd
 */
public class UserDAO {

    Connection con;

    public UserDAO() {
              con = DBconnection.getConnection();
    }

 
    public boolean register(User user) {

        try {

            String sql = "INSERT INTO users(fullname, username, email, password) VALUES(?,?,?,?)";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, user.getFullname());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());

            ps.executeUpdate();

            return true;

        } catch (SQLException e) {

            System.out.println(e);
            return false;
        }

    }


    public boolean login(String username, String password) {

        try {

            String sql = "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next();

        } catch (SQLException e) {

            System.out.println(e);
            return false;

        }

    }

}