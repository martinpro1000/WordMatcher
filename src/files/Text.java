package files;

import gui.*;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;

public class Text {
    public int i = 0;
    public int x = 0;
    public int i2 = 0;
    public int x2 = 0;
    private Scanner sc;
    private Scanner sc2;
    MyFrame myFrame;
    public Text(MyFrame myFrame) {
        this.myFrame = myFrame;
    }

    public void getTxtFilesMatch(String directory, String wordMatch) {
        //loops through every file in the directory and check how many times it matches to the user's word!
        //with .txt files
        try {
            File file = new File(directory);
            for (File currentFile : file.listFiles()) {
                if (currentFile.exists() && currentFile.isFile() && currentFile.getName().endsWith(".txt")) {
                    sc = new Scanner(currentFile);
                    while (sc.hasNextLine()) {
                        x++;
                        String line = sc.nextLine();
                        Pattern pattern;
                        if(myFrame.toUpperCase.isSelected()) {
                            pattern = Pattern.compile(wordMatch, Pattern.CASE_INSENSITIVE);
                        }else {
                            pattern = Pattern.compile(wordMatch);
                        }
                        Matcher matcher = pattern.matcher(line);
                        while (matcher.find()) {
                            i++;
                        }
                        //}
                    }

                }
            }
                /*ystem.out.println("lines = " + x);
                System.out.println("equality = " + i);*/
                    if(sc != null) {
                     sc.close();
                     System.out.println("scanner closed");
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "error with reading the text file,\nplease reboot the process\nif this message keeps showing please check the files!", "READING ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void getTxtFileMatch1(String fileInput, String wordMatch) {
        //check if the user's word matches (for only one file).
        //with .txt file

        try {
            File file = new File(fileInput);
                if (file.exists() && file.isFile() && file.getName().endsWith(".txt")) {
                    sc2 = new Scanner(file);
                    while (sc2.hasNextLine()) {
                        x2++;
                        String line = sc2.nextLine();
                        Pattern pattern;
                        if(myFrame.toUpperCase.isSelected()) {
                            pattern = Pattern.compile(wordMatch, Pattern.CASE_INSENSITIVE);
                        }else {
                            pattern = Pattern.compile(wordMatch);
                        }
                        Matcher matcher = pattern.matcher(line);
                        while (matcher.find()) {
                            i2++;
                        }
                        //}
                }
                    /*System.out.println("lines = " + x2);
                    System.out.println("equality = " + i2);
                    System.out.println("single text");*/
                    if(sc2 != null) {
                        sc2.close();
                    }
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "error with reading the text file,\nplease reboot the process\nif this message keeps showing please check the files!", "READING ERROR", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }

}
