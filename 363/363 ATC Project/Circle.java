 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class Circle extends JPanel{
        //=========================================== constructor
    public Circle() {
        setPreferredSize(new Dimension(100, 100));
    }//end constructor

    //=========================================== paintComponent
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawCircle(g, 300, 300, 50);
        drawCircle(g, 300, 300, 100); // center (30,30) r=20
        drawCircle(g, 300, 300, 150);
        drawCircle(g, 300, 300, 200); // center (30,30) r=20
        drawCircle(g, 300, 300, 250);
        drawCircle(g, 300, 300, 251);
    }

    // Convenience method to draw from center with radius
    public void drawCircle(Graphics cg, int xCenter, int yCenter, int r) {
        cg.drawOval(xCenter-r, yCenter-r, 2*r, 2*r);
    }//end drawCircle
}