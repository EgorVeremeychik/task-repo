package by.bsuir.enums;

/**
 * Created by EgorVeremeychik on 02.02.2016.
 */
public enum MessagesEnum {
    LIBRARY_START_WORK("library.start.work"),
    PROCESSING("processing"),
    LIBRARY_STOPED_GIVE_BOOKS("library.stoped.give.books"),
    LIBRARY_END_WORK("library.end.work"),
    LIBRARY("library"),
    READ_BOOKS_FROM_XML_STARTED("read.books.from.xml.started"),
    READ_BOOKS_FROM_XML_FINISHED("read.books.from.xml.finished"),
    READ_READERS_FROM_XML_STARTED("read.readers.from.xml.started"),
    READ_READERS_FROM_XML_FINISHED("read.readers.from.xml.finished");

    String value;

    MessagesEnum(String key){
        this.value = key;
    }

    public String getValue(){
        return this.value;
    }
}
