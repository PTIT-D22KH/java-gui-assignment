/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.JFrame;

/**
 *
 * @author P51
 */
public class VeHinh extends JFrame{
    private JComboBox<String> polygonBox;
    private JComboBox<String> typeBox;
    private JComboBox<String> colorBox;
    private JButton confirmButton;
    private JPanel choosePanel;
    private DrawPanel drawPanel;
    private Shape currentShape;
    private String polygonString, typeString, colorString;
    private JTextField edgeTxtField, widthTxtField, heightTxtField;
    public VeHinh() {
        
        String polygons[] = {
            "Hình vuông", "Hình chữ nhật", "Hình tròn", "Đa giác"
        };
        String types[] = {
            "Đặc", "Rỗng"
        };
        String colors[] = {
           "Đỏ", "Xanh lá", "Xanh dương", "Vàng"
        };
        polygonBox = new JComboBox<>(polygons);
        typeBox = new JComboBox<>(types);
        colorBox = new JComboBox<>(colors);
        confirmButton = new JButton("Confirm");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(500, 500);
        setTitle("Vẽ hình");
        choosePanel = new JPanel();
        choosePanel.setBounds(0, 0, 500, 150);
//        choosePanel.setBackground(Color.red);
        polygonBox.setBounds(50, 10, 130, 25);
        typeBox.setBounds(230, 10, 70, 25);
        confirmButton.setBounds(200, 125, 90, 25);
        colorBox.setBounds(350, 10, 100, 25);
        
        choosePanel.setLayout(null);
        choosePanel.add(polygonBox);
        choosePanel.add(typeBox);
        choosePanel.add(confirmButton);
        choosePanel.add(colorBox);
        
        
        drawPanel = new DrawPanel();
        drawPanel.setBounds(0, 150, 500, 350);
        add(drawPanel);
//        drawPanel = new JPanel();
//        drawPanel.setBounds(0, 150, 500, 300);
//        drawPanel.setBackground(Color.GREEN);
        add(choosePanel);
//        add(drawPanel);
        addEvent();
    }
    private void addEvent(){ 
        polygonBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                polygonString = (String)polygonBox.getSelectedItem();
                choosePanel.removeAll();
                choosePanel.add(polygonBox);
                choosePanel.add(typeBox);
                choosePanel.add(colorBox);
                choosePanel.add(confirmButton);
                switch (polygonString) {
                    case "Hình vuông" -> {
                        squareChosen();
                    }
                    case "Hình chữ nhật" -> {
                        rectangleChosen();
                    }
                    case "Hình tròn" -> {
                        circleChosen();
                    }
                    case "Đa giác" -> {
                        polygonChosen();
                    }
                            
                           
                }
                choosePanel.revalidate();
                choosePanel.repaint();
            }
            
        });
        typeBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                typeString = (String)typeBox.getSelectedItem();
            }
            
        });
        colorBox.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                colorString = (String)colorBox.getSelectedItem();
            }
            
        });
        confirmButton.addActionListener(new ActionListener(){ 
            @Override
            public void actionPerformed(ActionEvent e) {
                drawShape();
                drawPanel.repaint();
            }
            
        });
    }
    private void squareChosen() {
        JLabel edgeLabel = new JLabel("Cạnh: ");
        edgeTxtField = new JTextField();
        edgeLabel.setBounds(100, 50, 50, 25);
        edgeTxtField.setBounds(200, 50, 250, 25);
        choosePanel.add(edgeLabel);
        choosePanel.add(edgeTxtField);
        
    }
    private void circleChosen() {
        JLabel edgeLabel = new JLabel("Bán kính: ");
        edgeTxtField = new JTextField();
        edgeLabel.setBounds(100, 50, 70, 25);
        edgeTxtField.setBounds(200, 50, 250, 25);
        choosePanel.add(edgeLabel);
        choosePanel.add(edgeTxtField);
        
    }
    private void rectangleChosen() {
        JLabel widthLabel = new JLabel("Chiều dài: ");
        JLabel heightLabel = new JLabel("Chiều rộng: ");
        widthTxtField = new JTextField();
        heightTxtField = new JTextField();
        widthLabel.setBounds(50, 50, 70, 25);
        heightLabel.setBounds(250, 50, 70, 25);
        widthTxtField.setBounds(150, 50, 70, 25);
        heightTxtField.setBounds(350, 50, 70, 25);
        choosePanel.add(widthLabel);
        choosePanel.add(widthTxtField);
        choosePanel.add(heightLabel);
        choosePanel.add(heightTxtField);
    }   
    private void polygonChosen() {
        JLabel widthLabel = new JLabel("Chiều dài: ");
        JLabel heightLabel = new JLabel("Chiều rộng: ");
        widthTxtField = new JTextField();
        heightTxtField = new JTextField();
        widthLabel.setBounds(50, 50, 70, 25);
        heightLabel.setBounds(250, 50, 70, 25);
        widthTxtField.setBounds(150, 50, 70, 25);
        heightTxtField.setBounds(350, 50, 70, 25);
        JLabel edgeLabel = new JLabel("Bán kính: ");
        edgeTxtField = new JTextField();
        edgeLabel.setBounds(100, 80, 70, 25);
        edgeTxtField.setBounds(200, 80, 250, 25);
        choosePanel.add(edgeLabel);
        choosePanel.add(edgeTxtField);
        choosePanel.add(widthLabel);
        choosePanel.add(widthTxtField);
        choosePanel.add(heightLabel);
        choosePanel.add(heightTxtField);
    }  
    private void drawShape() {
        try {
            boolean isFilled = typeString.equals("Đặc");
            Color color = getColorFromString(colorString);
            int panelWidth = drawPanel.getWidth();
            int panelHeight = drawPanel.getHeight();
            switch (polygonString) {
                case "Hình vuông" -> {
                    int size = Integer.parseInt(edgeTxtField.getText());
                    currentShape = new Square(size, panelWidth, panelHeight);
                }
                case "Hình chữ nhật" -> {
                    int width = Integer.parseInt(widthTxtField.getText());
                    int height = Integer.parseInt(heightTxtField.getText());
                    currentShape = new Rectangle(width, height, panelWidth, panelHeight);
                }
                case "Hình tròn" -> {
                    int radius = Integer.parseInt(edgeTxtField.getText());
                    currentShape = new Circle(radius, panelWidth, panelHeight);
                }
                case "Đa giác" -> {
                    int sides = Integer.parseInt(edgeTxtField.getText());
                    currentShape = new Polygon(sides, Math.min(panelWidth, panelHeight) / 2 - 10, panelWidth, panelHeight);
                }
            }
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng số.");
        }
    }

    private Color getColorFromString(String colorString) {
        return switch (colorString) {
            case "Đỏ" -> Color.RED;
            case "Xanh lá" -> Color.GREEN;
            case "Xanh dương" -> Color.BLUE;
            case "Vàng" -> Color.YELLOW;
            default -> Color.BLACK;
        };
    }

    private class DrawPanel extends JPanel{

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (currentShape != null) {
                boolean isFilled = typeString.equals("Đặc");
                Color color = getColorFromString(colorString);
                currentShape.draw(g, isFilled, color);
            }
        }
    }
}
