package test.java.helper;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import test.java.common.Constant;

import java.io.File;

public class Logger {
    private org.apache.logging.log4j.Logger logger;

    public Logger(final Class<?> classObject) {
        logger = LogManager.getLogger(classObject);
        LoggerContext context = (LoggerContext) LogManager.getContext(false);
        File file = new File(Constant.LOG4J_PATH);
        context.setConfigLocation(file.toURI());
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void fatal(String message) {
        logger.fatal(message);
    }

    public void info(String message) {
        logger.info(message);
    }

    public void log(Level level, String message) {
        logger.log(level, message);
    }

    public void trace(String message) {
        logger.trace(message);
    }

    public void warn(String message) {
        logger.warn(message);
    }
}
