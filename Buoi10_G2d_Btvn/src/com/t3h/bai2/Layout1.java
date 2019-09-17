package com.t3h.bai2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Layout1 extends JPanel implements  MouseListener {

    public Layout1() {
        setBounds(0,0,GUI.W_FRAME, GUI.H_FRAME);
        setBackground(Color.BLACK);
        addMouseListener(this);
        //addKeyListener(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
    Graphics2D g2d = (Graphics2D) g;
        super.paintComponent(g2d);

        int x = GUI.W_FRAME/4,y = GUI.H_FRAME/12,w = GUI.W_FRAME/8,h = GUI.H_FRAME/15;
        Color arr[] = {Color.RED, Color.yellow, Color.green, Color.gray, Color.pink,Color.ORANGE, Color.WHITE};
        String name[] = {"ĐỎ","VÀNG","XANH","XÁM","HỒNG","CAM","TRẮNG" };
        for (int i = 0; i < 3; i++) {
            g2d.setColor(arr[i]);
            g2d.fillRect(x,y,w,h);
            g2d.setColor(Color.BLACK);
            g2d.drawString(name[i], x+20,y +20);
            x = x+w;
            y = y + h;
        }
        for (int i = 3; i <7 ; i++) {
            g2d.setColor(arr[i]);
            g2d.fillRect(x,y,w,h);
            g2d.setColor(Color.BLACK);
            g2d.drawString(name[i], x+20,y + 20);
            x = x-w;
            y = y + h;

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        setBackground(Color.LIGHT_GRAY);

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(Color.WHITE);

    }

    @Override
    public void mouseExited(MouseEvent e) {
    setBackground(Color.BLACK);
    }

/*    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            setBackground(Color.GREEN);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }*/
}
