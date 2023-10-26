package lab3.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public abstract class File {
    Path filePath;
    public BasicFileAttributes attributes; // TODO make path and attributes private

    public File(Path filePath) throws IOException {
        this.filePath = filePath;
        this.attributes = Files.readAttributes(filePath, BasicFileAttributes.class);
    }

    protected void printBasicInfo() {
        System.out.println("filename: " + filePath.getFileName());
        System.out.println("extension: .txt");
        System.out.println("created at: " + attributes.creationTime());
        System.out.println("modified at: " + attributes.lastModifiedTime());
    }

    private String getFileExtension(String fileName) {
        int dotIndex = fileName.lastIndexOf('.');
        if (dotIndex == -1) {
            return "";
        }
        return fileName.substring(dotIndex + 1);
    }

    public abstract void info();
}
