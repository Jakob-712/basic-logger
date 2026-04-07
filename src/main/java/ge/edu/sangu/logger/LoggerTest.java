package ge.edu.sangu.logger;

public class LoggerTest {
    public static void main(String[] args) {
        Logger logger = new ConsoleLogger("LoggerTest");

        System.out.println("--- Testing logs ---");
        logger.info("This is a right message.");
        logger.warn("This is a warning with a parameter: %s", "Check this!");

        System.out.println("\n");
        System.out.println("--- Testing exception --");

        try {
            logger.info(null);
        } catch (IllegalArgumentException exception) {
            System.out.println("Caught exception: " + exception.getMessage());
            System.out.println("Confirmation: Null message exception was handled correctly.");
        }



        try {
            logger.error("   ");
        } catch (IllegalArgumentException exception) {
            System.out.println("Caught exception: " + exception.getMessage());
            System.out.println("Confirmation: Empty or whitespace message exception was handled correctly.");
        }
        finally {
            System.out.println("\n---Finally executed---");
        }
    }
}