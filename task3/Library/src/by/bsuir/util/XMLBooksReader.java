package by.bsuir.util;

import by.bsuir.entity.Book;
import by.bsuir.entity.Library;
import by.bsuir.enums.BookPlaceEnum;
import by.bsuir.enums.MessagesEnum;
import javafx.util.BuilderFactory;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.w3c.dom.NodeList;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by EgorVeremeychik on 21.01.2016.
 */
public class XMLBooksReader {

    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }

    private static Logger LOG = Logger.getLogger(XMLBooksReader.class);
    private static final String PATH_TO_BOOKS_XML = "resources/books.xml";

    public static List<Book> read() {
        List<Book> books = new ArrayList<>();
        try {
            LOG.info(Messages.getMessage(MessagesEnum.READ_BOOKS_FROM_XML_STARTED));
            File file = new File(PATH_TO_BOOKS_XML);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder;
            documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            NodeList nodeList = document.getElementsByTagName("book");

            for (int i = 0; nodeList.getLength() > i; i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;
                Book book = new Book();
                String argNameBook = element.getElementsByTagName("name").item(0).getTextContent();
                String argPlace = element.getElementsByTagName("place").item(0).getTextContent();
                BookPlaceEnum place = BookPlaceEnum.valueOf(argPlace.toUpperCase());
                book.setBookName(argNameBook);
                book.setPlace(place);
                books.add(book);
            }
            LOG.info(Messages.getMessage(MessagesEnum.READ_BOOKS_FROM_XML_FINISHED));
        } catch (Exception e) {
            ExceptionHandler.handle(e);
        }
        return books;
    }
}