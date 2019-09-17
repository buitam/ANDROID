package com.t3h.bai1Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class PlayGame extends JPanel implements MouseListener {
    public PlayGame() {
        setBounds(Frame.W_FRAME/2,0,Frame.W_FRAME/2,Frame.H_FRAME);
        setBackground(Color.BLUE);
        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(Color.GREEN);

    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(Color.BLUE);

    }
}
