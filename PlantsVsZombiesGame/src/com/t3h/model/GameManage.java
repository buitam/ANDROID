package com.t3h.model;

import com.t3h.gui.ZombieFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;

public class GameManage  {
    public int housePlace = ZombieFrame.W_FRAME/7*2;
    private Map map = new Map();
    private Score score = new Score(40,ZombieFrame.H_FRAME/9*8+20);
    private Score scorePlay = new Score(40,90);
    private ArrayList<LawnMower> arrLawnMowers;
    public ArrayList<Plants> arrPlants;
    public ArrayList<Potatoes> arrPotaoes;
    public ArrayList<RedTree> arrRedTree;
    public ArrayList<SunTree> arrSunTree;
    private ArrayList<Zombies> arrZombies;
    public ArrayList<SunFlower> arrSunFlowers;
    private ArrayList<Bullet> arrBullet;
    private Random rd = new Random();

    public void initGame(){
        SoundManage.play("background.wav");
        arrZombies = new ArrayList<>();
        arrSunFlowers = new ArrayList<>();
        arrLawnMowers = new ArrayList<>();
        arrBullet = new ArrayList<>();
        arrPlants = new ArrayList<>();
        arrPotaoes = new ArrayList<>();
        arrRedTree = new ArrayList<>();
        arrSunTree = new ArrayList<>();
        generateZombie();
        generateLawnMower();
        generatePlants();
    }

    public void generateZombie(){
        int placeRd = 0;
        int arrRd[] = {0,ZombieFrame.H_FRAME/5-30,ZombieFrame.H_FRAME/5*2-30,ZombieFrame.H_FRAME/5*3-55,ZombieFrame.H_FRAME/5*4-70 };
        for (int i = 0; i <arrRd.length ; i++) {
            placeRd = arrRd[rd.nextInt(5)];
        }
        Zombies zombies = new Zombies(ZombieFrame.W_FRAME + 50,placeRd);
        arrZombies.add(zombies);
    }
    public void generatePlants(){
        Plants plants = new Plants(0,ZombieFrame.H_FRAME/6-10,2);
        arrPlants.add(plants);
        Potatoes potatoes = new Potatoes(0,ZombieFrame.H_FRAME/6*2-10*2,2);
        arrPotaoes.add(potatoes);
        RedTree redTree = new RedTree(0,ZombieFrame.H_FRAME/6*3-10*3,2);
        arrRedTree.add(redTree);
        SunTree sunTree = new SunTree(0,ZombieFrame.H_FRAME/6*4-10*4,2);
        arrSunTree.add(sunTree);

    }

    public void generateSunFlower(){
        int xSunRd = housePlace + rd.nextInt(800);
        SunFlower sunFlower = new SunFlower(xSunRd,0);
        arrSunFlowers.add(sunFlower);
    }

    public void generateLawnMower(){
        int x;
        int y;
        for (int i = 0; i < 5; i++) {
             x = ZombieFrame.W_FRAME/6 + 20 + (-5*i);
             y = 100*(i+1)-50;
            LawnMower lawnMower = new LawnMower(x,y);
            arrLawnMowers.add(lawnMower);
        }
    }

    public void moveLawn() {
        for (int i = arrLawnMowers.size()-1; i >=0 ; i--) {
            arrLawnMowers.get(i).moveLawn();
            if(arrLawnMowers.get(i).x >= ZombieFrame.W_FRAME) {
                arrLawnMowers.remove(i);
            }
        }

    }

    public void draw(Graphics2D g2d){
        map.draw(g2d);
        score.draw(g2d);
        scorePlay.draw(g2d);


        for (Potatoes z: arrPotaoes
        ) {
            z.draw(g2d);
        }

        for (RedTree z: arrRedTree
        ) {
            z.draw(g2d);
        }

        for (SunTree z: arrSunTree
        ) {
            z.draw(g2d);
        }

        for (SunFlower s: arrSunFlowers
             ) {
            s.draw(g2d);
        }

        for (LawnMower l:arrLawnMowers
             ) {
            l.draw(g2d);
        }

        for (Plants p: arrPlants
             ) {
            p.draw(g2d);

        }
        for (Bullet b: arrBullet) {
            b.draw(g2d);
        }
        for (Zombies z: arrZombies
        ) {
            z.draw(g2d);
        }
    }

    private long t;
    private long time;
    public void AIZombies() {
        long T = System.currentTimeMillis();
        for (int i = arrZombies.size() - 1; i >= 0; i--) {
            arrZombies.get(i).move();
            boolean die = arrZombies.get(i).checkDie(arrBullet);
            if (die) {
                if(PlantsVsZombies.health < 0){
                arrZombies.remove(i);
                }
            }
        }
        if(T-t < 5000) {
            return;
        }
        t = T;
        generateZombie();
    }

    public void AIFlowers() {
        long T = System.currentTimeMillis();
        for (int i = arrSunFlowers.size() - 1; i >= 0; i--) {
            arrSunFlowers.get(i).move();
            if(T-time >= 13000) {
                arrSunFlowers.remove(i);
            }
        }
        if(T-time < 14000) {
            return;
        }

        time = T;
        generateSunFlower();
    }
    public void AIBullet(){
        for (int i = arrPlants.size() - 1; i >= 1; i--) {
            arrPlants.get(i).fire(arrBullet,0);
        }

        for (int i = arrRedTree.size() - 1; i >= 1; i--) {
            arrRedTree.get(i).fire(arrBullet,1);
        }

        moveBullet();
    }

    public void moveBullet(){
        for (int i = arrBullet.size()-1; i >=0 ; i--) {
            boolean move = arrBullet.get(i).move();
            if(move == false){
                arrBullet.remove(i);
            }
        }
    }

    public boolean gameOver(){
        for (int i = 0; i < arrZombies.size(); i++) {
            if(arrZombies.get(i).x <= ZombieFrame.W_FRAME/6){
                moveLawn();
                return true;
            }
        }
        return false;
    }



}
