package files;

import gui.*;

import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.zip.*;

public class Zip {
    public int i = 0;
    public int x = 0;
    public int i2 = 0;
    public int x2 = 0;
    private Scanner sc;
    private Scanner sc2;
    MyFrame myFrame;

    public Zip(MyFrame myFrame) {
        this.myFrame = myFrame;
    }

    public void getMatchInZipFiles(String directory, String wordMatch) {
        //loops through every file in the directory and check how many times it matches to the user's word!
        //with .zip files
        File file = new File(directory);
        for (File currentFile : file.listFiles()) {
            if(currentFile.exists() && currentFile.isFile() && currentFile.getName().endsWith(".zip")) {

            try {
                ZipFile zf = new ZipFile(currentFile);
                Enumeration<? extends ZipEntry> entries = zf.entries();

                while (entries.hasMoreElements()) {
                    ZipEntry currentEntry = entries.nextElement();
                    //InputStream stream = zf.getInputStream(currentEntry);
                    sc = new Scanner(zf.getInputStream(currentEntry));
                    while (sc.hasNextLine()) {
                        x++;
                        String currentLine = sc.nextLine();
                        Pattern pattern;
                        //pattern = myFrame.toUpperCase.isSelected() ? Pattern.compile(wordMatch) : Pattern.compile(wordMatch, Pattern.CASE_INSENSITIVE);
                        if(myFrame.toUpperCase.isSelected()) {
                            pattern = Pattern.compile(wordMatch, Pattern.CASE_INSENSITIVE);
                        }else {
                            pattern = Pattern.compile(wordMatch);
                        }
                        Matcher matcher = pattern.matcher(currentLine);
                        while (matcher.find()) {
                            i++;
                        }
                    }
                }
                /*System.out.println("lines " + x);
                System.out.println("equality " + i);*/
                if (sc != null) {
                    sc.close();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "error with reading the zip file,\nplease reboot the process\nif this message keeps showing please check the files!", "READING ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

    public void getMatchInZipFiles1(String fileInput, String wordMatch) {
        //check if the user's word matches (for only one file).
        //with .zip file
        File file = new File(fileInput);
            if(file.exists() && file.isFile() && file.getName().endsWith(".zip")) {

                try {
                    ZipFile zf = new ZipFile(file);
                    Enumeration<? extends ZipEntry> entries = zf.entries();

                    while (entries.hasMoreElements()) {
                        ZipEntry currentEntry = entries.nextElement();
                        //InputStream stream = zf.getInputStream(currentEntry);
                        sc2 = new Scanner(zf.getInputStream(currentEntry));
                        while (sc2.hasNextLine()) {
                            x2++;
                            String currentLine = sc2.nextLine();
                            Pattern pattern;
                            if(myFrame.toUpperCase.isSelected()) {
                                pattern = Pattern.compile(wordMatch, Pattern.CASE_INSENSITIVE);
                            }else {
                                pattern = Pattern.compile(wordMatch);
                            }
                            Matcher matcher = pattern.matcher(currentLine);
                            while (matcher.find()) {
                                i2++;
                            }
                        }
                    }
                    /*System.out.println("lines " + x2);
                    System.out.println("equality " + i2);
                    System.out.println("single zip");*/
                    if (sc2 != null) {
                        sc2.close();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "error with reading the zip file,\nplease reboot the process\nif this message keeps showing please check the files!", "READING ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
    }
}
