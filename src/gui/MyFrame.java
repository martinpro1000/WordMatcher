package gui;

import com.sun.tools.javac.*;
import main.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.io.*;
import java.util.regex.*;

public class MyFrame {

    JTextField pathField;
    JTextField jTextField;
    private MainClass main; //not the real instance
    public JCheckBox toUpperCase;
    JLabel support = new JLabel("check all the files or just one\nfor a word\n(support is only for .txt, .gz and .zip files)");
    JLabel rights = new JLabel("program was created by martin1000, github");
    public MyFrame(MainClass main) {
        this.main = main;
    }

    public void createAndShowGUI() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            jTextField = new JTextField();
            pathField = new JTextField();
            Font fontft = new Font(null, Font.PLAIN, 12);
            JLabel forJt = new JLabel("word to check");
            JLabel forP = new JLabel("path (directory)");
            JButton find = new JButton("FIND");
            forP.setFont(fontft);
            forJt.setFont(fontft);
            JButton pathSelector = new JButton("select...");
            JButton info = new JButton("info");
            JFrame frame = new JFrame("Word matcher");
            JFileChooser fileChooser = new JFileChooser();
            //frame.setUndecorated(true);
            toUpperCase = new JCheckBox("case insensitive");
            Font font = new Font("Robot Considered", Font.PLAIN, 13);
            frame.setSize(460, 160);
            frame.setLayout(null);
            //frame.setShape(new RoundRectangle2D.Double(2, 2, 460, 150, 50, 50));
            frame.setLocationRelativeTo(null);
            frame.setResizable(false);
            //frame.getContentPane().setBackground(new Color(245, 255, 245));
            jTextField.setSize(220, 20);
            jTextField.setLocation(100, 5);
            forJt.setBounds(15, 10, 100, 10);
            pathField.setBounds(jTextField.getX(), forJt.getY() + 20, 220, 20);
            forP.setBounds(15, forJt.getY() + 20, 100, 20);
            toUpperCase.setBounds(10, forP.getY() + 25, 140, 20);
            toUpperCase.setFont(font);
            find.setBounds(jTextField.getX()+240, 70, 80, 27);
            info.setBounds(find.getX()-100, 70, 80, 27);
            pathSelector.setBounds(pathField.getX()+240, pathField.getY(), 75, pathField.getHeight());
            frame.add(forJt);
            frame.add(jTextField);
            frame.add(toUpperCase);
            frame.add(pathField);
            frame.add(forP);
            frame.add(find);
            frame.add(info);
            frame.add(pathSelector);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            find.addActionListener(new ButtonActivation(this, main));
            info.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JOptionPane.showMessageDialog(null, "----------------------------------------------------\nHOW TO USE IT:\n1. type the word you want to check!\n2. select the path of the DIRECTORY or the FILE\n3. if you want to, you can select case insensitive setting\n4. when you are ready, click FIND\nto check how many times the file/-s contains a word!\n----------------------------------------------------\nthe program has been made by martin1000","GUIDE AND INFO" ,JOptionPane.PLAIN_MESSAGE);
                }
            });
            //filechooser
            pathSelector.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //not anymore! fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                    fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                    int value = fileChooser.showOpenDialog(null);
                        if(value == JFileChooser.APPROVE_OPTION) {
                            File file = fileChooser.getSelectedFile();
                            //System.out.println(file.getAbsolutePath()); //debug
                            pathField.setText(file.getAbsolutePath());
                        }
                    }
                });
            }catch(Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "FAILED TO LOAD THE FRAME,\nplease try to reboot the app!\nerror code: " + ex.getStackTrace());
            }
        }

        //gets the Path of the directory!
        public String getPath() {
            return pathField.getText();
        }
        //gets the word to match!
        public String getMatcher() {
            //with Pattern.quote we are returning a literal String, because if user enters a "java special Character", the program will not work correctly.
            return Pattern.quote(jTextField.getText());
        }
    }
