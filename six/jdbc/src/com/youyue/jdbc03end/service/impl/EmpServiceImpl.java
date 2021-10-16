package com.youyue.jdbc03end.service.impl;

import com.youyue.jdbc03end.dao.EmpDao;
import com.youyue.jdbc03end.dao.impl.EmpDaoImpl;
import com.youyue.jdbc03end.dto.EmpDto;
import com.youyue.jdbc03end.model.Employee;
import com.youyue.jdbc03end.service.EmpService;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    @Override
    public List<Employee> queryAll() {
        EmpDao empDao=new EmpDaoImpl();
        List<Employee> employees = empDao.queryAll();
        return employees;
    }

    @Override
    public List<Employee> query(EmpDto empDto) {
        EmpDao empDao=new EmpDaoImpl();
        List<Employee> employees = empDao.query(empDto);
        return employees;
    }

    @Override
    public void batchDelete(int[] ids) {
        EmpDao empDao = new EmpDaoImpl();
        empDao.batchDelete(ids);
    }

    @Override
    public void add(Employee employee) {
        EmpDao empDao=new EmpDaoImpl();
        empDao.insert(employee);
    }

    @Override
    public Employee getById(int id) {
        EmpDao empDao = new EmpDaoImpl();
        Employee employee = empDao.getById(id);
        return employee;
    }

    @Override
    public void update(Employee employee) {
        EmpDao empDao=new EmpDaoImpl();
        empDao.update(employee);
    }

    @Override
    public void delete(int id) {
        EmpDao empDao = new EmpDaoImpl();
        empDao.delete(id);
    }


}
