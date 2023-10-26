package lab3;

import lab3.files.File;
import lab3.files.ImageFile;
import lab3.files.TextFile;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
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
        Files.list(Paths.get(FOLDER_PATH)).forEach(this::loadFile);
    }

    private void loadFile(Path path) {
        String fileName = path.getFileName().toString();
        try {
            if (fileName.endsWith(".txt")) {
                filesMap.put(path, new TextFile(path));
            } else if (fileName.endsWith(".png") || fileName.endsWith(".jpg")) {
                filesMap.put(path, new ImageFile(path));
            } // TODO add "Program" file type
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void commit() throws IOException {
        Map<Path, File> addedFiles = new HashMap<>();
        Map<Path, File> deletedFiles = new HashMap<>(filesMap);

        Files.list(Paths.get(FOLDER_PATH)).forEach(path -> {
            if (!filesMap.containsKey(path)) {
                System.out.println(path.getFileName() + " - added");
                loadFile(path);
            }
            deletedFiles.remove(path);
        });

        deletedFiles.forEach((path, file) -> System.out.println(path.getFileName() + " - deleted"));

        filesMap.putAll(addedFiles);
        filesMap.keySet().removeAll(deletedFiles.keySet());

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

    private void status() throws IOException {
        Map<Path, FileTime> currentFiles = new HashMap<>();

        Files.list(Paths.get(FOLDER_PATH)).forEach(path -> {
            try {
                BasicFileAttributes attributes = Files.readAttributes(path, BasicFileAttributes.class);
                currentFiles.put(path, attributes.lastModifiedTime());
            } catch (IOException e) {
                System.out.println("Failed to get file attributes for " + path.getFileName());
            }
        });

        for (Map.Entry<Path, File> entry : filesMap.entrySet()) {
            Path path = entry.getKey();
            //File file = entry.getValue();

            if (currentFiles.containsKey(path)) {
                // if file still exists
                if (currentFiles.get(path).toMillis() > lastCommitTime) {
                    System.out.println(path.getFileName() + " - changed");
                } else {
                    System.out.println(path.getFileName() + " - no changes");
                }
            } else {
                // if file has been deleted
                System.out.println(path.getFileName() + " - deleted");
            }
        }

        currentFiles.keySet().forEach(path -> {
            if (!filesMap.containsKey(path)) {
                System.out.println(path.getFileName() + " - added");
            }
        });
    }
}