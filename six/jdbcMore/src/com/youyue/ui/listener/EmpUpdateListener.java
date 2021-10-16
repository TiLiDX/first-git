package com.youyue.ui.listener;

import com.youyue.model.Dept;
import com.youyue.model.Employee;
import com.youyue.service.EmpService;
import com.youyue.service.impl.EmpServiceImpl;
import com.youyue.ui.EmpFrame;
import com.youyue.ui.EmpUpdateFrame;
import com.youyue.ui.tablemodel.EmpTableModel;

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
        String id = empUpdateFrame.getIdText().getText();
        String name = empUpdateFrame.getNameText().getText();
        String job = empUpdateFrame.getJobText().getText();
        String sal = empUpdateFrame.getSalText().getText();
        Dept dept =(Dept)empUpdateFrame.getDept().getSelectedItem();

        Employee employee = new Employee(Integer.parseInt(id),name,job,Double.parseDouble(sal));
        employee.setDept(dept);

        EmpService empService = new EmpServiceImpl();
        empService.update(employee);

        List<Employee> emps = empService.queryAll();

        EmpTableModel empTableModel = EmpTableModel.getInstance();
        empTableModel.setData(emps);

        EmpFrame.getEmpTable().updateUI();

        empUpdateFrame.dispose();

    }
}
