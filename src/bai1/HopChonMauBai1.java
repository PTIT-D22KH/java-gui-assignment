/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai1;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author P51
 */
public class HopChonMauBai1 extends JFrame{
    private JComboBox<String> colorBox;
    private JPanel colorPanel, choosePanel;
    private JButton button;
    
    
    public HopChonMauBai1() {
        setTitle("Hộp chọn màu");
        String list[] = {"RED", "GREEN", "YELLOW"};
        setLayout(null);

        colorBox = new JComboBox<>(list);
        colorPanel = new JPanel();
        choosePanel = new JPanel(null);
        button = new JButton("Change Color");

        choosePanel.setBounds(0, 0, 500, 60);
        colorBox.setBounds(100, 30, 100, 30);
        button.setBounds(250, 30, 150, 30);
        colorPanel.setBounds(0, 60, 500, 440);

        choosePanel.add(colorBox);
        choosePanel.add(button);

        add(choosePanel);
        add(colorPanel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void showView() {
        setVisible(true);
        addEvent();
    }
    private void addEvent() {
        button.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String x = (String)colorBox.getSelectedItem();
                switch (x) {
                    case "RED":
                        colorPanel.setBackground(Color.RED);
                        break;
                    case "GREEN":
                        colorPanel.setBackground(Color.GREEN);
                        break;
                    case "YELLOW":
                        colorPanel.setBackground(Color.YELLOW);
                        break;
                }
            }
            
        });
    }
}
