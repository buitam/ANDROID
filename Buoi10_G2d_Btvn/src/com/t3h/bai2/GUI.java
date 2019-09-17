package com.t3h.bai2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GUI extends JFrame  {
    public static final int W_FRAME = 600;
    public static final int H_FRAME = 600;
    public GUI() {
        setSize(W_FRAME,H_FRAME);
        setResizable(false);
        setLocationRelativeTo(null);
        Layout layout = new Layout();
        add(layout);
    }

}
