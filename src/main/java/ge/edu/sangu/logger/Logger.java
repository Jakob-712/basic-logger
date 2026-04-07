package ge.edu.sangu.logger;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public abstract class Logger {

    private final String name;
    private final Formatter formatter;

    public Logger(String name) {
        this(name, Formatter.DEFAULT);
    }

    public Logger(String name, Formatter formatter) {
        this.name = name;
        this.formatter = formatter;
    }

    public String getName() {
        return name;
    }

    public Formatter getFormatter() {
        return formatter;
    }

    public void trace(String message, Object... args) {
        print(Level.TRACER, message, args);
    }

    public void debug(String message, Object... args) {
        print(Level.DEBUG, message, args);
    }

    public void info(String message, Object... args) {
        print(Level.INFO, message, args);
    }

    public void warn(String message, Object... args) {
        print(Level.WARN, message, args);
    }

    public void error(String message, Object... args) {
        print(Level.ERROR, message, args);
    }

    protected void print(@NotNull Level level,String message,Object... args) {
        if(message==null) {
            throw new IllegalArgumentException("log message must not be null or empty");
        };
        if(message.isBlank()) {
            throw new IllegalArgumentException("log message must not be empty");
        }
        writeToOutput(
                String.format(formatter.format(name, level, message), args)
        );
    }

    protected abstract void writeToOutput(String output);
}
