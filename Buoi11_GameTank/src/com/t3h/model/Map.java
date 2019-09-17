package com.t3h.model;

import com.t3h.utils.ImageLoader;

import javax.swing.*;
import java.awt.*;

public class Map {
    public int x;
    public int y;
    public int bit;
    Image[] img = {
            ImageLoader.getImage("den.png",getClass()),
            ImageLoader.getImage("brick.png",getClass()),
            ImageLoader.getImage("rock.png",getClass()),
            ImageLoader.getImage("tree.png",getClass()),
            ImageLoader.getImage("bird.png",getClass()),
            ImageLoader.getImage("water.png",getClass()),
    };

    public Map(int x, int y, int bit) {
        this.x = x;
        this.y = y;
        this.bit = bit;
    }

    void draw(Graphics2D g2d){
        g2d.drawImage(img[bit],x,y,null);
    }
}
