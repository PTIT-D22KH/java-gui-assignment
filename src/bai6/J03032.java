/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai6;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
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
public class J03032 extends JFrame{
    private JPanel inputPanel, confirmPanel;
    private JLabel inputLabel, resultLabel;
    private JTextField inputTxtField, resultTxtField;
    private JButton confirmButton;
    
    public J03032() {
        inputPanel = new JPanel();
        setSize(500, 150);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        inputLabel = new JLabel("Nhập xâu:");
        inputTxtField = new JTextField(30);
        confirmButton = new JButton("Đảo xâu");
        resultLabel = new JLabel("Xâu đảo: ");
        resultTxtField = new JTextField(30);
        resultTxtField.setEditable(false);
        confirmPanel = new JPanel();
        confirmPanel.add(confirmButton);
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));

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
                String s = inputTxtField.getText().trim();
                if (isValidInput(s)) {
                    resultTxtField.setText(reversedString(s));
                }
            }
            
        });
    }
    private String reversedString(String s) {
        String a[] = s.split("\\s+");
        StringBuilder res = new StringBuilder();
        for (int i = a.length - 1; i >= 0; i--) {
            res.append(a[i]).append(" ");
        }
        return res.toString().trim();
    }
    public static void main(String[] args) {
        J03032 view = new J03032();
        view.setVisible(true);
    }
    private boolean isValidInput(String s) {
        String a[] = s.trim().split("\\s+");
        
        if (a.length == 0) {
            JOptionPane.showMessageDialog(inputPanel, "Vui lòng nhập xâu!");
            return false;
        }
        for (String x : a) {
            if (x.length() == 0) {
                JOptionPane.showMessageDialog(inputPanel, "Vui lòng nhập xâu!");
                return false;
            }
        }
        return true;
    }
}
