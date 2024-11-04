/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai2;

import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author P51
 */
public class Polygon implements Shape{
    private int sides;
    private int radius;
    private int xCenter, yCenter;

    public Polygon(int sides, int radius, int panelWidth, int panelHeight) {
        this.sides = sides;
        this.radius = radius;
        this.xCenter = panelWidth / 2;
        this.yCenter = panelHeight / 2;
    }

    @Override
    public void draw(Graphics g, boolean isFilled, Color color) {
        int[] xPoints = new int[sides];
        int[] yPoints = new int[sides];
        for (int i = 0; i < sides; i++) {
            xPoints[i] = xCenter + (int) (radius * Math.cos(2 * Math.PI * i / sides));
            yPoints[i] = yCenter + (int) (radius * Math.sin(2 * Math.PI * i / sides));
        }
        g.setColor(color);
        if (isFilled) {
            g.fillPolygon(xPoints, yPoints, sides);
        } else {
            g.drawPolygon(xPoints, yPoints, sides);
        }
    }
}
