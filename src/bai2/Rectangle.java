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
public class Rectangle implements Shape{
    private int width, height;
    private int x, y;

    public Rectangle(int width, int height, int panelWidth, int panelHeight) {
        this.width = width;
        this.height = height;
        this.x = (panelWidth - width) / 2;
        this.y = (panelHeight - height) / 2;
    }

    @Override
    public void draw(Graphics g, boolean isFilled, Color color) {
        g.setColor(color);
        if (isFilled) {
            g.fillRect(x, y, width, height);
        } else {
            g.drawRect(x, y, width, height);
        }
    }
}
