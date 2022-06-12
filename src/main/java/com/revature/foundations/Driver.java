package com.revature.foundations;

import com.revature.foundations.Util.ConnectionFactory;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Driver {

    public Driver() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {

            System.out.println(ConnectionFactory.getConnection());
    }
    Statement stmt;

    {
        try {
            stmt = ConnectionFactory.getConnection().createStatement();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    ResultSet rs=stmt.executeQuery ("SELECT * from app_users");


    }
