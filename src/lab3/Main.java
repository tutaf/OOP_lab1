package lab3;

import java.io.*;


public class Main {
    public static void main(String[] args) {
        FolderMonitor monitor = new FolderMonitor("D:/testfolder");
        try {
            monitor.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
