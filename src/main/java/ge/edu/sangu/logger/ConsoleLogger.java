package ge.edu.sangu.logger;

public class ConsoleLogger extends Logger {
    public ConsoleLogger(String name) {
        super(name);
    }

    @Override
    protected void writeToOutput(String output) {
        System.out.print(output);
    }
}
