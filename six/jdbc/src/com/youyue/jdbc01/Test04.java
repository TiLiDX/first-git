package com.youyue.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test04 {
    public static void main(String[] args) throws Exception{
        //
        //2
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl","scott","tiger");
        //sql
        String sql = "drop table emp_a";
        //准备连接
        PreparedStatement ps = connection.prepareStatement(sql);
        //
        ps.execute();

        //
        ps.close();
        connection.close();
    }
}
