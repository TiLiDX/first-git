package com.youyue.jdbc03end.ui;

import com.youyue.jdbc03end.model.Employee;
import com.youyue.jdbc03end.ui.listener.EmpUpdateListener;

import javax.swing.*;
import java.awt.*;

public class EmpUpdateFrame extends Frame {
    private JTextField idText;
    private JTextField nameText;
    private JTextField jobText;
    private JTextField salText;
    public EmpUpdateFrame(Employee employee){
        this.setLayout(null);
        this.setSize(800,500);

        JLabel idLabel = new JLabel("编号:");
        idLabel.setBounds(100,100,50,20);
        idText = new JTextField(employee.getEmpno()+"");
        idText.setEditable(false);
        idText.setBounds(150,100,120,20);

        JLabel nameLabel = new JLabel("姓名:");
        nameLabel.setBounds(100,130,50,20);
        nameText = new JTextField(employee.getEname());
        nameText.setBounds(150,130,120,20);

        JLabel jobLabel = new JLabel("工作:");
        jobLabel.setBounds(100,160,50,20);
        jobText = new JTextField(employee.getJob());
        jobText.setBounds(150,160,120,20);

        JLabel salLabel = new JLabel("工资:");
        salLabel.setBounds(100,190,50,20);
        salText = new JTextField(employee.getSal()+"");
        salText.setBounds(150,190,120,20);

        JButton saveButton = new JButton("保存");
        saveButton.setBounds(170,220,70,35);
        saveButton.addActionListener(new EmpUpdateListener(this));

        this.setLocationRelativeTo(null);
        this.add(idLabel);
        this.add(nameLabel);
        this.add(jobLabel);
        this.add(salLabel);

        this.add(idText);
        this.add(nameText);
        this.add(jobText);
        this.add(salText);

        this.add(saveButton);
        this.setVisible(true);
    }
//    public static void main(String[] args) {
//        new EmpUpdateFrame();
//    }

    public JTextField getIdText() {
        return idText;
    }

    public JTextField getNameText() {
        return nameText;
    }

    public JTextField getJobText() {
        return jobText;
    }

    public JTextField getSalText() {
        return salText;
    }
}
