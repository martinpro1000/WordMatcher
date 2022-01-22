package files;

import gui.*;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.zip.*;

public class Gz {
    public int i = 0;
    public int x = 0;
    public int x2 = 0;
    public int i2 = 0;
    private Scanner sc;
    private Scanner sc2;
    MyFrame myFrame;

    public Gz(MyFrame myFrame) {
        this.myFrame = myFrame;
    }

    public void gizFileMatcher(String directory, String matchWord) {
        //loops through every file in the directory and check how many times it matches to the user's word!
        //with .gz files
        try {
            File file = new File(directory);
            for(File currentFile : file.listFiles()) {
                if (currentFile.exists() && currentFile.isFile() && currentFile.getName().endsWith(".gz")) {
                    //BufferedReader reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(currentFile))));
                    sc = new Scanner(new InputStreamReader(new GZIPInputStream(new FileInputStream(currentFile))));

                    while (sc.hasNextLine()) {
                        x++;
                        String currentLine = sc.nextLine();
                        Pattern pattern;
                        if(myFrame.toUpperCase.isSelected()) {
                            pattern = Pattern.compile(matchWord, Pattern.CASE_INSENSITIVE);
                        }else {
                            pattern = Pattern.compile(matchWord);
                        }
                        Matcher matcher = pattern.matcher(currentLine);
                        while (matcher.find()) {
                            i++;
                        }
                    }
                }
            }
            /*System.out.println("lines " + x);
            System.out.println("equality " + i);*/
                if(sc != null) {
                    sc.close();
                }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "error with reading the giz file,\nplease reboot the process\nif this message keeps showing please check the files!", "ERROR READING", JOptionPane.ERROR_MESSAGE);
        }
    }
    public void gizFileMatcherWithOneFile(String fileInput, String matchWord) {
        //check if the user's word matches (for only one file).
        //with .gz file
        try {
                 File file = new File(fileInput);
                if (file.exists() && file.isFile() && file.getName().endsWith(".gz")) {
                    //BufferedReader reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream(currentFile))));
                    sc2 = new Scanner(new InputStreamReader(new GZIPInputStream(new FileInputStream(file))));

                    while (sc2.hasNextLine()) {
                        x2++;
                        String currentLine = sc2.nextLine();
                        Pattern pattern;
                        if(myFrame.toUpperCase.isSelected()) {
                            pattern = Pattern.compile(matchWord, Pattern.CASE_INSENSITIVE);
                        }else {
                            pattern = Pattern.compile(matchWord);
                        }
                        Matcher matcher = pattern.matcher(currentLine);
                        while (matcher.find()) {
                            i2++;
                        }
                    }
                   /* System.out.println("lines " + x2);
                    System.out.println("equality " + i2);
                    System.out.println("single gz");*/
                }



            if(sc2 != null) {
                sc2.close();
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "error with reading the giz file,\nplease reboot the process\nif this message keeps showing please check the files!", "ERROR READING", JOptionPane.ERROR_MESSAGE);
        }
    }
}
