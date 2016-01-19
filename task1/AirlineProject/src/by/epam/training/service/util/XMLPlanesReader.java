package by.epam.training.service.util;

import by.epam.training.builder.Builder;
import by.epam.training.builder.BuilderFactory;
import by.epam.training.entities.Aircompany;
import by.epam.training.entities.military.fighter.FighterPlane;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by EgorVeremeychik on 24.10.2015.
 */

public class XMLPlanesReader {
    private Builder builder;
    Aircompany aircompany;


    public Aircompany read() {
        Aircompany aircompany = new Aircompany();
        try {
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

                aircompany.add(builder.getResult());
            }

        } catch (Exception e){
            e.printStackTrace();
        }
        return aircompany;
    }
}
