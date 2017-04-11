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
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class Circle extends JPanel {
    int center = 300;
    public int[][] locations = {{5, 5}};
    public Circle() {
        setPreferredSize(new Dimension(100, 100));
    }//end constructor

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, 
        RenderingHints.VALUE_ANTIALIAS_ON);
        
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
        
        //draw airplanes        
        int x, y;
        int d = 10;
        int[][] list = getPlaneLocations();
        for (int i=0; i < list.length; i++)
        {
            if (list[i][0] < 0)
                continue;
            
            g.setColor(new Color(214, 137, 16));
            x = list[i][0];
            y = list[i][1];
            g.fillOval(x, y, d, d);
            g.drawOval(x-10, y-10, d+20, d+20);
            JTextField text = new JTextField("");
            text.setLocation(x+20, y-40);
            g.drawRect(x+20, y-40, 80, 30);
            g.setColor(new Color(214, 137, 16, 50));
            g.fillRect(x+20, y-40, 80, 30);
            g.setColor(Color.WHITE);
            g.drawString("", x+25, y-20);
        }
    }

    public int[][] getPlaneLocations()
    {
        return locations;
    }
    
    public void changePlaneLocations()
    {
        int v = 5;
        locations = getPlaneLocations();
        
        for (int[] i:locations)
        {
            if (i[0] < 0)
                continue;
            
            if (!closeEnough(i[1], center, v))
            {
                if (i[1] > center) i[1] = i[1] - v;
                else if (i[1] < center) i[1] = i[1] + v;
            }
            else {
                if (closeEnough(i[0], center, v))
                {
                    i[0] = -25;
                    i[1] = -25;
                    continue;
                }
                if (i[0] < center) {//east
                    i[0] = i[0] + v;
                }
                else {//west
                    i[0] = i[0] - v;
                }
            }
        }
    }
    
    private boolean closeEnough(int i, int goal, int margin)
    {
        return ((i > (goal-(3*margin))) & i < (goal+(3*margin)));
    }
    
    // Convenience method to draw from center with radius
    public void drawCircle(Graphics cg, int xCenter, int yCenter, int r) {
        cg.drawOval(xCenter-r, yCenter-r, 2*r, 2*r);
    }//end drawCircle
}