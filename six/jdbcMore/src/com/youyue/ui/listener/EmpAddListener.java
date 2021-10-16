package com.youyue.ui.listener;

import com.youyue.model.Dept;
import com.youyue.model.Employee;
import com.youyue.service.EmpService;
import com.youyue.service.impl.EmpServiceImpl;
import com.youyue.ui.EmpAddFrame;
import com.youyue.ui.EmpFrame;
import com.youyue.ui.tablemodel.EmpTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EmpAddListener implements ActionListener {

    private EmpAddFrame empAddFrame;

    public EmpAddListener(EmpAddFrame empAddFrame) {
        this.empAddFrame = empAddFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = empAddFrame.getIdText().getText();
        String name = empAddFrame.getNameText().getText();
        String job = empAddFrame.getJobText().getText();
        String sal = empAddFrame.getSalText().getText();
        Dept dept = (Dept)empAddFrame.getQname().getSelectedItem();

        Employee emp = new Employee(Integer.parseInt(id),name,job,Double.parseDouble(sal));
        emp.setDept(dept);

        EmpService empService = new EmpServiceImpl();
        empService.save(emp);

        List<Employee> emps = empService.queryAll();

        EmpTableModel empTableModel = EmpTableModel.getInstance();
        empTableModel.setData(emps);

        EmpFrame.getEmpTable().updateUI();

        empAddFrame.dispose();
    }
}
