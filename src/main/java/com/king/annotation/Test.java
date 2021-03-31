package com.king.annotation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @program: maven_1
 * @description:
 * @author: King
 * @create: 2021-03-29 21:18
 */
@DBConnection(url = "jdbc:mysql://kingmysql.mysql.rds.aliyuncs.com:3306/onlineclasses",driverClass = "com.mysql.cj.jdbc.Driver",name = "onlineclasses")
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class c = Test.class;


//        Class d = DBConnection.class;
        DBConnection dbc = (DBConnection) c.getDeclaredAnnotation(DBConnection.class);

        String driverClass = dbc.driverClass();
        String url = dbc.url();
        String user = dbc.name();
        String pwd = dbc.pwd();
        System.out.println(driverClass + url + user + pwd);


        Class.forName(driverClass);
        Connection conn = DriverManager.getConnection(url, user, pwd);
        System.out.println(conn.toString());
        conn.close();
    }




}
