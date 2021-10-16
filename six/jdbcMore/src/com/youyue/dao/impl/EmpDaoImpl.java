package com.youyue.dao.impl;

import com.youyue.dao.EmpDao;
import com.youyue.model.Dept;
import com.youyue.model.Employee;
import com.youyue.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDaoImpl implements EmpDao {
    @Override
    public List<Employee> queryAll() {
        List<Employee> emps = new ArrayList<>();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {

            connection = DBConnection.getConnection();
            String sql = "SELECT e.empno,e.ename,e.job,e.sal,d.deptno,d.dname,d.loc FROM emp e,dept d WHERE e.deptno = d.deptno";
            ps = connection.prepareStatement(sql);

            rs = ps.executeQuery();
            Employee emp = null;
            while(rs.next()) {
                emp = new Employee();
                emp.setEmpno(rs.getInt("empno"));
                emp.setEname(rs.getString("ename"));
                emp.setJob(rs.getString("job"));
                emp.setSal(rs.getDouble("sal"));

                Dept dept = new Dept();
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                dept.setLoc(rs.getString("loc"));

                emp.setDept(dept);
                emps.add(emp);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBConnection.close(rs,ps, connection);
        }
        return emps;
    }
//    @Override
//    public List<Employee> queryAll() {
//        List<Employee> emps= new ArrayList<Employee>();
//
//        Connection connection = null;
//        PreparedStatement ps=null;
//        ResultSet rs=null;
//        try {
//            connection = DBConnection.getConnection();
//
//            String sql= "select e.empno,e.ename,e.job,e.sal,d.dname from emp e,dept d where e.deptno=d.deptno";
//
//            ps = connection.prepareStatement(sql);
//
//            rs = ps.executeQuery();
//            Employee employee=null;
//            Dept dept=null;
//            while (rs.next()){
//                //emps=new ArrayList<Employee>();
//                employee = new Employee();
//                int id = rs.getInt("empno");
//                String name = rs.getString("ename");
//                String job = rs.getString("job");
//                double sal = rs.getDouble("sal");
//                employee.setEmpno(id);
//                employee.setEname(name);
//                employee.setJob(job);
//                employee.setSal(sal);
//
//                dept =new Dept();
//                //int deptno = rs.getInt("deptno");
//                String dname = rs.getString("dname");
//                //String loc = rs.getString("loc");
//                //dept.setDeptno(deptno);
//                dept.setDname(dname);
//                //dept.setLoc(loc);
//
//                employee.setDept(dept);
//
//                emps.add(employee);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }finally {
//            DBConnection.close(rs,ps,connection);
//        }
//        return emps;
//    }

    @Override
    public void save(Employee employee) {
        Connection connection = null;
        PreparedStatement ps=null;
        try {
            connection = DBConnection.getConnection();

            String sql= "insert into emp(empno,ename,job,sal,deptno) values (?,?,?,?,?)";

            ps = connection.prepareStatement(sql);

            ps.setInt(1,employee.getEmpno());
            ps.setString(2,employee.getEname());
            ps.setString(3,employee.getJob());
            ps.setDouble(4,employee.getSal());
            ps.setInt(5,employee.getDept().getDeptno());

            ps.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBConnection.close(ps,connection);
        }
    }

    @Override
    public Employee getById(int id) {
        Employee employee = null;
        Connection connection = null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            connection = DBConnection.getConnection();

            String sql= "select e.empno,e.ename,e.job,e.sal,d.deptno,d.dname,d.loc from emp e,dept d where e.deptno=d.deptno and e.empno=?";

            ps = connection.prepareStatement(sql);

            ps.setInt(1,id);

            rs = ps.executeQuery();

            while (rs.next()){
                employee = new Employee();
                employee.setEmpno(rs.getInt("empno"));
                employee.setEname(rs.getString("ename"));
                employee.setJob(rs.getString("job"));
                employee.setSal(rs.getDouble("sal"));

                Dept dept = new Dept();
                dept.setDeptno(rs.getInt("deptno"));
                dept.setDname(rs.getString("dname"));
                dept.setLoc(rs.getString("loc"));

                employee.setDept(dept);

                return employee;
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBConnection.close(rs,ps,connection);
        }
        return null;
    }

    @Override
    public void update(Employee employee) {
        Connection connection = null;
        PreparedStatement ps=null;
        try {
            connection = DBConnection.getConnection();

            String sql= "update emp set ename=?,job=?,sal=?,deptno=? where empno=?";

            ps = connection.prepareStatement(sql);

            ps.setString(1,employee.getEname());
            ps.setString(2,employee.getJob());
            ps.setDouble(3,employee.getSal());
            ps.setInt(4,employee.getDept().getDeptno());
            ps.setInt(5,employee.getEmpno());

            ps.execute();

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            DBConnection.close(ps,connection);
        }
    }


}
