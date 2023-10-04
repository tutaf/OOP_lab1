package lab2;

import lab2.entities.University;

import java.io.*;

public class SaveManager {

    public void saveState(University university, String filename) {
        try (FileOutputStream fileOut = new FileOutputStream(filename);
             ObjectOutputStream out = new ObjectOutputStream(fileOut)) {
            out.writeObject(university);
            System.out.println("State saved to " + filename);
        } catch (IOException i) {
            i.printStackTrace();
        }
    }

    public University restoreState(String filename) {
        University university = null;
        try (FileInputStream fileIn = new FileInputStream(filename);
             ObjectInputStream in = new ObjectInputStream(fileIn)) {
            university = (University) in.readObject();
            System.out.println("State loaded from " + filename);
        } catch (IOException i) {
//            i.printStackTrace();
            return null;
        } catch (ClassNotFoundException c) {
            System.out.println("Class not found");
            c.printStackTrace();
            return null;
        }
        return university;
    }
}
