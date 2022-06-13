package com.revature.foundations.Util;

import java.sql.*;

public class ConnectionFactory {

    private static ConnectionFactory connectionFactory;

    private ConnectionFactory() { super(); }

    public  static ConnectionFactory getInstance() {
        if (connectionFactory == null) {
            connectionFactory = new ConnectionFactory();
        }

        return connectionFactory;
    }

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (Exception e) {
            System.err.println("Failed to load PostgreSQL Driver");
            e.printStackTrace();
        }

    String url = "jdbc:postgresql://localhost:5432/postgres?currentSchema=art_app";
    String username = "postgres";
    String password = "revature";

    return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=art_app", "postgres", "revature");

    }

}
