/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai3;

import javax.swing.JPanel;
import javax.swing.JLabel;

/**
 *
 * @author P51
 */
public class MessagePanel extends JPanel{
    private JLabel label;
    public MessagePanel(String s) {
        label = new JLabel(s);
        add(label);
    }
}
