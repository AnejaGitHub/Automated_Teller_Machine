package com.saurabhaneja.jdbc;

import java.sql.*;

public class connect {
    public Connection connection;
    public Statement statement;
    public connect(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/atmdb", "root", "RootPass");
            statement = connection.createStatement();
//            connection.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
