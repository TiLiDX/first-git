package com.youyue.jdbc03end.dao;


import com.youyue.jdbc03end.dto.EmpDto;
import com.youyue.jdbc03end.model.Employee;

import java.util.List;

/**
 * @author lei_she
 * @version 1.0
 * @create_time 2021-06-05 15:54
 */
public interface EmpDao {
    List<Employee> queryAll();
    public void insert(Employee employee);
    public Employee getById(int id);
    public void update(Employee employee);
    public void delete(int id);
    List<Employee> query(EmpDto empDto);
    public void batchDelete(int ids[]);
}
