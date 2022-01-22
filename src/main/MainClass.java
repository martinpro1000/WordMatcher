package main;
import files.*;
import gui.*;

import javax.swing.*;
import java.io.*;
/*
* This program has been created by martinpro1000 (github).
* It is an opensource program.
*/
public class MainClass {
    MyFrame frame = new MyFrame(this);
    public MainClass() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {

        frame.createAndShowGUI();

    }

    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
        new MainClass();
    }
    public void doAll() {
        //creating instances of classes, if directory is selected
        Text textFiles = new Text(frame);
        textFiles.getTxtFilesMatch(frame.getPath(), frame.getMatcher());
        //Gz gzFiles = new Gz();
        Zip zip = new Zip(frame);
        zip.getMatchInZipFiles(frame.getPath(), frame.getMatcher());
        Gz gz = new Gz(frame);
        gz.gizFileMatcher(frame.getPath(), frame.getMatcher());
        int countsum = textFiles.i+zip.i+gz.i;
        int linesum = textFiles.x+zip.x+ gz.x;
        /*System.out.println("total line count = " + linesum);
        System.out.println("total word mathes = " + countsum);*/
        String textForResoult = "total line count = " + linesum + "\n"
                + "total word matches = " + countsum;
        JOptionPane.showMessageDialog(null, textForResoult, "RESULT", JOptionPane.INFORMATION_MESSAGE);

    }

    public void doAllForOneFile() {
        //creating instances of classes, if file is selected
        Text textFile = new Text(frame);
        textFile.getTxtFileMatch1(frame.getPath(), frame.getMatcher());
        Zip zip = new Zip(frame);
        zip.getMatchInZipFiles1(frame.getPath(), frame.getMatcher());
        Gz gz = new Gz(frame);
        gz.gizFileMatcherWithOneFile(frame.getPath(), frame.getMatcher());
        int countsum = textFile.i2+zip.i2+gz.i2;
        int linesum = textFile.x2+zip.x2+gz.x2;
        /*System.out.println("total line count = " + linesum);
        System.out.println("total word matches = " + countsum);*/
        String textForResoult = "total line count = " + linesum + "\n"
                + "total word matches = " + countsum;
        JOptionPane.showMessageDialog(null, textForResoult, "RESULT", JOptionPane.INFORMATION_MESSAGE);
    }
}
