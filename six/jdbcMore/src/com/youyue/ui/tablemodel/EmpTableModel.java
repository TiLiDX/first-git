package com.youyue.ui.tablemodel;

import com.youyue.model.Employee;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class EmpTableModel extends AbstractTableModel {
    private Object[][] data;//当前表格的数据
    private String[] columnNames = { "编号", "姓名", "工种", "工资", "部门" };


    private EmpTableModel() {}

    private static class EmpTableModelHolder {
        private static final EmpTableModel INSTANCE = new EmpTableModel();
    }

    public static EmpTableModel getInstance() {
        return EmpTableModelHolder.INSTANCE;
    }

    /**
     * 有多少行数据
     */
    @Override
    public int getRowCount() {
        return data.length;
    }

    /**
     * 有多少列数据
     */
    @Override
    public int getColumnCount() {
        return columnNames.length;
    }


    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /**
     * 拿到当前单元格的数据
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    public void setData(List<Employee> data) {
        this.data = list2Array(data);
    }

    private Object[][] list2Array(List<Employee> data){
        Object[][] objArray = new Object[data.size()][5];
        for(int i=0;i<data.size();i++) {
            Employee emp = data.get(i);
            objArray[i][0] = emp.getEmpno();
            objArray[i][1] = emp.getEname();
            objArray[i][2] = emp.getJob();
            objArray[i][3] = emp.getSal();
            objArray[i][4] = emp.getDept().getDname();
        }
        return objArray;
    }
}
