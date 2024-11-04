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
public class Circle implements  Shape{
    private int radius;
    private int x, y;

    public Circle(int radius, int panelWidth, int panelHeight) {
        this.radius = radius;
        this.x = (panelWidth - 2 * radius) / 2;
        this.y = (panelHeight - 2 * radius) / 2;
    }

    @Override
    public void draw(Graphics g, boolean isFilled, Color color) {
        g.setColor(color);
        if (isFilled) {
            g.fillOval(x, y, 2 * radius, 2 * radius);
        } else {
            g.drawOval(x, y, 2 * radius, 2 * radius);
        }
    }
}
