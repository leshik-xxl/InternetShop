package kpi.stud.servletProject.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCConnection{

    private static JDBCConnection instance;

    private Connection connection;

    private JDBCConnection() {
        String connectionString = "jdbc:postgresql://localhost:4814/internetShop";
        try {
            Class.forName("org.postgresql.Driver").newInstance();
            connection = DriverManager.getConnection(connectionString, "postgres", "4814");

        } catch (Exception ignored) {

        }


    }

    public static JDBCConnection getInstance() {
        if (instance == null) {
            instance = new JDBCConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}