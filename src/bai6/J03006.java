package bai6;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author P51
 */
public class J03006 extends JFrame{
    private JPanel inputPanel;
    private JLabel inputLabel;
    private JTextField inputTxtField;
    private JButton confirmButton;
    public J03006() {
        inputPanel = new JPanel();
        setSize(500, 500);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        inputLabel = new JLabel("Nhập số:");
        inputTxtField = new JTextField();
        confirmButton = new JButton("Kiểm tra số đẹp");

        inputPanel.setLayout(new BorderLayout());
        inputPanel.setPreferredSize(new Dimension(500, 500));
        inputPanel.add(inputLabel, BorderLayout.WEST);
        inputPanel.add(inputTxtField, BorderLayout.CENTER);
        inputPanel.add(confirmButton, BorderLayout.NORTH);
        add(inputPanel);
        confirmButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = inputTxtField.getText();
                if (isValidInput(s)) {
                    if (isPrettyNumber(s)) {
                        JOptionPane.showMessageDialog(inputPanel, "Số bạn nhập là số đẹp!");
                    } else {
                        JOptionPane.showMessageDialog(inputPanel, "Rất tiếc ! Số bạn nhập không phải là số đẹp!");
                    }
                } else {
                    
                }
                inputTxtField.setText("");
            }
            
        });
    }
    public static void main(String[] args) {
        J03006 view = new J03006();
        view.setVisible(true);
    }
    private boolean isValidInput(String s){
        int n = s.length();
        if (n == 0) {
            JOptionPane.showMessageDialog(inputPanel, "Vui lòng điền một số");
            return false;
        }
        for (int i = 0; i < n; i++) {
            if (Character.isAlphabetic(s.charAt(i))) {
                JOptionPane.showMessageDialog(inputPanel, "Input phải là một số");
                return false;
            }
        }
        return true;
    }
    private boolean isPrettyNumber(String s) {
        int n = s.length();
        int l = 0, r = n - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            int a = Integer.valueOf(s.charAt(l)) - '0';
            int b = Integer.valueOf(s.charAt(r)) - '0';
            if (a % 2 == 1 || b % 2 == 1) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
