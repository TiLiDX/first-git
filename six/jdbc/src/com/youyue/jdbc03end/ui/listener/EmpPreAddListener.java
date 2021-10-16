package com.youyue.jdbc03end.ui.listener;

import com.youyue.jdbc03end.ui.EmpAddFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpPreAddListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new EmpAddFrame();
    }
}
