package com.t3h.bai1Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class Frame extends JFrame implements WindowListener {
    public static final int W_FRAME = 600;
    public static final int H_FRAME = 600;

    public Frame(){
        setSize(W_FRAME,H_FRAME);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(this);
        MyPanel myPanel = new MyPanel();
        add(myPanel);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

        int result =JOptionPane.showConfirmDialog(null,"Bạn có muốn tắt chương trình?","Tắt chương trình",
                JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if(result == JOptionPane.YES_OPTION){
            System.exit(0);
        }

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
