package com.youyue.jdbc03end.ui.listener;

import com.youyue.jdbc03end.model.Employee;
import com.youyue.jdbc03end.service.EmpService;
import com.youyue.jdbc03end.service.impl.EmpServiceImpl;
import com.youyue.jdbc03end.ui.EmpAddFrame;
import com.youyue.jdbc03end.ui.EmpFrame;
import com.youyue.jdbc03end.ui.tablemodel.EmpTableModel;

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
        String id = this.empAddFrame.getIdText().getText();
        String name = this.empAddFrame.getNameText().getText();
        String job = this.empAddFrame.getJobText().getText();
        String sal = this.empAddFrame.getSalText().getText();

        Employee employee = new Employee(Integer.parseInt(id),name,job,Double.parseDouble(sal));

        //调用service--->dao 完成保存操作
        EmpService empService = new EmpServiceImpl();
        empService.add(employee);

        //关闭界面
        this.empAddFrame.dispose();

        //界面刷新
        List<Employee> emps = empService.queryAll();
        EmpTableModel empTableModel = EmpTableModel.getInstance();
        empTableModel.setEmps(emps);

        //表格刷新
        EmpFrame.getEmpTable().updateUI();
    }
}
