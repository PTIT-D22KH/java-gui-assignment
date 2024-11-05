/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai4;

import java.awt.GridLayout;
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
public class Calculator extends JFrame {
    private JLabel inputLabel, resultLabel, currentLabel, showResultLabel;
    private JTextField inputTxtField, currentField;
    private JButton addButton, minusButton, productButton, divideButton, equalButton, powerButton, sqrtButton, clearButton;
    private JPanel panel1, panel2, panel3;
    private int op1, op2, res;
    private String operation;

    public Calculator() {
        op1 = 0;
        op2 = 0;
        res = 0;
        setTitle("Calculator");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(3, 1)); // Use GridLayout to arrange panels vertically

        // Initialize components
        inputLabel = new JLabel("Nhập số: ");
        inputTxtField = new JTextField(30);
        showResultLabel = new JLabel("Kết quả:");
        resultLabel = new JLabel();
        currentLabel = new JLabel("Phép tính");
        currentField = new JTextField(30);
        currentField.setEditable(false);

        // Panel for input
        panel1 = new JPanel();
        panel1.add(inputLabel);
        panel1.add(inputTxtField);
        panel1.add(currentLabel);
        panel1.add(currentField);

        // Panel for buttons
        panel2 = new JPanel();
        panel2.setLayout(new GridLayout(2, 4));
        addButton = new JButton("+");
        minusButton = new JButton("-");
        productButton = new JButton("*");
        divideButton = new JButton("/");
        powerButton = new JButton("^");
        sqrtButton = new JButton("√");
        equalButton = new JButton("=");
        clearButton = new JButton("C");
        panel2.add(addButton);
        panel2.add(minusButton);
        panel2.add(productButton);
        panel2.add(divideButton);
        panel2.add(equalButton);
        panel2.add(sqrtButton);
        panel2.add(powerButton);
        panel2.add(clearButton);

        // Panel for result
        panel3 = new JPanel();
        panel3.add(showResultLabel);
        panel3.add(resultLabel);

        // Add panels to frame
        add(panel1);
        add(panel2);
        add(panel3);

        addEvent();
    }

    private void resetField() {
        inputTxtField.setText("");
    }

    private void addEvent() {
        ActionListener operationListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = e.getActionCommand();
                String x = inputTxtField.getText().trim();
                resetField();
                if (x.isEmpty()) {
                    JOptionPane.showMessageDialog(panel1, "Vui lòng nhập số!");
                    return;
                }
                op1 = Integer.parseInt(x);
                operation = s;
                currentField.setText(op1 + " " + operation);
                System.out.println(op1 + " " + operation);
            }
        };
        addButton.addActionListener(operationListener);
        minusButton.addActionListener(operationListener);
        productButton.addActionListener(operationListener);
        divideButton.addActionListener(operationListener);
        powerButton.addActionListener(operationListener);

        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetData();
                currentField.setText("");
                resultLabel.setText("");
            }
        });

        equalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String x = inputTxtField.getText().trim();
                resetField();
                if (x.isEmpty()) {
                    JOptionPane.showMessageDialog(panel1, "Vui lòng nhập số!");
                    return;
                }
                op2 = Integer.parseInt(x);
                switch (operation) {
                    case "+" -> res = op1 + op2;
                    case "-" -> res = op1 - op2;
                    case "*" -> res = op1 * op2;
                    case "/" -> res = op1 / op2;
                    case "^" -> res = (int) Math.pow(op1, op2);
                }
                updateResultLabel();
                resetData();
            }
        });

        sqrtButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String x = inputTxtField.getText().trim();
                resetField();
                if (x.isEmpty()) {
                    JOptionPane.showMessageDialog(panel1, "Vui lòng nhập số!");
                    return;
                }
                op1 = Integer.parseInt(x);
                res = (int) Math.sqrt(op1);
                updateResultLabel();
                resetData();
            }
        });
    }

    private void resetData() {
        op1 = 0;
        operation = "";
        op2 = 0;
        res = 0;
    }

    private void updateResultLabel() {
        if (op1 == 0) {
            resultLabel.setText("" + op2);
        } else {
            resultLabel.setText("" + res);
        }
        
        repaint();
    }

}