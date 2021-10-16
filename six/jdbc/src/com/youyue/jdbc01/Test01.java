package com.youyue.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test01 {
    public static void main(String[] args) throws Exception {
        //1、导包
        //2、加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //3、获取链接
        Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
                                                          "scott","tiger");
        //4、准备sql
        String sql = "insert into emp_a(empno,ename,sal) values(?,?,?)";
        //5、准备PreparedStatement
        PreparedStatement ps = connection.prepareStatement(sql);
        //6、设置参数
        ps.setInt(1,2);
        ps.setString(2,"张三");
        ps.setInt(3,6000);
        //7、执行
        ps.execute();
        //8、关闭资源
        ps.close();
        connection.close();
    }
}
