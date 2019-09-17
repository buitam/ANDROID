package com.t3h.gui;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class MyFrame extends JFrame implements WindowListener {
    //WindowListener các sự kiện cho ng dùng
    public static final int W_FRAME = 800;
    public static final int H_FRAME = 600;

    public MyFrame(){
        setTitle("buoi 10");
        setSize(W_FRAME,H_FRAME);
        //setLocation(10,10);
        setLocationRelativeTo(null);// ở giữ màn hình
        setResizable(false); // không cho phép thay đổi kích thước
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE); // set cách thức để đóng, có 4 cờ
        //DISPOSE_ON_CLOSE: kiểm tra ctr có mấy freme, chỉ đóng ctr khi frame cuối tắt đi
        //EXIT_ON_CLOSE: tắt 1 frame là tắt toàn bộ
        addWindowListener(this);//truyền this(window listener), tính đa hình
        MyPanel myPanel = new MyPanel();
        add(myPanel);
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

        int result = JOptionPane.showConfirmDialog(null,"Bạn có muốn thuát không? ",
                "Exit app", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
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
