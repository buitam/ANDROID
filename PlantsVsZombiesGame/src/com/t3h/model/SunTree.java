package com.t3h.model;

import java.awt.*;

public class SunTree extends PlantsVsZombies {
    public SunTree(int x, int y, int status) {
        super(x, y, status);
        images = new Image[3];
        images[LIVE] = ImageLoader.getImage("sun_flower.gif", getClass());
        images[DIE] = ImageLoader.getImage("sun_flower_dying.gif", getClass());
        images[ACTIVE] = ImageLoader.getImage("active_sunflower.png", getClass());
    }
}
