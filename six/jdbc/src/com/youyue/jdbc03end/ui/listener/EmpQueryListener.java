package com.youyue.jdbc03end.ui.listener;

import com.youyue.jdbc03end.dto.EmpDto;
import com.youyue.jdbc03end.model.Employee;
import com.youyue.jdbc03end.service.EmpService;
import com.youyue.jdbc03end.service.impl.EmpServiceImpl;
import com.youyue.jdbc03end.ui.EmpFrame;
import com.youyue.jdbc03end.ui.tablemodel.EmpTableModel;
import com.youyue.jdbc03end.util.PanDuan;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class EmpQueryListener implements ActionListener {
    private EmpFrame empFrame;

    public EmpQueryListener(EmpFrame empFrame) {
        this.empFrame = empFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String id = empFrame.getIdText().getText();
        String name = empFrame.getNameText().getText();
        String min = empFrame.getMinText().getText();
        String max = empFrame.getMaxText().getText();

        EmpDto empDto = new EmpDto();
        empDto.setId(PanDuan.isEmpty(id) ? null : Integer.parseInt(id));
        empDto.setName(name);
        empDto.setMin(PanDuan.isEmpty(min) ? null : Double.parseDouble(min));
        empDto.setMax(PanDuan.isEmpty(max) ? null : Double.parseDouble(max));

        EmpService empService = new EmpServiceImpl();
        List<Employee> query = empService.query(empDto);

        EmpTableModel empTableModel = EmpTableModel.getInstance();
        empTableModel.setEmps(query);

        EmpFrame.getEmpTable().updateUI();
    }
}
