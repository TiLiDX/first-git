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
    private Object[][] data;//���������
    private String[] columnNames = {"���","����","����","����"};

    private EmpTableModel(){}

    private static class EmpTableModelHolder{
        private static final EmpTableModel INSTANCE = new EmpTableModel();
    }

    public static EmpTableModel getInstance(){
        return EmpTableModelHolder.INSTANCE;
    }

    @Override
    public int getRowCount() {//��ȡ�ж�����
        return data.length;
    }

    @Override
    public int getColumnCount() {//��ȡ�ж�����
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {//��ȡ��Ӧ�кź��кŶ�Ӧ������
        return data[rowIndex][columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /**
     * ��listתΪ��ά���飨ԭ������Ϊ�����ڻ�ȡֵ��ʱ����Ҫ �кź��к� ���úͶ�ά�����ж�Ӧ�����Ծͽ���ת��Ϊ��ά���飩
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
