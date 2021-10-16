package com.youyue.jdbc03end.dao.impl;

import com.youyue.jdbc03end.dao.EmpDao;
import com.youyue.jdbc03end.dto.EmpDto;
import com.youyue.jdbc03end.model.Employee;
import com.youyue.jdbc03end.util.DBConnection;
import com.youyue.jdbc03end.util.PanDuan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

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

    @Override
    public List<Employee> query(EmpDto empDto) {
        List<Employee> emps = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBConnection.getConnection();

            StringBuilder sql = new StringBuilder("select * from emp where 1=1");


            if (empDto.getId()!=null){
                sql.append(" and empno=?");
            }
            if (!PanDuan.isEmpty(empDto.getName())){
                sql.append(" and ename=?");
            }
            if (empDto.getMin()!=null){
                sql.append(" and sal>=?");
            }
            if (empDto.getMax()!=null){
                sql.append(" and sal=<?");
            }

            ps = connection.prepareStatement(String.valueOf(sql));

            int index=1;
            if (empDto.getId()!=null) {
                ps.setInt(index, empDto.getId());
                index++;
            }
            if (!PanDuan.isEmpty(empDto.getName())) {
                ps.setString(index, empDto.getName());
                index++;
            }
            if (empDto.getMin()!=null) {
                ps.setDouble(index, empDto.getMin());
                index++;
            }
            if (empDto.getMax()!=null) {
                ps.setDouble(index, empDto.getMax());
                index++;
            }

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

    @Override
    public void batchDelete(int[] ids) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBConnection.getConnection();

            StringJoiner sj = new StringJoiner(",");
            for (int id:ids){
                sj.add(id+"");
            }

            //准备sql
            String sql = "delete from emp where empno in("+sj+")";
            //准备PrepareStatement
            ps = connection.prepareStatement(sql);

            //执行
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(ps,connection);
        }
    }

    @Override
    public void insert(Employee employee) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBConnection.getConnection();

            String sql = "insert into emp(empno,ename,job,sal) values(?,?,?,?)";
            ps = connection.prepareStatement(sql);

            ps.setInt(1,employee.getEmpno());
            ps.setString(2,employee.getEname());
            ps.setString(3,employee.getJob());
            ps.setDouble(4,employee.getSal());

            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(ps,connection);
        }
    }

    @Override
    public Employee getById(int id) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = DBConnection.getConnection();

            String sql = "select * from emp where empno=?";
            ps = connection.prepareStatement(sql);

            ps.setInt(1,id);

            rs = ps.executeQuery();
            while (rs.next()) {
                int empno = rs.getInt("empno");
                String ename = rs.getString("ename");
                String job = rs.getString("job");
                double sal = rs.getDouble("sal");

                Employee emp = new Employee(empno,ename,job,sal);
                return emp;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(rs,ps,connection);
        }
        return null;
    }

    @Override
    public void update(Employee employee) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBConnection.getConnection();

            String sql = "update emp set ename=?,job=?,sal=? where empno=?";
            ps = connection.prepareStatement(sql);

            //6、设置参数
            ps.setString(1,employee.getEname());
            ps.setString(2,employee.getJob());
            ps.setDouble(3,employee.getSal());
            ps.setInt(4,employee.getEmpno());
            //7、执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(ps,connection);
        }
    }

    @Override
    public void delete(int id) {
        Connection connection = null;
        PreparedStatement ps = null;
        try {
            connection = DBConnection.getConnection();

            //准备sql
            String sql = "delete from emp where empno=?";
            //准备PrepareStatement
            ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            //执行
            ps.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBConnection.close(ps,connection);
        }
    }




}
