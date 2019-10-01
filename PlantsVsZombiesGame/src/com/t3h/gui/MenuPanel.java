package com.t3h.gui;

import com.t3h.model.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel  extends JPanel implements ActionListener {
    private MenuButton btnOk;
    private MenuButton btnExit;
    private Image bg = ImageLoader.getImage("first_screen.jpg", getClass());

    public MenuPanel() {
        setLayout(null);
        initComponents();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        g2d.drawImage(bg, 0, 0,
                ZombieFrame.W_FRAME, ZombieFrame.H_FRAME, null);
    }

    private void initComponents() {
        btnOk = new MenuButton("click_to_start.gif", "click_to_start.gif");
        int x = ZombieFrame.W_FRAME - btnOk.getWidth();
        x = x / 2;
        btnOk.setLocation(x+20, 450);
        add(btnOk);
        btnOk.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource().equals(btnOk)) {
            ZombieFrame frame = new ZombieFrame();
            frame.setVisible(true);
            SwingUtilities.getWindowAncestor(this).dispose();
        }else {
            System.exit(0);
        }
    }
}
