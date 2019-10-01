package com.t3h.model;

import java.awt.*;
import java.util.ArrayList;

public class PlantsVsZombies {
    public static int health = 100;
    public static final int LIVE = 0;
    public static final int DIE = 1;
    public static final int ACTIVE = 2;

    protected int x;
    protected int y;
    protected Image[] images;
    protected int status;


    public PlantsVsZombies(int x, int y, int status) {
        this.x = x;
        this.y = y;
        this.status = status;
    }

    private long t;

    public void fire(ArrayList<Bullet> arr, int status){
        long T = System.currentTimeMillis();
        if(T-t < 4000 ) {
            return;
        }
        t = T;
        // t : thời gian cuối cùng, T: thời gian hiện tại
        int xB = x + images[LIVE].getWidth(null)/2;
        int yB = y + images[LIVE].getWidth(null)/2;
        if(status == 0){
            Bullet b = new Bullet(xB, yB,0);
            arr.add(b);
        } else{
        Bullet bulletRed = new Bullet(xB, yB+40,1);
        arr.add(bulletRed);}
    }

    public Rectangle getRect() {
        Rectangle rect = new Rectangle(x, y,
                images[status].getWidth(null),
                images[status].getHeight(null));
        return rect;
    }

    public void checkDiePlant(ArrayList<Zombies> arr){
        for (int i = 0; i < arr.size() ; i++) {
            Rectangle rect = getRect().intersection(arr.get(i).getRect());
            //intersection là kiểm tra giao nhau giữa 2 hcn, giá trị trả về là 1 rectangle
            if(!rect.isEmpty()){
                PlantsVsZombies.health -= 30;
                arr.remove(i);
            }
        }
    }
    public void draw(Graphics2D g2d){
        g2d.drawImage(images[status],x,y,null);
    }
}
