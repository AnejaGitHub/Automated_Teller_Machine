package com.saurabhaneja;

import java.sql.*;

public class connect {
    Connection connection;
    Statement statement;
    connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/atmdb", "root", "");
            statement = connection.createStatement();
//            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
