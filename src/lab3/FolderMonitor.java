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
            System.out.println("Enter action (commit, info <filename or full path>, status):");
            String input = scanner.nextLine();
            String[] inputParts = input.split("\\s+", 2);

            if (input.equals("commit")) {
                commit();
            } else if (inputParts[0].equals("info")) {
                if (inputParts.length > 1) {
                    String fileInfo = inputParts[1];
                    if (isFullPath(fileInfo)) {
                        info(Paths.get(fileInfo));
                    } else {
                        info(fileInfo);
                    }
                } else {
                    System.out.println("File name or path not specified.");
                }
            } else if (input.equals("status")) {
                status();
            } else {
                System.out.println("Unknown command.");
            }
        }
    }

    private boolean isFullPath(String path) {
        return path.contains(":\\");
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
        if (Files.exists(filePath)) {
            File file = filesMap.get(filePath);
            if (file == null) {
                try {
                    if (fileName.endsWith(".txt")) {
                        file = new TextFile(filePath);
                    } else if (fileName.endsWith(".png") || fileName.endsWith(".jpg")) {
                        file = new ImageFile(filePath);
                    } // TODO add ProgramFile
                    file.info();
                } catch (IOException e) {
                    System.out.println("Error while loading info: " + e.getMessage());
                }
            } else {
                file.info();
            }
        } else {
            System.out.println("File not found");
        }
    }

    private void info(Path filePath) {
        if (Files.exists(filePath)) {
            try {
                File file;
                if (filePath.toString().endsWith(".txt")) {
                    file = new TextFile(filePath);
                } else if (filePath.toString().endsWith(".png") || filePath.toString().endsWith(".jpg")) {
                    file = new ImageFile(filePath);
                } else {
                    System.out.println("Unsupported file type");
                    return;
                }
                file.info();
            } catch (IOException e) {
                System.out.println("Error while getting info: " + e.getMessage());
            }
        } else {
            System.out.println("File not found");
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