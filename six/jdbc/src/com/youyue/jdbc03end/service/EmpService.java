package com.youyue.jdbc03end.service;

import com.youyue.jdbc03end.dto.EmpDto;
import com.youyue.jdbc03end.model.Employee;

import java.util.List;

public interface EmpService {
    public List<Employee> queryAll();
    public void add(Employee employee);
    public Employee getById(int id);
    public void update(Employee employee);
    public void delete(int id);
    public List<Employee> query(EmpDto empDto);
    public void batchDelete(int ids[]);
}
