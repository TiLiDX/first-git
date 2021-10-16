package com.youyue.service;

import com.youyue.model.Dept;
import com.youyue.model.Employee;

import java.util.List;
import java.util.Vector;

public interface EmpService {
    public List<Employee> queryAll();
    public Vector<Dept> queryDept();
    public void save(Employee employee);
    public Employee getById(int id);
    public void update(Employee employee);
}
