package com.example.myjavafx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {


    public Connection DBLink;

    public  Connection getConnection(){
        String DBName = "ems_demo";
        String DBUser = "root";
        String DBPassword = "23102004rsgn";

        String url = "jdbc:mysql://localhost/"+DBName ;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            DBLink = DriverManager.getConnection(url,DBUser,DBPassword);
            System.out.println("DB Connected");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  DBLink;
    }


}
