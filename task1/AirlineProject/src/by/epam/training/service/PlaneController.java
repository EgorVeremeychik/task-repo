package by.epam.training.service;

import by.epam.training.entities.Aircompany;
import by.epam.training.entities.Plane;
import by.epam.training.service.util.XMLPlanesReader;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by EgorVeremeychik on 19.10.2015.
 */
public class PlaneController {
    private Aircompany aircompany;

    public Aircompany createAircompany() {
        XMLPlanesReader xmlPlanesReader = new XMLPlanesReader();
        aircompany = xmlPlanesReader.read();
        return aircompany;
    }

    public int getCapacity() {
        int result = 0;
        ArrayList<Plane> planes = aircompany.getPlanes();

        for (Plane plane : planes) {
            result += plane.getCapacity();
        }
        System.out.println("All capacity = " + result);
        return 0;
    }

    public double getCarrying() {
        double result = 0;
        ArrayList<Plane> planes = aircompany.getPlanes();

        for (Plane plane : planes) {
            result += plane.getCarrying();
        }
        System.out.println("All carrying = " + result);
        return 0;
    }

    public void getFuelConsumption(double from, double to) {
        ArrayList<Plane> result = new ArrayList();
        ArrayList<Plane> planes = aircompany.getPlanes();
        System.out.println("Fuel consumption from " + from + " to " + to + ":");
        for (Plane plane : planes) {
            if ((plane.getFuelConsumption() <= to) && (plane.getFuelConsumption() >= from)) {
                result.add(plane);
            }
        }
        System.out.println("\t" + result);
    }

    public void sortPlane(Comparator<Plane> comparator) {
        ArrayList<Plane> planes = aircompany.getPlanes();
        planes.sort(comparator);
        aircompany.setPlanes(planes);
        System.out.println("All planes sorted by fly distance:");
        System.out.println(aircompany);
    }
}
