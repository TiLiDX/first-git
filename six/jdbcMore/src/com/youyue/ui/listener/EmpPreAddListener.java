package com.youyue.ui.listener;

import com.youyue.ui.EmpAddFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmpPreAddListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        new EmpAddFrame();
    }
}
