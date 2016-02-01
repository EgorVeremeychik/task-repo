package by.bsuir.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by EgorVeremeychik on 02.02.2016.
 */
public class ExceptionHandler {
    private static Logger LOG = Logger.getLogger(ExceptionHandler.class);
    private static final String PATH_TO_XML = "log4j.xml";

    static {
        new DOMConfigurator().doConfigure(PATH_TO_XML, LogManager.getLoggerRepository());
    }

    public static void handle(Throwable e){
        LOG.error(e.getMessage(), e);
    }
}
