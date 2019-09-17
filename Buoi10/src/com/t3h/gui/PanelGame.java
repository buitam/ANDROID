package com.t3h.gui;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;

public class PanelGame extends JPanel {
    public PanelGame() {
        setBackground(Color.BLUE);
       /* setLocation(500, 100);
        setSize(201,100);*/
       setBounds(MyFrame.W_FRAME/3,0,MyFrame.W_FRAME/3 * 2,MyFrame.H_FRAME);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g; //ép kiểu graphic về Graphics2D
        super.paintComponent(g2d);
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        );
        g2d.setColor(Color.white);
        g2d.setStroke(new BasicStroke(30)); //đổi kích thước cho nét vẽ hình học
        g2d.drawOval(200,200,100,100);
        g2d.drawLine(0,0,500,500);
        g2d.setFont(new Font("Edwardian Script ITC",Font.BOLD,24));
        g2d.drawString("hello World", 100,300);
    }
}
