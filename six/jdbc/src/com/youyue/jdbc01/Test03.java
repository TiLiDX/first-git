package com.youyue.jdbc01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Test03 {
    public static void main(String[] args) throws Exception{
        List<Emp> list = new ArrayList<>();
        //1、导包
        //2、加载驱动
        Class.forName("oracle.jdbc.driver.OracleDriver");
        //3、获取链接
        Connection connection= DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/orcl",
                                                          "scott","tiger");
        //4、准备sql
        String sql = "select * from emp_a";
        //5、准备PreparedStatement
        PreparedStatement ps = connection.prepareStatement(sql);
        //6、设置参数
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int empno=rs.getInt("empno");
            String ename=rs.getString("ename");
            int sal=rs.getInt("sal");

            list.add(new Emp(empno,ename,sal));
        }
        System.out.println(list.toString());
        //8、关闭资源
        ps.close();
        connection.close();
    }
}
