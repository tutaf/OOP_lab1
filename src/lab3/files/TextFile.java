package lab3.files;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class TextFile extends File {
    public TextFile(Path filePath) throws IOException {
        super(filePath);
    }

    @Override
    public void info() {
        System.out.println("filename: " + filePath.getFileName());
        System.out.println("extension: .txt");
        System.out.println("created at: " + attributes.creationTime());
        System.out.println("modified at: " + attributes.lastModifiedTime());

        try (Scanner scanner = new Scanner(filePath)) {
            int lineCount = 0, wordCount = 0, charCount = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                charCount += line.length();
                wordCount += line.split("\\s+").length;
                lineCount++;
            }
            System.out.println("lines: " + lineCount);
            System.out.println("words: " + wordCount);
            System.out.println("characters: " + charCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
