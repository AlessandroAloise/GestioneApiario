
import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 *
 * @author alessandro.aloise
 */
public class Log {

    static private FileHandler fileTxt;
    static private SimpleFormatter formatterTxt;

    static public void setup() throws IOException {

        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        /*
        Logger rootLogger = ("")*Logger.getLogger(logger);
        Handler[] handlers = rootLogger.getHandlers();
        if (handlers[0] instanceof ConsoleHandler) {
            rootLogger.removeHandler(handlers[0]);
        }*/
         
        logger.setLevel(Level.INFO);
        fileTxt = new FileHandler("Logging.txt");

        // create a TXT formatter
        formatterTxt = new SimpleFormatter();
        fileTxt.setFormatter(formatterTxt);
        logger.addHandler(fileTxt);

    }
}
