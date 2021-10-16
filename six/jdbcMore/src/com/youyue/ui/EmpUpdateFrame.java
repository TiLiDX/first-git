package com.youyue.ui;

import com.youyue.model.Dept;
import com.youyue.model.Employee;
import com.youyue.service.EmpService;
import com.youyue.service.impl.EmpServiceImpl;
import com.youyue.ui.listener.EmpUpdateListener;

import javax.swing.*;
import java.util.Vector;

public class EmpUpdateFrame extends JFrame {

    private JTextField idText;
    private JTextField nameText;
    private JTextField jobText;
    private JTextField salText;

    private JComboBox<Dept> qname;
    public EmpUpdateFrame(Employee employee) {
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

        JLabel dnameLabel = new JLabel("部门:");
        dnameLabel.setBounds(100,220,50,20);

        EmpService empService = new EmpServiceImpl();
        Vector<Dept> dept = empService.queryDept();

        qname = new JComboBox<>(dept);
        qname.setBounds(150,220,120,20);
        qname.setSelectedItem(employee.getDept());

        JButton saveButton = new JButton("保存");
        saveButton.setBounds(170,270,70,35);
        saveButton.addActionListener(new EmpUpdateListener(this));

        this.setLocationRelativeTo(null);
        this.add(idLabel);
        this.add(nameLabel);
        this.add(jobLabel);
        this.add(salLabel);

        this.add(dnameLabel);
        this.add(qname);

        this.add(idText);
        this.add(nameText);
        this.add(jobText);
        this.add(salText);

        this.add(saveButton);
        this.setVisible(true);
    }

    public JTextField getIdText() {
        return idText;
    }

    public void setIdText(JTextField idText) {
        this.idText = idText;
    }

    public JTextField getNameText() {
        return nameText;
    }

    public void setNameText(JTextField nameText) {
        this.nameText = nameText;
    }

    public JTextField getJobText() {
        return jobText;
    }

    public void setJobText(JTextField jobText) {
        this.jobText = jobText;
    }

    public JTextField getSalText() {
        return salText;
    }

    public void setSalText(JTextField salText) {
        this.salText = salText;
    }

    public JComboBox<Dept> getDept() {
        return qname;
    }

    public void setDept(JComboBox<Dept> qname) {
        this.qname = qname;
    }
}
