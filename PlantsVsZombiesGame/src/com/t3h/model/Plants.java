package com.t3h.model;

import java.awt.*;
import java.util.ArrayList;

public class Plants extends PlantsVsZombies {
    public Plants(int x, int y, int status) {
        super(x, y, status);
        images = new Image[3];
        images[LIVE] = ImageLoader.getImage("pea_shooter.gif", getClass());
        images[DIE] = ImageLoader.getImage("pea_shooter_dying.gif", getClass());
        images[ACTIVE] = ImageLoader.getImage("active_peashooter.png", getClass());
    }


}
