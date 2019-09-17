package com.t3h.bai2;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Layout extends JPanel{
    public Layout2 layout2 = new Layout2();
    public Layout1 layout1 = new Layout1();
    public Layout() {
        setLayout(null);
        add(layout1);
       //add(layout2);
    }

/*    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_ENTER) {
            add(layout1);
        } else if(e.getKeyCode() == 37){
            add(layout2);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }*/
}
