package com.t3h.gui;

import com.t3h.model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class ZombiePanel extends JPanel implements Runnable, MouseListener, MouseMotionListener {
    private GameManage gameManage = new GameManage();
    private Map map = new Map();
    public ZombiePanel() {
        setBackground(Color.BLACK);
        gameManage.initGame();
        addMouseListener(this);
        addMouseMotionListener(this);
        Thread t = new Thread(this);//this chính là runable(dùng định nghĩa công việc cho thread xử lý)
        t.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        super.paintComponent(g2d);
        gameManage.draw(g2d);

    }
    @Override
    public void run() {
        while (true) {
            gameManage.AIZombies();
            gameManage.AIFlowers();
            gameManage.moveBullet();
            gameManage.AIBullet();
            boolean isDie = gameManage.gameOver();
            if(isDie){
                int result = JOptionPane.showConfirmDialog(null,
                        "Do you replay?","Game Over",
                        JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if(result == JOptionPane.YES_OPTION){
                    gameManage.initGame();
                } else {
                    System.exit(0);
                }
            }
            repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Rectangle rect = new Rectangle(e.getX()-15, e.getY()-15, 20, 20);
        for (int i = 0; i <gameManage.arrSunFlowers.size() ; i++) {
            Rectangle rect1 = gameManage.arrSunFlowers.get(i).getRect()
                    .intersection(rect);
            if(!rect1.isEmpty()){
                Score.score+= 50;
                gameManage.arrSunFlowers.remove(i);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        Graphics2D g2d = (Graphics2D) g;
        for (int i = 0; i < map.plants.length; i++) {
            if(e.getY()<map.shovel.getHeight(null) && e.getX()>ZombieFrame.W_FRAME/11*10){
                g2d.clearRect(ZombieFrame.W_FRAME,ZombieFrame.H_FRAME,ZombieFrame.W_FRAME, ZombieFrame.H_FRAME);
                g2d.drawImage(map.shovel,e.getX(), e.getY(),null);
            } else if(e.getY()<ZombieFrame.H_FRAME/6*(i+1)-10*(i+1) && e.getX()< map.plants[i].getWidth(null)){
                g2d.clearRect(ZombieFrame.W_FRAME,ZombieFrame.H_FRAME,ZombieFrame.W_FRAME, ZombieFrame.H_FRAME);
                g2d.drawImage(map.plants[i],e.getX(), e.getY(),null);}
//            System.out.println("X: " + e.getX() + "\nY:"+ e.getY());
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
