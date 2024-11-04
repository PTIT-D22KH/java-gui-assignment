/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai6;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author P51
 */
public class J03040 extends JFrame{
    private JPanel inputPanel, confirmPanel;
    private JLabel inputLabel;
    private JTextField inputTxtField;
    private JButton confirmButton;
    
    public J03040() {
        inputPanel = new JPanel();
        setSize(500, 100);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        inputLabel = new JLabel("Nhập biển số:");
        inputTxtField = new JTextField(30);
        confirmButton = new JButton("Kiểm tra biển số đẹp");
        confirmPanel = new JPanel();
        confirmPanel.add(confirmButton);

//        inputPanel.setPreferredSize(new Dimension(250, 250));
        inputPanel.add(inputLabel);
        inputPanel.add(inputTxtField);
//        inputPanel.add(confirmButton, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(confirmPanel, BorderLayout.SOUTH);
        
        confirmButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = inputTxtField.getText().trim();
                if (isValidInput(s)) {
                    s = s.substring(5);
                    StringBuilder a = new StringBuilder(s);
                    a.deleteCharAt(3);
                    s = a.toString();
                    if (check(s)) {
                        JOptionPane.showMessageDialog(inputPanel, "Chúc mừng bạn! Biển số của bạn là biển số đẹp!");
                    } else {
                        JOptionPane.showMessageDialog(inputPanel, "Rất tiếc!Biển số của bạn không phải biển số đẹp");

                    }
                            
                }
            }
            
        });
    }
    private boolean isValidInput(String s) {
        if(s.isEmpty()) {
            JOptionPane.showMessageDialog(inputPanel, "Vui lòng nhập biển số!");
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        J03040 view = new J03040();
        view.setVisible(true);
    }
    private boolean all6or8(String s) {
        char []a = s.toCharArray();
        for (char c : a) {
            if (c != '6' && c != '8') {
                return false;
            }
        }
        return true;
    }

    private boolean allSame(String s) {
        char []a = s.toCharArray();
        char check = a[0];
        for (char c : a) {
            if (c != check) {
                return false;
            }
        }
        return true;
    }
    private boolean firstThreeAndTwoLast(String s) {
        char a = s.charAt(0);
        char b = s.charAt(4);
        for (int i = 1; i <= 2; i++) {
            if (s.charAt(i) != a) {
                return false;
            }
        }
        if (s.charAt(3) != b) {
            return false;
        }
        return true;
    }
    private boolean isIncreasing(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (Character.valueOf(s.charAt(i)) <= Character.valueOf(s.charAt(i - 1))) {
                return false;
            }
        }
        return true;
    }
    private boolean check(String s) {
        if (all6or8(s) || allSame(s) || firstThreeAndTwoLast(s) || isIncreasing(s)) {
            return true;
        }
        return false;
    }
}
