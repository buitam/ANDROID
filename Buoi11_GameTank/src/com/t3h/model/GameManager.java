package com.t3h.model;

import com.t3h.gui.TankFrame;

import java.awt.*;
import java.util.ArrayList;

public class GameManager {
    private Player player;
    private ArrayList<Map> arrMap;
    private ArrayList<Boss> arrBoss;
    private ArrayList<Bullet> arrBulletPlayer;
    private ArrayList<Bullet> arrBulletBoss;
    int [][] arr = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},
            {0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},
            {0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},
            {0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},
            {0,0,5,5,0,0,3,3,0,0,1,1,2,2,1,1,0,0,3,3,0,0,5,5,0,0},
            {0,0,5,5,0,0,3,3,0,0,1,1,2,2,1,1,0,0,3,3,0,0,5,5,0,0},
            {0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},
            {0,0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,1,0,0},
            {0,0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,0,0},
            {2,2,0,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,0,2,2},
            {0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0},
            {0,0,1,1,0,0,1,1,0,0,1,1,1,1,1,1,0,0,1,1,0,0,1,1,0,0},
            {0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0,1,1,0,0},
            {0,0,5,5,0,0,3,3,0,0,1,1,2,2,1,1,0,0,3,3,0,0,5,5,0,0},
            {0,0,5,5,0,0,3,3,0,0,1,1,2,2,1,1,0,0,3,3,0,0,5,5,0,0},
            {0,0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,1,0,0},
            {0,0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0,1,1,0,0,1,1,0,0},
            {0,0,1,1,0,0,1,1,0,0,0,1,1,1,1,0,0,0,1,1,0,0,1,1,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,1,4,4,1,0,0,0,0,0,0,0,0,0,0,0},
            {0,0,0,0,0,0,0,0,0,0,0,1,4,4,1,0,0,0,0,0,0,0,0,0,0,0}
    };
    public void initGame(){
        player = new Player(200,200,3);
        arrBoss = new ArrayList<>();
        arrBulletBoss = new ArrayList<>();
        arrBulletPlayer = new ArrayList<>();
        generateBoss();
        readMap();
    }
    void readMap(){
        arrMap = new ArrayList<Map>(); // x=jx W, y= ixH ;
        for(int i=0; i<arr.length;i++){
            for(int j=0; j<arr[i].length;j++){
                int x= 20 * j;
                int y= 20 * i;
                int bit = arr[i][j];
                arrMap.add(new Map(x,y,bit));
            }
        }
    }

    public void generateBoss(){
        Boss boss = new Boss(0,0);
        arrBoss.add(boss);
        Boss boss1 = new Boss(TankFrame.W_FRAME/2 -16, 0);
        arrBoss.add(boss1);
        Boss boss2 = new Boss(TankFrame.W_FRAME - 50, 0);
        arrBoss.add(boss2);
    }

    public void draw(Graphics2D g2d){
            for (Map m:arrMap) {
                m.draw(g2d);
            }

        drawBullet(g2d,arrBulletBoss);
        drawBullet(g2d,arrBulletPlayer);
        for (Boss b:arrBoss
             ) {
            b.draw(g2d);

        }
        player.draw(g2d);
    }

    private void drawBullet(Graphics2D g2d, ArrayList<Bullet> arr) {
        for (Bullet b: arr) {
            b.draw(g2d);
        }
    }

    public void playerMove(int newOrient) {
        player.changeOrient(newOrient);
        player.move();
    }

    public void playerFire(){
        player.fire(arrBulletPlayer);
    }

    public boolean AI() {
        //generateBoss(); hết thời gian thì sinh ra boss mới
        //xử lý hđ tự động
        for (int i =  arrBoss.size() - 1; i >= 0; i--) {
            arrBoss.get(i).generateOrient();
            arrBoss.get(i).move();
            arrBoss.get(i).fire(arrBulletBoss);
            boolean die = arrBoss.get(i).checkDie(arrBulletPlayer);
            if(die) {
                arrBoss.remove(i);
                if(arrBoss.size()<=2){
                    generateBoss();
                }
            }
        }
        moveBullet(arrBulletPlayer);
        moveBullet(arrBulletBoss);
        return player.checkDie(arrBulletBoss);
    }

    private void moveBullet(ArrayList<Bullet> arr){
        for (int i = arr.size()-1; i >=0 ; i--) {
            System.out.println(arr.size());
            boolean move = arr.get(i).move();
            if(move == false){
                arr.remove(i);
            }
        }
    }
}
