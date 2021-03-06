package by.epam.training.service.util;

import by.epam.training.builder.Builder;
import by.epam.training.builder.BuilderFactory;
import by.epam.training.entities.Aircompany;
import by.epam.training.entities.civil.passenger.PassengerPlane;
import by.epam.training.entities.civil.transport.TransportPlane;
import by.epam.training.entities.military.bomber.BomberPlane;
import by.epam.training.entities.military.fighter.FighterPlane;
import by.epam.training.enums.MessagesEnum;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

import org.apache.log4j.*;


/**
 * Created by EgorVeremeychik on 24.10.2015.
 */

public class XMLPlanesReader {

    private static org.apache.log4j.Logger LOG = Logger.getLogger(XMLPlanesReader.class);
    private Builder builder;
    Aircompany aircompany;


    public Aircompany read() throws NumberFormatException, IllegalArgumentException, IOException, SAXException, ParserConfigurationException {
        Aircompany aircompany = new Aircompany();
        File file = new File("resources/aircompany.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        documentBuilder = factory.newDocumentBuilder();
        Document document = documentBuilder.parse(file);

        NodeList nodeList = document.getElementsByTagName("plane");

        for (int i = 0; nodeList.getLength() > i; i++) {
            Node node = nodeList.item(i);
            Element element = (Element) node;
            String type = element.getAttribute("type");
            builder = BuilderFactory.newBuilder(type);

            for (int q = 1; q < element.getChildNodes().getLength(); q += 2) {
                String argName = element.getChildNodes().item(q).getNodeName();
                String argValue = element.getChildNodes().item(q).getTextContent();
                builder.setArg(argName, argValue);
            }
            switch (type) {
                case "FighterPlane":
                    if (!Validator.validateFighterPlane((FighterPlane)builder.getResult()))
                        throw new IllegalArgumentException(Messages.getMessage(MessagesEnum.VALIDATE_FAIL));
                    break;
                case "BomberPlane":
                    if (!Validator.validateBomberPlane((BomberPlane) builder.getResult()))
                        throw new IllegalArgumentException(Messages.getMessage(MessagesEnum.VALIDATE_FAIL));
                    break;
                case "PassengerPlane":
                    if (!Validator.validatePassengerPlane((PassengerPlane) builder.getResult()))
                        throw new IllegalArgumentException(Messages.getMessage(MessagesEnum.VALIDATE_FAIL));
                    break;
                case "TransportPlane":
                    if (!Validator.validateTransportPlane((TransportPlane) builder.getResult()))
                        throw new IllegalArgumentException(Messages.getMessage(MessagesEnum.VALIDATE_FAIL));
                    break;

            }
            aircompany.add(builder.getResult());
        }
        return aircompany;
    }
}
