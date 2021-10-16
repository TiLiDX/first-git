package com.youyue.service.impl;

import com.youyue.dao.EmpDao;
import com.youyue.dao.DeptDao;
import com.youyue.dao.impl.EmpDaoImpl;
import com.youyue.dao.impl.DeptDaoImpl;
import com.youyue.model.Dept;
import com.youyue.model.Employee;
import com.youyue.service.EmpService;

import java.util.List;
import java.util.Vector;

public class EmpServiceImpl implements EmpService {
    @Override
    public List<Employee> queryAll() {
        EmpDao empDao = new EmpDaoImpl();
        List<Employee> emps = empDao.queryAll();
        return emps;
    }

    @Override
    public Vector<Dept> queryDept() {
        DeptDao empDto = new DeptDaoImpl();
        Vector<Dept> depts = empDto.queryDept();
        return depts;
    }

    @Override
    public void save(Employee employee) {
        EmpDao empDao = new EmpDaoImpl();
        empDao.save(employee);
    }

    @Override
    public Employee getById(int id) {
        EmpDao empDao = new EmpDaoImpl();
        Employee emps = empDao.getById(id);
        return emps;
    }

    @Override
    public void update(Employee employee) {
        EmpDao empDao = new EmpDaoImpl();
        empDao.update(employee);
    }
}
