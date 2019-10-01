package com.t3h.gui;

import com.t3h.model.ImageLoader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuButton extends JButton implements MouseListener {
    private Image imSelect;
    private Image imNone;
    public MenuButton(String none, String select) {
        imNone = ImageLoader.getImage(none, getClass());
        imSelect = ImageLoader.getImage(select, getClass());
        setSize(
                imNone.getWidth(null)-50,
                imNone.getHeight(null) -50
        );
        setIcon(new ImageIcon(imNone));
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
        setIcon(new ImageIcon(imSelect));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setIcon(new ImageIcon(imNone));
    }
}
