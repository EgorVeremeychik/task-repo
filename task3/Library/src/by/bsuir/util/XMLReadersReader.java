package by.bsuir.util;

import by.bsuir.entity.ReaderAction;
import by.bsuir.entity.Reader;
import by.bsuir.enums.MessagesEnum;
import by.bsuir.enums.ReaderStateEnum;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by EgorVeremeychik on 22.01.2016.
 */
public class XMLReadersReader {

    private static Logger LOG = Logger.getLogger(XMLReadersReader.class);
    private static final String PATH_TO_READERS_XML = "resources/readers.xml";

    public static List<Reader> read() {
        List<Reader> readers = new ArrayList<>();
        try {
            LOG.info(Messages.getMessage(MessagesEnum.READ_READERS_FROM_XML_STARTED));
            File file = new File(PATH_TO_READERS_XML);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = null;
            documentBuilder = factory.newDocumentBuilder();
            Document document = documentBuilder.parse(file);
            NodeList nodeList = document.getElementsByTagName("reader");

            for (int i = 0; nodeList.getLength() > i; i++) {
                Node node = nodeList.item(i);
                Element element = (Element) node;
                Reader reader = new Reader();
                String argNameReader = element.getElementsByTagName("nameReader").item(0).getTextContent();
                String argState = element.getElementsByTagName("state").item(0).getTextContent();
                ReaderStateEnum state = ReaderStateEnum.valueOf(argState.toUpperCase());
                reader.setReaderName(argNameReader);
                reader.setState(state);
                reader.setReaderAction(new ReaderAction(reader));
                readers.add(reader);
            }
            LOG.info(Messages.getMessage(MessagesEnum.READ_READERS_FROM_XML_FINISHED));
        } catch (Exception e) {
            ExceptionHandler.handle(e);
        }
        return readers;
    }
}
