package com.revature.foundations.DAO;

import com.revature.foundations.models.AppUser;
import com.revature.foundations.Util.ConnectionFactory;
import com.revature.foundations.Util.exceptions.DataSourceException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class UserDAO {

    public List<AppUser> getUsers() {

        List<AppUser> users = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "SELECT * FROM users";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                AppUser user = new AppUser();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                users.add(user);
            }

        } catch (SQLException e) {
            System.err.println( "An error occurred within UserDAO#getUsers");
        }

        return users;

    }

    public AppUser save(AppUser newUser) {
        try (Connection conn = ConnectionFactory.getInstance().getConnection()) {

            String sql = "INSERT INTO users VALUES (default, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, newUser.getUsername());
            pstmt.setString(2, newUser.getPassword());

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

}
