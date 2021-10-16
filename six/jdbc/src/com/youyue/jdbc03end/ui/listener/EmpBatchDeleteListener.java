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

public class EmpBatchDeleteListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        int rowCount = EmpFrame.getEmpTable().getSelectedRowCount();
        if (rowCount==0){
            JOptionPane.showMessageDialog(null,"请至少选中一行","提示",JOptionPane.WARNING_MESSAGE);
        }else {

            int num = JOptionPane.showConfirmDialog(null, "是否删除?");
            if (num==0) {
                int rows[] = EmpFrame.getEmpTable().getSelectedRows();
                int ids[] = new int[rows.length];
                for (int i = 0; i < rows.length; i++) {
                    ids[i] = (int) EmpFrame.getEmpTable().getValueAt(rows[i], 0);
                }

                EmpService empService = new EmpServiceImpl();
                empService.batchDelete(ids);

                List<Employee> emps = empService.queryAll();
                EmpTableModel empTableModel = EmpTableModel.getInstance();
                empTableModel.setEmps(emps);

                EmpFrame.getEmpTable().updateUI();
            }

        }
    }
}
