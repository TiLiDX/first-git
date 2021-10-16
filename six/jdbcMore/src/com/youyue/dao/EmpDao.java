package com.youyue.dao;

import com.youyue.model.Employee;

import java.util.List;

public interface EmpDao {
    List<Employee> queryAll();
    public void save(Employee employee);
    public Employee getById(int id);
    public void update(Employee employee);
}
