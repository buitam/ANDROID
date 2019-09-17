package com.t3h.bai1Frame;

import java.awt.*;

public class MyPanel extends javax.swing.JPanel {
    public MyPanel() {
         MenuPanel menuPanel = new MenuPanel();
         PlayGame playGame = new PlayGame();
         setLayout(null);
         setBackground(Color.BLACK);
         add(menuPanel);
         add(playGame);
    }
}
