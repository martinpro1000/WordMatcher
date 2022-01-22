package gui;


import main.*;

import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class ButtonActivation implements ActionListener {

    MyFrame myFrame;
    MainClass main;
    public ButtonActivation(MyFrame myFrame, MainClass main) {
        this.myFrame = myFrame;
        this.main = main;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //checks if the file instance is a file or a directory, when FIND button is pressed.
            if(!myFrame.pathField.getText().equals("") && !myFrame.jTextField.getText().equals("")) {
                File tempFile = new File(myFrame.getPath());
                if(tempFile.isDirectory() && tempFile.exists()) {
                    main.doAll();
                }else if(tempFile.isFile() && tempFile.exists()) {
                    main.doAllForOneFile();
                }else {
                    JOptionPane.showMessageDialog(null, "please check if your path is correct\nand then try again!", "ERROR", JOptionPane.WARNING_MESSAGE);
                }
            }
    }
}
