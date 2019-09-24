package com.t3h.model;

import com.t3h.gui.ZombieFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class Map extends JPanel implements MouseMotionListener {
    Image image = ImageLoader.getImage("backyard.jpg",getClass());
    Image counter = ImageLoader.getImage("Counter.png",getClass());
    Image shovel = ImageLoader.getImage("shovel.png",getClass());
    Image plants [] = {ImageLoader.getImage("active_sunflower.png",getClass()),
            ImageLoader.getImage("active_walnut.png",getClass()),
            ImageLoader.getImage("active_peashooter.png",getClass()),
            ImageLoader.getImage("active_beetroot.png",getClass()),
    };

    public void lawnMowerMove(){

    }

    void draw(Graphics2D g2d){
        g2d.drawImage(image, 0, 0,null);
        for (int i = 0; i <plants.length ; i++) {
            g2d.drawImage(plants[i],0,ZombieFrame.H_FRAME/6*(i+1)-10*(i+1),null);
        }
        g2d.drawImage(counter,7,ZombieFrame.H_FRAME/9,null);
        g2d.drawImage(counter,7,ZombieFrame.H_FRAME/9*8,null);
        g2d.drawImage(shovel,ZombieFrame.W_FRAME/11*10,0,null);

    }

    public Map() {
        addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        g.clearRect(0,0,ZombieFrame.W_FRAME, ZombieFrame.H_FRAME);
        g.drawImage(shovel,e.getX(), e.getY(),null);
        for (int i = 0; i < plants.length; i++) {
            if(e.getY()<shovel.getHeight(null) && e.getX()>ZombieFrame.W_FRAME-shovel.getWidth(null)){
                g.clearRect(0,0,400, 400);
                g.drawImage(shovel,e.getX(), e.getY(),null);
            } else if(e.getY()<ZombieFrame.H_FRAME/6*(i+1)-10*(i+1) && e.getX()< plants[i].getWidth(null)){
                g.clearRect(0,0,400, 400);
                g.drawImage(plants[i],e.getX(), e.getY(),null);}
            }
        }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
