package com.t3h.gui;

import javax.swing.*;

public class MenuFrame extends JFrame {
    public MenuFrame() {
        setSize(ZombieFrame.W_FRAME, ZombieFrame.H_FRAME);
        setTitle("Plants and Zombies");
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        MenuPanel panel = new MenuPanel();
        setLocationRelativeTo(null);
        add(panel);
    }
}
