package com.t3h.model;

import java.awt.*;

public class Potatoes extends PlantsVsZombies {
    public Potatoes(int x, int y, int status) {
        super(x, y, status);
        images = new Image[3];
        images[LIVE] = ImageLoader.getImage("walnut_full_life.gif", getClass());
        images[DIE] = ImageLoader.getImage("walnut_dead.gif", getClass());
        images[ACTIVE] = ImageLoader.getImage("active_walnut.png", getClass());
    }
}
