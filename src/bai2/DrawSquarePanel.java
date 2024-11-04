/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai2;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author P51
 */
public class DrawSquarePanel extends JPanel{
    private int edge, width, height;
    public DrawSquarePanel(int edge, int width, int height) {
        this.edge = edge;
        this.width = width;
        this.height = height;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
        g.setColor(Color.red);
        g.drawRect(edge, edge, width, height);
    }
    
    
}
