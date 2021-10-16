package com.youyue.jdbc03end.ui.listener;

import com.youyue.jdbc03end.model.Employee;
import com.youyue.jdbc03end.service.EmpService;
import com.youyue.jdbc03end.service.impl.EmpServiceImpl;
import com.youyue.jdbc03end.ui.EmpFrame;
import com.youyue.jdbc03end.ui.tablemodel.EmpTableModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

//单行查询
public class EmpDeleteListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        int rowCount = EmpFrame.getEmpTable().getSelectedRowCount();
        if (rowCount!=1){
            JOptionPane.showMessageDialog(null,"请选中一行！","提示",JOptionPane.WARNING_MESSAGE);
        }else {

            int selectedRow = EmpFrame.getEmpTable().getSelectedRow();
            int id = (int) EmpFrame.getEmpTable().getValueAt(selectedRow, 0);

            int num = JOptionPane.showConfirmDialog(null, "是否删除?");

            if (num==0) {
                EmpService empService = new EmpServiceImpl();
                empService.delete(id);

                List<Employee> emps = empService.queryAll();
                EmpTableModel empTableModel = EmpTableModel.getInstance();
                empTableModel.setEmps(emps);

                EmpFrame.getEmpTable().updateUI();
            }
        }
    }
}
