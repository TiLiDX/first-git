package com.youyue.ui.listener;

import com.youyue.model.Employee;
import com.youyue.service.EmpService;
import com.youyue.service.impl.EmpServiceImpl;
import com.youyue.ui.EmpFrame;
import com.youyue.ui.EmpUpdateFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpPreUpdateListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        int rowCount = EmpFrame.getEmpTable().getSelectedRowCount();
        if (rowCount!=1){
            JOptionPane.showMessageDialog(null,"请选择一行","提示",JOptionPane.WARNING_MESSAGE);
        }else {
            int row = EmpFrame.getEmpTable().getSelectedRow();
            int id = (int)EmpFrame.getEmpTable().getValueAt(row, 0);

            EmpService empService =new EmpServiceImpl();
            Employee employee = empService.getById(id);

            new EmpUpdateFrame(employee);
        }
    }
}
