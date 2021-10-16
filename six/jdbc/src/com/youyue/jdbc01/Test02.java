package com.youyue.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Test02 {
    public static void main(String[] args) throws Exception {
        //1、导包
        //2、加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //3、获取链接
        Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
                                                          "scott","tiger");
        //4、准备sql
        String sql = "update emp_a SET ename=?,job=?,sal=? WHERE empno=?";
        //5、准备PreparedStatement
        PreparedStatement ps = connection.prepareStatement(sql);
        //6、设置参数
        ps.setInt(1,3);
        ps.setString(2,"xiao三");
        ps.setInt(3,1000);
        ps.setInt(4,2);
        //7、执行
        ps.execute();
        //8、关闭资源
        ps.close();
        connection.close();
    }
}
