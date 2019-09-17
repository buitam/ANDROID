package com.t3h.gui;

import javax.swing.*;
import java.awt.*;

public class ZombieFrame extends JFrame {
    public static final int W_FRAME = 1120;
    public static final int H_FRAME = 630;

    public ZombieFrame() {
        setTitle("Plants and Zombies Game");
        setSize(W_FRAME,H_FRAME);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ZombiePanel zombiePanel = new ZombiePanel();
        add(zombiePanel);
    }
}
