package com.youyue.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test05 {
    public static void main(String[] args) throws Exception{
        //1、导包
        //2、加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //3、获取连接
        Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
                                                           "scott","tiger");
        //4、准备sql
        String sql = "create table emp_a as select * from emp where 1=2";//创建新表，继承emp的结构
        //5、准备PreparedStatement
        PreparedStatement ps = connection.prepareStatement(sql);
        //6、执行
        ps.execute();
        //7、关闭资源
        ps.close();
        connection.close();
    }
}
