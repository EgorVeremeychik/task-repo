package by.epam.training.service;

import by.epam.training.entities.Aircompany;
import by.epam.training.entities.Plane;
import by.epam.training.service.util.Validator;
import by.epam.training.service.util.XMLPlanesReader;

import java.util.ArrayList;
import java.util.Comparator;

import org.apache.log4j.*;
import org.apache.log4j.xml.DOMConfigurator;

/**
 * Created by EgorVeremeychik on 19.10.2015.
 */
public class PlaneController {

    private static Logger LOG = Logger.getLogger(PlaneController.class);

    private Aircompany aircompany;

    public Aircompany createAircompany() {
        try {
            {
                new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
            }
            XMLPlanesReader xmlPlanesReader = new XMLPlanesReader();
            aircompany = xmlPlanesReader.read();
            LOG.info("Aircompany created successful!");
        } catch (Exception e) {
            LOG.error(e);
            System.exit(-1);
        }
        return aircompany;
    }

    public void getCapacity() {
        try {
            LOG.debug("Method getAllCapacity called!");
            if (!Validator.validateAircompany(aircompany))
                throw new IllegalArgumentException();
            int result = 0;
            ArrayList<Plane> planes = aircompany.getPlanes();

            for (Plane plane : planes) {
                result += plane.getCapacity();
            }
            System.out.println("All capacity = " + result);
            LOG.info("All capacity = " + result);
        } catch (Exception e) {
            LOG.error(e);
            System.exit(-1);
        }
    }

    public void getCarrying() {
        try {
            LOG.debug("Method getAllCarrying called!");
            if (!Validator.validateAircompany(aircompany))
                throw new IllegalArgumentException();
            double result = 0;
            ArrayList<Plane> planes = aircompany.getPlanes();

            for (Plane plane : planes) {
                result += plane.getCarrying();
            }
            System.out.println("All carrying = " + result);
            LOG.info("All carrying = " + result);
        } catch (Exception e) {
            LOG.error(e);
            System.exit(-1);
        }
    }

    public void getFuelConsumption(double from, double to) {
        try {
            LOG.debug("Method getFuelConsumption from " + from + " to " + to + "called!");
            if (!Validator.validateAircompany(aircompany))
                throw new IllegalArgumentException();
            ArrayList<Plane> result = new ArrayList();
            ArrayList<Plane> planes = aircompany.getPlanes();
            System.out.println("Fuel consumption from " + from + " to " + to + ":");
            for (Plane plane : planes) {
                if ((plane.getFuelConsumption() <= to) && (plane.getFuelConsumption() >= from)) {
                    result.add(plane);
                }
            }
            for (Plane plane : result) {
                System.out.println("\t" + plane);
            }
        } catch (Exception e) {
            LOG.error(e);
            System.exit(-1);
        }
    }

    public void sortPlane(Comparator<Plane> comparator) {
        try {
            LOG.debug("Method sortPlane called!");
            if (!Validator.validateAircompany(aircompany))
                throw new IllegalArgumentException();
            ArrayList<Plane> planes = aircompany.getPlanes();
            planes.sort(comparator);
            aircompany.setPlanes(planes);
            System.out.println("All planes sorted by fly distance:");
            System.out.println(aircompany);
            LOG.info("All planes sorted by fly distance!");
        } catch (Exception e) {
            LOG.error(e);
            System.exit(-1);
        }
    }
}
