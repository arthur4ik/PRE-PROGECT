package jm.task.core.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
    private static final String username = "root";
    private static final String password = "root";
    private static final String connectionUrl = "jdbc:mysql://localhost:3306/mydatabase";
    private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection()  {
        Connection connection = null;
        try {
            Class.forName(DB_DRIVER);
            connection = DriverManager.getConnection(connectionUrl, username, password);
            System.out.println("Подключение к БД прошло успешно");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Что-то пошло не так");
        }

        return connection;
    }
}

