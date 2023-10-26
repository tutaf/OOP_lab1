package lab3.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;

public abstract class File {
    Path filePath;
    public BasicFileAttributes attributes;

    public File(Path filePath) throws IOException {
        this.filePath = filePath;
        this.attributes = Files.readAttributes(filePath, BasicFileAttributes.class);
    }

    public abstract void info();
}
