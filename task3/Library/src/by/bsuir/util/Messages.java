package by.bsuir.util;

import by.bsuir.enums.MessagesEnum;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by EgorVeremeychik on 02.02.2016.
 */
public class Messages {
    private static Properties properties = new Properties();
    private static final String PATH_TO_PROPS = "resources/messages.properties";

    public static String getMessage(MessagesEnum key){
        init();
        return properties.getProperty(key.getValue());
    }

    private static void init(){
        try {
            properties.load(new FileReader(PATH_TO_PROPS));
        } catch (IOException e) {
            ExceptionHandler.handle(e);
        }
    }
}
