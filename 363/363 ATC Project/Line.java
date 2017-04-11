package project;
//
import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
import javax.swing.*;
import java.awt.event.*;

public class Line extends JPanel{
        //=========================================== constructor
    public Line() {
        setPreferredSize(new Dimension(100, 100));

        
    }//end constructor

    //=========================================== paintComponent
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Line2D thing = new Line2D.Float(0, 0, 0, 50);
        Line2D thing2 = new Line2D.Float(50, 0, 50, 50);
        g2.draw(thing);
        g2.draw(thing2);
    }

    // Convenience method to draw from center with radius
    public static void main(String []args) {
        Line s = new Line();
        s.setVisible(true);
    }//end drawCircle
}