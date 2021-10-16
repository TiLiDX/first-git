package com.youyue.jdbc03.dao;


import com.youyue.jdbc03.model.Employee;

import java.util.List;

/**
 * @author lei_she
 * @version 1.0
 * @create_time 2021-06-05 15:54
 */
public interface EmpDao {
    List<Employee> queryAll();
}
