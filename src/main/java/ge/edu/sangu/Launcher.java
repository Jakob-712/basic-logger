package ge.edu.sangu;

import ge.edu.sangu.logger.ConsoleLogger;
import ge.edu.sangu.logger.Logger;

import java.util.Random;

public class    Launcher {
    private static final Logger logger = new ConsoleLogger("Launcher");

    public static void main(String[] args) {
        try {
            logger.info("Application started");
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
                logger.debug("Sum at iteration %d is %d", i, sum);
            }

            if (new Random().nextBoolean()) {
                throw new Exception("Random Exception");
            }

            logger.info("Sum = %d", sum);
            logger.info("Application finished");
        } catch (Exception exception) {
            exception.printStackTrace(System.out);
        }finally {
            logger.info("Finally Application finished");
        }
    }
}
