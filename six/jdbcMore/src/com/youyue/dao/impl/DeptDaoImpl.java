package com.youyue.dao.impl;

import com.youyue.dao.DeptDao;
import com.youyue.model.Dept;
import com.youyue.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class DeptDaoImpl implements DeptDao {
    @Override
    public Vector<Dept> queryDept() {
        Vector<Dept> emps= new Vector<>();

        Connection connection = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            connection = DBConnection.getConnection();

            String sql= "select * from dept";

            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();
            //Employee employee=null;
            Dept dept=null;
            while (rs.next()){
                dept = new Dept();
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                dept.setLoc(rs.getString("loc"));

                emps.add(dept);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBConnection.close(rs,ps,connection);
        }
        return emps;
    }
}
