package com.youyue.jdbc03end.ui.listener;

import com.youyue.jdbc03end.model.Employee;
import com.youyue.jdbc03end.ui.EmpFrame;
import com.youyue.jdbc03end.ui.tablemodel.EmpTableModel;
import com.youyue.jdbc03end.service.EmpService;
import com.youyue.jdbc03end.service.impl.EmpServiceImpl;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EmpRefreshListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        EmpService empService = new EmpServiceImpl();
        List<Employee> emps = empService.queryAll();

        EmpTableModel empTableModel = EmpTableModel.getInstance();
        empTableModel.setEmps(emps);

        EmpFrame.getEmpTable().updateUI();
    }
}
