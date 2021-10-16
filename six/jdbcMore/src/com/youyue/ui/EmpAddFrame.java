package com.youyue.ui;

import com.youyue.model.Dept;
import com.youyue.service.EmpService;
import com.youyue.service.impl.EmpServiceImpl;
import com.youyue.ui.listener.EmpAddListener;

import javax.swing.*;
import java.util.Vector;

public class EmpAddFrame extends JFrame {
    private JTextField idText;
    private JTextField nameText;
    private JTextField jobText;
    private JTextField salText;
    private JComboBox<Dept> qname;
    public EmpAddFrame(){
        this.setLayout(null);
        this.setSize(800,500);

        JLabel idLabel = new JLabel("编号:");
        idLabel.setBounds(100,100,50,20);
        idText = new JTextField();
        idText.setBounds(150,100,120,20);

        JLabel nameLabel = new JLabel("姓名:");
        nameLabel.setBounds(100,130,50,20);
        nameText = new JTextField();
        nameText.setBounds(150,130,120,20);

        JLabel jobLabel = new JLabel("工作:");
        jobLabel.setBounds(100,160,50,20);
        jobText = new JTextField();
        jobText.setBounds(150,160,120,20);

        JLabel salLabel = new JLabel("工资:");
        salLabel.setBounds(100,190,50,20);
        salText = new JTextField();
        salText.setBounds(150,190,120,20);

        JLabel dnameLabel = new JLabel("部门:");
        dnameLabel.setBounds(100,220,50,20);

        EmpService empService = new EmpServiceImpl();
        Vector<Dept> dept = empService.queryDept();

        qname = new JComboBox<>(dept);
        qname.setBounds(150,220,120,20);


        JButton saveButton = new JButton("保存");
        saveButton.setBounds(170,270,70,35);
        saveButton.addActionListener(new EmpAddListener(this));

        this.setLocationRelativeTo(null);
        this.add(idLabel);
        this.add(nameLabel);
        this.add(jobLabel);
        this.add(salLabel);
        this.add(dnameLabel);

        this.add(idText);
        this.add(nameText);
        this.add(jobText);
        this.add(salText);
        this.add(qname);

        this.add(saveButton);
        this.setVisible(true);
    }

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

    public JComboBox<Dept> getQname() {
        return qname;
    }

    public void setQname(JComboBox<Dept> qname) {
        this.qname = qname;
    }

    public static void main(String[] args) {
        new EmpAddFrame();
    }
}
