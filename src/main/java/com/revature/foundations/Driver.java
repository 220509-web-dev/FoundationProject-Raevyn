package com.revature.foundations;

import com.revature.foundations.DAO.UserDAO;
import com.revature.foundations.Util.ConnectionFactory;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {

    public Driver() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {

        System.out.println(ConnectionFactory.getConnection());
        System.out.println(new UserDAO().getUsers());
    }
}

