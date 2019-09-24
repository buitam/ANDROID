package test;
import com.t3h.model.ImageLoader;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MouseMotionListenerExample2 extends Frame
        implements MouseMotionListener {
    Image counter = ImageLoader.getImage("Counter.png",getClass());
    Image shovel = ImageLoader.getImage("shovel.png",getClass());
    Label label;
    Color color = Color.BLUE;

    public MouseMotionListenerExample2() {
        label = new Label();
        label.setBounds(20, 40, 100, 20);
        add(label);

        addMouseMotionListener(this);

        setSize(400, 400);
        setLayout(null);
        setVisible(true);
    }

    public void mouseDragged(MouseEvent e) {
        label.setText("X=" + e.getX() + ", Y=" + e.getY());
        Graphics g = getGraphics();
        if(e.getX()>300){
        g.clearRect(0,0,400, 400);
        g.drawImage(counter,e.getX(), e.getY(),null);}
        else {
        g.clearRect(0,0,400, 400);
        g.drawImage(shovel,e.getX(), e.getY(),null);}
    }

    public void mouseMoved(MouseEvent e) {
        label.setText("X=" + e.getX() + ", Y=" + e.getY());
    }

    public static void main(String[] args) {
        new MouseMotionListenerExample2();
    }
}
