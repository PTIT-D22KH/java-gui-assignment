/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai6;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
public class J02004 extends JFrame{
    private JPanel inputPanel, confirmPanel;
    private JLabel inputLabel, resultLabel;
    private JTextField inputTxtField, resultTxtField;
    private JButton confirmButton, addButton;
    private ArrayList<Integer> list;
    public J02004() {
        list = new ArrayList<>();
        inputPanel = new JPanel();
        setSize(500, 150);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        inputLabel = new JLabel("Nhập số:");
        inputTxtField = new JTextField(30);
        confirmButton = new JButton("Kiểm tra mảng đối xứng");
        resultLabel = new JLabel("Mảng hiện tại: ");
        resultTxtField = new JTextField(30);
        resultTxtField.setEditable(false);
        confirmPanel = new JPanel();
        confirmPanel.add(confirmButton);
        addButton = new JButton("Thêm số vào mảng");
        confirmPanel.add(addButton);
        
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
//        inputPanel.setPreferredSize(new Dimension(250, 250));
        inputPanel.add(inputLabel);
        inputPanel.add(inputTxtField);
        inputPanel.add(resultLabel);
        inputPanel.add(resultTxtField);
//        inputPanel.add(confirmButton, BorderLayout.NORTH);
        add(inputPanel, BorderLayout.CENTER);
        add(confirmPanel, BorderLayout.SOUTH);
        
        addButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(inputTxtField.getText());
                list.add(x);
                renderList();
                inputTxtField.setText("");
            }
            
        });
        confirmButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isValidInput()) {
                    if (isPalindrome()) {
                        JOptionPane.showMessageDialog(inputPanel, "Mảng đối xứng!");
                    } else {
                        JOptionPane.showMessageDialog(inputPanel, "Mảng không đối xứng!");
                    }
                }
                
            }
            
        });
    }
    private boolean isValidInput(){
        if (list.isEmpty()) {
            JOptionPane.showMessageDialog(inputPanel, "Vui lòng nhập mảng!");
            return false;
        }
        return true;
    }
    private boolean isPalindrome(){ 
        int i = 0, j = list.size() - 1;
        while (i <= j) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    private void renderList(){
        resultTxtField.setText("");
        StringBuilder res = new StringBuilder();
        for (int x : list) {
            res.append(x).append(" ");
        }
        resultTxtField.setText(res.toString().trim());
    }
    public static void main(String[] args) {
        J02004 view = new J02004();
        view.setVisible(true);
    }
}
