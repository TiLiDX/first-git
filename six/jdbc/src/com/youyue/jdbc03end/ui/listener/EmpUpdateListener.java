package com.youyue.jdbc03end.ui.listener;

import com.youyue.jdbc03end.model.Employee;
import com.youyue.jdbc03end.service.EmpService;
import com.youyue.jdbc03end.service.impl.EmpServiceImpl;
import com.youyue.jdbc03end.ui.EmpFrame;
import com.youyue.jdbc03end.ui.EmpUpdateFrame;
import com.youyue.jdbc03end.ui.tablemodel.EmpTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EmpUpdateListener implements ActionListener {
    private EmpUpdateFrame empUpdateFrame;

    public EmpUpdateListener(EmpUpdateFrame empUpdateFrame) {
        this.empUpdateFrame = empUpdateFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = this.empUpdateFrame.getIdText().getText();
        String name = this.empUpdateFrame.getNameText().getText();
        String job = this.empUpdateFrame.getJobText().getText();
        String sal = this.empUpdateFrame.getSalText().getText();

        Employee employee = new Employee(Integer.parseInt(id),name,job,Double.parseDouble(sal));

        EmpService empService = new EmpServiceImpl();
        empService.update(employee);

        this.empUpdateFrame.dispose();

        List<Employee> emps = empService.queryAll();
        EmpTableModel empTableModel = EmpTableModel.getInstance();
        empTableModel.setEmps(emps);

        EmpFrame.getEmpTable().updateUI();
    }
}
