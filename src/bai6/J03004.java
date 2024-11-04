/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai6;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;

/**
 *
 * @author P51
 */
public class J03004 extends JFrame{
    private JPanel inputPanel, confirmPanel;
    private JLabel inputLabel, resultLabel;
    private JTextField inputTxtField, resultTxtField;
    private JButton confirmButton;
    
    public J03004() {
        inputPanel = new JPanel();
        setSize(500, 150);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        inputLabel = new JLabel("Nhập xâu:");
        inputTxtField = new JTextField(30);
        confirmButton = new JButton("Chuẩn hoá xâu");
        resultLabel = new JLabel("Xâu sau khi chuẩn hoá: ");
        resultTxtField = new JTextField(30);
        resultTxtField.setEditable(false);
        confirmPanel = new JPanel();
        confirmPanel.add(confirmButton);

//        inputPanel.setPreferredSize(new Dimension(250, 250));
        inputPanel.add(inputLabel);
        inputPanel.add(inputTxtField);
        inputPanel.add(resultLabel);
        inputPanel.add(resultTxtField);
//        inputPanel.add(confirmButton, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(confirmPanel, BorderLayout.SOUTH);
        
        confirmButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = inputTxtField.getText();
                if (isValidInput(s)) {
                    resultTxtField.setText(normalizeName(s));
                }
            }
            
        });
    }
    private String normalizeName(String s) {
        String a[] = s.trim().toLowerCase().split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            res.append(Character.toUpperCase(a[i].charAt(0))).append(a[i].substring(1)).append(" ");
        }
        return res.toString().trim();
    }
    public static void main(String[] args) {
        J03004 view = new J03004();
        view.setVisible(true);
    }
    private boolean isValidInput(String s) {
        String a[] = s.trim().split("\\s+");
        if (a.length == 0) {
            JOptionPane.showMessageDialog(inputPanel, "Vui lòng nhập xâu!");
            return false;
        }
        return true;
    }
}
