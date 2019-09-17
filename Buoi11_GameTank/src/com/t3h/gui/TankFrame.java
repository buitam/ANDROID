package com.t3h.gui;

import javax.swing.*;

public class TankFrame extends JFrame {
    public static final int W_FRAME = 520;
    public static final int H_FRAME = 550;
    public TankFrame(){
        setTitle("Game Tank");
        setSize(W_FRAME,H_FRAME);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        TankPanel tankPanel = new TankPanel();
        add(tankPanel);
    }

}
