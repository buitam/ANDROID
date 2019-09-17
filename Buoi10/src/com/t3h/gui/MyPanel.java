package com.t3h.gui;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {

    public MyPanel() {
        setLayout(null);
       setBackground(Color.black);
         PanelMenu panelMenu = new PanelMenu();
         PanelGame panelGame = new PanelGame();
       add(panelMenu);
       add(panelGame);
    }
}
