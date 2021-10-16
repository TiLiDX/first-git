package com.youyue.jdbc03.service.impl;

import com.youyue.jdbc03.dao.EmpDao;
import com.youyue.jdbc03.dao.impl.EmpDaoImpl;
import com.youyue.jdbc03.model.Employee;
import com.youyue.jdbc03.service.EmpService;

import java.util.List;

public class EmpServiceImpl implements EmpService {
    @Override
    public List<Employee> queryAll() {
        EmpDao empDao=new EmpDaoImpl();
        List<Employee> employees = empDao.queryAll();
        return employees;
    }
}
