package com.t3h.model;

import java.awt.*;

public class RedTree extends PlantsVsZombies{
    public RedTree(int x, int y, int status) {
        super(x, y, status);
        images = new Image[3];
        images[LIVE] = ImageLoader.getImage("beetroot.gif", getClass());
        images[DIE] = ImageLoader.getImage("beetroot_dying.gif", getClass());
        images[ACTIVE] = ImageLoader.getImage("active_beetroot.png", getClass());
    }
}
