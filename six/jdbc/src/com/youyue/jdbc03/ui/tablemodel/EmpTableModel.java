package com.youyue.jdbc03.ui.tablemodel;

import com.youyue.jdbc03.model.Employee;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * @author lei_she
 * @version 1.0
 * @create_time 2021-06-05 16:13
 */
public class EmpTableModel extends AbstractTableModel {
    private Object[][] data;//保存的数据
    private String[] columnNames = {"编号","姓名","工种","工资"};

    private EmpTableModel(){}

    private static class EmpTableModelHolder{
        private static final EmpTableModel INSTANCE = new EmpTableModel();
    }

    public static EmpTableModel getInstance(){
        return EmpTableModelHolder.INSTANCE;
    }

    @Override
    public int getRowCount() {//获取有多少行
        return data.length;
    }

    @Override
    public int getColumnCount() {//获取有多少列
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {//获取对应行号和列号对应的数据
        return data[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /**
     * 将list转为二维数组（原因是因为上面在获取值的时候需要 行号和列号 正好和二维数据有对应，所以就将其转换为二维数组）
     * @param emps
     * @return
     */
    private Object[][] list2Array(List<Employee> emps){
        Object[][] obj = new Object[emps.size()][columnNames.length];
        for(int i=0;i<emps.size();i++){
            Employee emp = emps.get(i);
            obj[i][0] = emp.getEmpno();
            obj[i][1] = emp.getEname();
            obj[i][2] = emp.getJob();
            obj[i][3] = emp.getSal();
        }
        return obj;
    }


    public void setEmps(List<Employee> emps) {
        this.data = list2Array(emps);
    }
}
