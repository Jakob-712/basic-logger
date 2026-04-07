package ge.edu.sangu.logger;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class Formatter {
    public static final Formatter DEFAULT = new Formatter("[$d][$t][$l]: $m$n");

    private String format;

    public Formatter(String format) {
        this.format = format;
    }

    public String format(String name, Level level, String message) {
        String output = format;
        if (output.contains("$t")) {
            output = output.replaceAll(Pattern.quote("$t"), Thread.currentThread().getName());
        }
        if (output.contains("$l")) {
            output = output.replaceAll(Pattern.quote("$l"), name);
        }
        if (output.contains("$n")) {
            output = output.replaceAll(Pattern.quote("$n"), "\n");
        }
        if (output.contains("$l")) {
            output = output.replaceAll(Pattern.quote("$l"), level.name());
        }
        if (output.contains("$d")) {
            output = output.replaceAll(Pattern.quote("$d"), LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        }
        if (output.contains("$m")) {
            output = output.replaceAll(Pattern.quote("$m"), message);
        }
        return output;
    }
}
