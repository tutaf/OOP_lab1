package lab3.files;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProgramFile extends File {
    private static final Pattern METHOD_PATTERN = Pattern.compile("(public|protected|private|static|\\s) +[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *\\{? *\\n?");
    private static final Pattern CLASS_PATTERN = Pattern.compile("\\bclass\\s+\\w+");

    public ProgramFile(Path filePath) throws IOException {
        super(filePath);
    }

    @Override
    public void info() {
        printBasicInfo();

        try {
            String content = new String(Files.readAllBytes(filePath));
            Matcher classMatcher = CLASS_PATTERN.matcher(content);
            Matcher methodMatcher = METHOD_PATTERN.matcher(content);

            int classCount = 0;
            while (classMatcher.find()) {
                classCount++;
            }

            int methodCount = 0;
            while (methodMatcher.find()) {
                methodCount++;
            }

            System.out.println("classes: " + classCount);
            System.out.println("methods: " + methodCount);
        } catch (IOException e) {
            System.out.println("Error reading program file: " + e.getMessage());
        }
    }
}