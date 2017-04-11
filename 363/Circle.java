 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class Circle extends JPanel{
    int center = 300;
    public int[][] locations = {{15, 25}, {60, 30}};
    
    //=========================================== constructor
    public Circle() {
        setPreferredSize(new Dimension(100, 100));
    }//end constructor

    //=========================================== paintComponent
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
        RenderingHints.VALUE_ANTIALIAS_ON);
        
        //draw airplanes
        g.setColor(Color.RED);
        int x, y;
        int d = 20;
        int[][] list = getPlaneLocations();
        for (int i=0; i < list.length; i++)
        {
            x = list[i][0];
            y = list[i][1];
            g.fillOval(x, y, d, d);
        }
        
        g.setColor(Color.WHITE);
        float[] dash1 = {2f, 0f, 2f};
        float[] dash2 = {1f, 1f, 1f};
        float[] dash3 = {4f, 0f, 2f};
        float[] dash4 = {4f, 4f, 1f};
        BasicStroke bs1 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash1, 2f);
        BasicStroke bs2 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash2, 2f);
        BasicStroke bs3 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash3, 2f);
        BasicStroke bs4 = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND, 1.0f, dash4, 2f);
        drawCircle(g, 300, 300, 50);
        g2.setStroke(bs1);
        drawCircle(g, 300, 300, 100);
        g2.setStroke(new BasicStroke(1));// center (30,30) r=20
        drawCircle(g, 300, 300, 150);
        g2.setStroke(bs1);
        drawCircle(g, 300, 300, 200); // center (30,30) r=20
        g2.setStroke(new BasicStroke(2));
        drawCircle(g, 300, 300, 250);
    }

    public int[][] getPlaneLocations()
    {
        return locations;
    }
    
    public void changePlaneLocations()
    {
        locations = getPlaneLocations();
        for (int[] i:locations)
        {
            if (i[0] < center)
                i[0] = i[0] + 1;
            if (i[1] < center)
                i[1] = i[1] + 1;
        }
    }
    
    // Convenience method to draw from center with radius
    public void drawCircle(Graphics cg, int xCenter, int yCenter, int r) {
        cg.drawOval(xCenter-r, yCenter-r, 2*r, 2*r);
    }//end drawCircle
}