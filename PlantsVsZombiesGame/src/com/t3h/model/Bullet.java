package com.t3h.model;

import com.t3h.gui.ZombieFrame;

import java.awt.*;
import java.util.ArrayList;

public class Bullet {
    private int x;
    private int y;
    private int status;

    private Image[] images;

    public Bullet(int x, int y, int status) {
        this.x = x + 15;
        images = new Image[2];
        this.status = status;
        images[0] = ImageLoader.getImage("Pea.png", getClass());
        images[1] = ImageLoader.getImage("beetbullet.png", getClass());
        this.y = y - images[status].getHeight(null)/2-10;
    }
    public void draw(Graphics2D g2d){
        g2d.drawImage(images[status],x,y,null);
    }
    public boolean move(){
        x += 2;
        if(x>= ZombieFrame.W_FRAME){
            return false;
        }
        return true;
    }

    public Rectangle getRect(){
        Rectangle rect = new Rectangle(x,y,images[status].getWidth(null), images[status].getHeight(null));
        return rect;
    }

}
