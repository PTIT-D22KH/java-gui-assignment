/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai7;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author P51
 */
public class ProductTableView extends JFrame{
    private JPanel choosePanel, tablePanel;
    private JButton readButton, sortButton;
    private JScrollPane scrollPane;
    private JTable productTable;
    private ArrayList<Product> products;
    private DefaultTableModel tableModel;
    public ProductTableView() {
        products = new ArrayList<>();
        tableModel = new DefaultTableModel();
        addColumn();
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        
        
        choosePanel = new JPanel();
        tablePanel = new JPanel(new BorderLayout());
        tablePanel.setPreferredSize(new Dimension(700, 600));
        readButton = new JButton("READ");
        sortButton = new JButton("SORT");
        choosePanel.add(readButton);
        choosePanel.add(sortButton);
        add(choosePanel, BorderLayout.NORTH);
        
        productTable = new JTable();
        productTable.setModel(tableModel);
        scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(700, 600));
        tablePanel.add(scrollPane, BorderLayout.CENTER);
        
        scrollPane.setViewportView(productTable);
        add(tablePanel, BorderLayout.CENTER);
        addEvent();
    }
    private void addColumn() {
        tableModel.addColumn("ID");
        tableModel.addColumn("NAME");
        tableModel.addColumn("PRICE");
        tableModel.addColumn("WARRANTY MONTH");
    }
    private void renderTable(){
        tableModel.setRowCount(0);
        for (Product x : products) {
            tableModel.addRow(x.toRowTable());
        }
    }
    private void addEvent(){ 
        readButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (products.isEmpty()) {
                   try {
                        Scanner input = new Scanner(new File("src/bai7/SANPHAM.in"));
                        int n = Integer.parseInt(input.nextLine());
                        for (int i = 0; i < n; i++) {
                            products.add(new Product(input.nextLine(), input.nextLine(), Integer.parseInt(input.nextLine()), Integer.parseInt(input.nextLine())));
                        }

                        renderTable();
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(ProductTableView.class.getName()).log(Level.SEVERE, null, ex);
                    } 
                }
                
            }
            
        });
        
        sortButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!products.isEmpty()) {
                    Collections.sort(products);
                    renderTable();
                } else {
                    JOptionPane.showMessageDialog(tablePanel, "You must click SCAN first");
                }
            }
            
        });
    }
}
