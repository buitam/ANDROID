package com.t3h.bai2;

import javax.swing.*;
import java.awt.*;

public class Layout2 extends JPanel {
    public Layout2() {
        setBounds(0,0,GUI.W_FRAME,GUI.H_FRAME);
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);
        int x = 0,y = GUI.H_FRAME/6,w = GUI.W_FRAME/5,h = GUI.H_FRAME/5;
        Color arr[] = {Color.RED, Color.yellow, Color.green, Color.gray, Color.pink,Color.ORANGE, Color.orange,Color.GREEN,Color.PINK};
        String name[] = {"ĐỎ","VÀNG","XANH","XÁM","HỒNG","CAM","CAM","XANH","HỒNG" };
        for (int i = 0; i < 9; i++) {
            if(i < 3 ) {
                    g2d.setColor(arr[i]);
                    g2d.fillRect(0,y*i*2,w,h);
                    g2d.setColor(Color.BLACK);
                    g2d.drawString(name[i], x+30,y*i*2 +40);
            }

            if(i < 6 ){
                g2d.setColor(arr[i]);
                g2d.fillRect(GUI.H_FRAME/5*2,y*(i-3)*2,w,h);
                g2d.setColor(Color.BLACK);
                g2d.drawString(name[i], GUI.H_FRAME/5*2+30,y*(i-3)*2 +40);
            }

            if(i < 9) {
                g2d.setColor(arr[i]);
                g2d.fillRect(GUI.H_FRAME/5*4,y*(i-6)*2,w,h);
                g2d.setColor(Color.BLACK);
                g2d.drawString(name[i], GUI.H_FRAME/5*4+30,y*(i-6)*2 +40);
            }
        }
    }
}
