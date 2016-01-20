package by.epam.training.service.util;

import by.epam.training.enums.MessagesEnum;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * Created by EgorVeremeychik on 20.01.2016.
 */
public class Messages {
    private static Properties props = new Properties();
    private static final String PATH_TO_PROPS = "resources/messages.properties";

    public static String getMessage(MessagesEnum key){
        init();
        return props.getProperty(key.getValue());
    }

    private static void init(){
        try{
            props.load(new FileReader(new File(PATH_TO_PROPS)));
        }catch (IOException e){
            ExceptionHandler.handle(e);
        }
    }
}
