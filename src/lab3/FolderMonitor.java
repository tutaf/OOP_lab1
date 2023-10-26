package lab3;

import lab3.files.File;
import lab3.files.TextFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class FolderMonitor {
    private final String FOLDER_PATH;
    private Map<Path, File> filesMap = new HashMap<>();
    private long lastCommitTime = System.currentTimeMillis();

    public FolderMonitor(String folderPath) {
        FOLDER_PATH = folderPath;
    }

    public void run() throws IOException {
        loadFiles();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter action (commit, info <filename>, status):");
            String input = scanner.nextLine();
            if (input.equals("commit")) {
                commit();
            } else if (input.startsWith("info")) {
                info(input.split(" ")[1]);
            } else if (input.equals("status")) {
                status();
            }
        }
    }

    private void loadFiles() throws IOException {
        Files.list(Paths.get(FOLDER_PATH)).forEach(path -> {
            String fileName = path.getFileName().toString();
            try {
                if (fileName.endsWith(".txt")) {
                    filesMap.put(path, new TextFile(path));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void commit() {
        lastCommitTime = System.currentTimeMillis();
    }

    private void info(String fileName) {
        Path filePath = Paths.get(FOLDER_PATH, fileName);
        if (filesMap.containsKey(filePath)) {
            filesMap.get(filePath).info();
        } else {
            System.out.println("File not found!");
        }
    }

    private void status() {
        filesMap.forEach((path, file) -> {
            try {
                BasicFileAttributes currentAttributes = Files.readAttributes(path, BasicFileAttributes.class);
                long lastModifiedTime = currentAttributes.lastModifiedTime().toMillis();
                if (lastModifiedTime > lastCommitTime) {
                    System.out.println(path.getFileName() + " - changed");
                } else {
                    System.out.println(path.getFileName() + " - no changes");
                }
            } catch (IOException e) {
                System.out.println("Failed to get file attributes for " + path.getFileName());
            }
        });
    }

}
