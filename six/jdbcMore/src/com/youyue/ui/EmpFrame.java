package com.youyue.ui;

import com.youyue.model.Employee;
import com.youyue.service.EmpService;
import com.youyue.service.impl.EmpServiceImpl;
import com.youyue.ui.listener.EmpPreAddListener;
import com.youyue.ui.listener.EmpPreUpdateListener;
import com.youyue.ui.listener.EmpRefreshListener;
import com.youyue.ui.tablemodel.EmpTableModel;

import javax.swing.*;
import java.util.List;

public class EmpFrame {
    private static JTable empTable;

    private JTextField idText;
    private JTextField nameText;
    private JTextField minText;
    private JTextField maxText;
    public static void main(String[] args){
        new EmpFrame().frame();
    }
    public void frame(){
        JFrame empFrame = new JFrame();
        empFrame.setSize(800,500);
        empFrame.setLayout(null);

        EmpService empService = new EmpServiceImpl();
        List<Employee> emps = empService.queryAll();

        EmpTableModel empTableModel = EmpTableModel.getInstance();
        empTableModel.setData(emps);

        empTable = new JTable(empTableModel);
        empTable.setBounds(0,0,800,300);
        JScrollPane scrollPane = new JScrollPane(empTable);
        scrollPane.setBounds(0,0,800,300);

        JButton addButton = new JButton("添加");
        addButton.setBounds(100,310,70,35);
        addButton.addActionListener(new EmpPreAddListener());

        JButton updateButton = new JButton("修改");
        updateButton.setBounds(300,310,70,35);
        updateButton.addActionListener(new EmpPreUpdateListener());

        JButton deleteButton = new JButton("删除");
        deleteButton.setBounds(500,310,70,35);
        //deleteButton.addActionListener(new EmpDeleteListener());

        JButton batchDeleteButton = new JButton("批量删除");
        batchDeleteButton.setBounds(580,310,70,35);
        //batchDeleteButton.addActionListener(new EmpBatchDeleteListener());

        JButton queryButton = new JButton("查询");
        queryButton.setBounds(100,370,70,35);
        //queryButton.addActionListener(new EmpQueryListener(this));

        JLabel idLabel = new JLabel("empno:");
        idLabel.setBounds(200,375,80,25);
        idText = new JTextField();
        idText.setBounds(250,375,80,25);
        JLabel nameLabel = new JLabel("ename:");
        nameLabel.setBounds(350,375,80,25);
        nameText = new JTextField();
        nameText.setBounds(400,375,80,25);
        JLabel salLabel = new JLabel("sal:");
        salLabel.setBounds(200,425,80,25);
        minText = new JTextField();
        minText.setBounds(250,420,80,25);
        maxText = new JTextField();
        maxText.setBounds(400,420,80,25);

        JButton refreshButton = new JButton("刷新");
        refreshButton.setBounds(700,310,70,35);
        refreshButton.addActionListener(new EmpRefreshListener());


        empFrame.add(nameLabel);
        empFrame.add(nameText);
        empFrame.add(salLabel);
        empFrame.add(minText);
        empFrame.add(maxText);

        empFrame.add(scrollPane);
        empFrame.add(addButton);
        empFrame.add(updateButton);
        empFrame.add(deleteButton);
        empFrame.add(batchDeleteButton);
        empFrame.add(queryButton);
        empFrame.add(idLabel);
        empFrame.add(idText);
        empFrame.add(refreshButton);
        empFrame.setLocationRelativeTo(null);
        empFrame.setVisible(true);
    }
    public static JTable getEmpTable(){
        return empTable;
    }

    public JTextField getIdText() {
        return idText;
    }

    public JTextField getNameText() {
        return nameText;
    }

    public JTextField getMinText() {
        return minText;
    }

    public JTextField getMaxText() {
        return maxText;
    }
}
