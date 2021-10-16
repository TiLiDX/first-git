package com.youyue.jdbc03.ui;

import com.youyue.jdbc03.model.Employee;
import com.youyue.jdbc03.service.EmpService;
import com.youyue.jdbc03.service.impl.EmpServiceImpl;
import com.youyue.jdbc03.ui.tablemodel.EmpTableModel;

import javax.swing.*;
import java.util.List;

/**
 * @author lei_she
 * @version 1.0
 * @create_time 2021-06-05 16:01
 */
public class EmpFrame {
    public static void main(String[] args){
        JFrame empFrame = new JFrame();
        empFrame.setSize(800,500);

        EmpService empService = new EmpServiceImpl();
        List<Employee> emps = empService.queryAll();

        EmpTableModel empTableModel = EmpTableModel.getInstance();
        empTableModel.setEmps(emps);

        JTable empTable = new JTable(empTableModel);
        empTable.setBounds(0,0,800,500);
        JScrollPane scrollPane = new JScrollPane(empTable);
        scrollPane.setBounds(0,0,800,500);


        empFrame.add(scrollPane);
        empFrame.setLocationRelativeTo(null);
        empFrame.setVisible(true);
    }
}
