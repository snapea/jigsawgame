package com.snap.ui;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    public LoginJFrame () {
        this.setSize(488, 430);
        this.setTitle("拼图 登录");
        this.setAlwaysOnTop(true);

        this.setLocationRelativeTo(null);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
}
