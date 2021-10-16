package com.youyue.jdbc03.dao.impl;

import com.youyue.jdbc03.dao.EmpDao;
import com.youyue.jdbc03.model.Employee;
import com.youyue.jdbc03.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lei_she
 * @version 1.0
 * @create_time 2021-06-05 15:56
 */
public class EmpDaoImpl implements EmpDao {
    @Override
    public List<Employee> queryAll() {
        List<Employee> emps = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBConnection.getConnection();

            String sql = "SELECT * FROM emp";
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();
            while (rs.next()) {
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                double sal = rs.getDouble("sal");

                Employee emp = new Employee(empno,ename,job,sal);
                emps.add(emp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           DBConnection.close(rs,ps,connection);
        }
        return emps;
    }
}
