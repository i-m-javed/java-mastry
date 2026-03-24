package com.ProductInventoryApp.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseUtil {
    private static Properties properties = new Properties();

    static {
        try (FileInputStream fis = new FileInputStream("E:\\Training\\JDBCApplication\\anything.properties")) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection() throws Exception{
        return DriverManager.getConnection(properties.getProperty("anything.url"),
                properties.getProperty("anything.user"),
                properties.getProperty("anything.password"));
    }
}
