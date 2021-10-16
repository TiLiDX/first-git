package com.youyue.ui.listener;

import com.youyue.model.Employee;
import com.youyue.service.EmpService;
import com.youyue.service.impl.EmpServiceImpl;
import com.youyue.ui.EmpFrame;
import com.youyue.ui.tablemodel.EmpTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EmpRefreshListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        EmpService empService = new EmpServiceImpl();
        List<Employee> emps = empService.queryAll();

        EmpTableModel empTableModel = EmpTableModel.getInstance();
        empTableModel.setData(emps);

        EmpFrame.getEmpTable().updateUI();
    }
}
