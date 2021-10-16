package com.youyue.jdbc03end.util;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DBConnection {
    private static final String DRIVER_NAME;
    private static final String URL;
    private static final String USERNAME;
    private static final String PASSWORD;

    static {
        Properties properties=new Properties();
        try {
            properties.load(DBConnection.class.getClassLoader().getResourceAsStream("db.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        DRIVER_NAME = properties.getProperty("jdbc.driver_name");
        URL = properties.getProperty("jdbc.url");
        USERNAME = properties.getProperty("jdbc.username");
        PASSWORD = properties.getProperty("jdbc.password");
    }

    public static Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName(DRIVER_NAME);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(PreparedStatement ps,Connection connection){
        close(null,ps,connection);
    }

    public static void close(ResultSet rs, PreparedStatement ps, Connection connection){
        if (rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if (connection!=null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
