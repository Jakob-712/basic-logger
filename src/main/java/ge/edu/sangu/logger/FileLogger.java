package ge.edu.sangu.logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileLogger extends Logger {

    private final String filePath;

    public FileLogger(String name, String filePath) {
        super(name);
        this.filePath = filePath;
    }

    @Override
    protected void writeToOutput(String output) {
        try {
            Files.writeString(Path.of(filePath), output, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
