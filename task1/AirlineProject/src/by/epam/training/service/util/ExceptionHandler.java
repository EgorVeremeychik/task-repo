package by.epam.training.service.util;

import by.epam.training.enums.MessagesEnum;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by EgorVeremeychik on 20.01.2016.
 */
public class ExceptionHandler {
    private static Logger LOG = Logger.getLogger(ExceptionHandler.class);
    private static final String PATH_TO_XML = "log4j.xml";
    private static final int FAIL_STATUS = -1;

    static {
        new DOMConfigurator().doConfigure(PATH_TO_XML, LogManager.getLoggerRepository());
    }

    public static void start(){
        LOG.info(Messages.getMessage(MessagesEnum.PROJECT_START));
    }

    public static void end(){
        LOG.info(Messages.getMessage(MessagesEnum.PROJECT_END));
    }

    public static void handle(Throwable e,MessagesEnum code){
        LOG.error(Messages.getMessage(code), e);
        System.exit(FAIL_STATUS);
    }

    public static void handle(Throwable e){
        LOG.error(e.getMessage(), e);
        System.exit(FAIL_STATUS);
    }
}
