/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bai5;

/**
 *
 * @author P51
 */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
public class ImageDisplay extends JFrame{
    private JPanel controlPanel, imagePanel;
    private JButton selectImageButton;
    private JFileChooser fileChooser;

    public ImageDisplay() {
        setTitle("Ảnh");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());


        controlPanel = new JPanel();
        selectImageButton = new JButton("Select Image");
        controlPanel.add(selectImageButton);

        imagePanel = new JPanel();
        imagePanel.setLayout(new FlowLayout());


        add(controlPanel, BorderLayout.NORTH);
        add(new JScrollPane(imagePanel), BorderLayout.CENTER);


        fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif"));

        selectImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    displayImage(selectedFile);
                }
            }
        });
    }

    private void displayImage(File file) {
        try {
            ImageIcon imageIcon = new ImageIcon(file.getAbsolutePath());
            JLabel imageLabel = new JLabel(imageIcon);
            imagePanel.add(imageLabel);
            imagePanel.revalidate();
            imagePanel.repaint();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Không load được: " + e.getMessage(), "Lỗi: ", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        ImageDisplay view = new ImageDisplay();
        view.setVisible(true);
    }
}
