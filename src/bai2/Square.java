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
public class Square implements Shape {
    private int size;
    private int x, y;

    public Square(int size, int panelWidth, int panelHeight) {
        this.size = size;
        this.x = (panelWidth - size) / 2;
        this.y = (panelHeight - size) / 2;
    }

    @Override
    public void draw(Graphics g, boolean isFilled, Color color) {
        g.setColor(color);
        if (isFilled) {
            g.fillRect(x, y, size, size);
        } else {
            g.drawRect(x, y, size, size);
        }
    }
}