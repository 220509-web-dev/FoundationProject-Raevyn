package com.revature.foundations.DAO;


import com.revature.foundations.models.AppUser;
import com.revature.foundations.Util.ConnectionFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoPostgres implements UserDAO{

    @Override
    public User createUser(User user) {

        try(Connection conn = ConnectionFactory.getConnection()){
            String sql = "insert into user values (default,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);//
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getReleaseYear());

            ps.execute();

            // getting the generated primary key value
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt("id");

            book.setBookId(generatedId);
            return book;
        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public Book getBookById(int id) {

        try(Connection conn = ConnectionFactory.getConnection()){
            String sql = "select * from user where id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();

            rs.next();


            User user = new User();
            user.setUserId(id);
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("last"));
            book.setReleaseYear(rs.getInt("release_year"));
            return user;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;
    }

    @Override
    public List<User> getAllUsers() {

        try(Connection conn = ConnectionFactory.getConnection()){
            String sql = "select * from user";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            List<User> books = new ArrayList<User>();

            while (rs.next()){
                User user = new User();
                user.setUserId(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("last"));
                book.setReleaseYear(rs.getInt("release_year"));
                users.add(user);
            }
            return users;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public User updateUser(User user) {

        try(Connection conn = ConnectionFactory.getConnection()){
            String sql = "update user set username = ?, password = ?,  where book_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getId());

            ps.execute();

            return user;

        } catch (SQLException exception) {
            exception.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteUserById(int id) {

        try(Connection conn = ConnectionFactory.getConnection()){
            String sql = "delete from user where user_id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.execute();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

    }
}