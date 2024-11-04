/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JFrame;

/**
 *
 * @author P51
 */
public class Main extends JFrame{
    public Main(){
        Clock clock = new Clock();
        MessagePanel messagePanel = new MessagePanel(clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond());
        setSize(300, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        messagePanel.setForeground(Color.blue);
        messagePanel.setFont(new Font("Courie", Font.BOLD, 16));
        add(clock);
        add(messagePanel, BorderLayout.SOUTH);
        
    }
    public static void main(String[] args) {
        Main view = new Main();
        view.setVisible(true);
    }
}
