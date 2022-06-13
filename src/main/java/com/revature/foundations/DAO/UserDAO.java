package com.revature.foundations.DAO;

import com.revature.foundations.models.appUser;
import com.revature.foundations.Util.ConnectionFactory;
import com.revature.foundations.Util.exceptions.DataSourceException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserDAO {

    public List<appUser> getUsers() {

        List<appUser> users = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM users";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                appUser user = new appUser();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setFirst(rs.getString("first_name"));
                user.setLast(rs.getString("last_name"));

                users.add(user);
            }

        } catch (SQLException e) {
            System.err.println( "An error occurred within UserDAO#getUsers");
        }

        return users;

    }

    public appUser save(appUser newUser) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO users VALUES (default, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, newUser.getUsername());
            pstmt.setString(2, newUser.getPassword());
            pstmt.setString(3, newUser.getEmail());
            pstmt.setString(4, newUser.getFirst());
            pstmt.setString(5, newUser.getLast());

            int rowsInserted = pstmt.executeUpdate();

            if (rowsInserted != 0) {
                ResultSet rs = pstmt.getGeneratedKeys();
                rs.next();
                newUser.setId(rs.getInt("id"));
                return newUser;
            }
            throw new RuntimeException();

        } catch (SQLException e) {
            throw new DataSourceException("An error occurred during data access", e);
        }
    }

    public void persist(appUser newUser) {
    }

    public List<appUser> getUsersByUsername(String username) {
        return null;
    }
}
