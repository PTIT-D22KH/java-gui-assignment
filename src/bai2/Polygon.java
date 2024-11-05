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
    
    public Polygon(int radius, int panelWidth, int panelHeight) {
        this.radius = radius;
        this.xCenter = panelWidth / 2;
        this.yCenter = panelHeight / 2;
    }

    @Override
    public void draw(Graphics g, boolean isFilled, Color color) {
        g.setColor(color);
        // Create a Polygon object
        java.awt.Polygon polygon = new java.awt.Polygon();

        // Add points to the polygon
        polygon.addPoint(xCenter + radius, yCenter);
        polygon.addPoint((int)(xCenter + radius *
          Math.cos(2 * Math.PI / 6)), (int)(yCenter - radius *
          Math.sin(2 * Math.PI / 6)));
        polygon.addPoint((int)(xCenter + radius *
          Math.cos(2 * 2 * Math.PI / 6)), (int)(yCenter - radius *
          Math.sin(2 * 2 * Math.PI / 6)));
        polygon.addPoint((int)(xCenter + radius *
          Math.cos(3 * 2 * Math.PI / 6)), (int)(yCenter - radius *
          Math.sin(3 * 2 * Math.PI / 6)));
        polygon.addPoint((int)(xCenter + radius *
          Math.cos(4 * 2 * Math.PI / 6)), (int)(yCenter - radius *
          Math.sin(4 * 2 * Math.PI / 6)));
        polygon.addPoint((int)(xCenter + radius *
          Math.cos(5 * 2 * Math.PI / 6)), (int)(yCenter - radius *
          Math.sin(5 * 2 * Math.PI / 6)));
        if (isFilled) {
            g.fillPolygon(polygon);
        } else {
            g.drawPolygon(polygon);
        }
    }
}
