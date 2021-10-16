package com.youyue.jdbc03end.ui.listener;

import com.youyue.jdbc03end.model.Employee;
import com.youyue.jdbc03end.service.EmpService;
import com.youyue.jdbc03end.service.impl.EmpServiceImpl;
import com.youyue.jdbc03end.ui.EmpFrame;
import com.youyue.jdbc03end.ui.EmpUpdateFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpPreUpdateListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        int rowCount = EmpFrame.getEmpTable().getSelectedRowCount();
        if (rowCount!=1){
            JOptionPane.showMessageDialog(null,"请选中其中一行！","提示",JOptionPane.WARNING_MESSAGE);
        }else {
            //获取当前行的编号
            int selectedRow = EmpFrame.getEmpTable().getSelectedRow();
            //用当前行编号拿到第一列的数据
            int id = (int) EmpFrame.getEmpTable().getValueAt(selectedRow, 0);

            //把id给EmpService的getById方法，拿到选中的整个行的数据
            EmpService empService = new EmpServiceImpl();
            Employee employee = empService.getById(id);

            //new出新窗口，将选中行数据传给新窗口
            new EmpUpdateFrame(employee);
        }
    }
}
