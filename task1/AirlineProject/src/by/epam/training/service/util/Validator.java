package by.epam.training.service.util;

import by.epam.training.entities.Aircompany;
import by.epam.training.entities.Plane;
import by.epam.training.entities.civil.CivilPlane;
import by.epam.training.entities.civil.passenger.PassengerPlane;
import by.epam.training.entities.civil.transport.TransportPlane;
import by.epam.training.entities.military.MilitaryPlane;
import by.epam.training.entities.military.bomber.BomberPlane;
import by.epam.training.entities.military.fighter.FighterPlane;
import sun.rmi.runtime.Log;

import java.util.logging.Logger;

/**
 * Created by EgorVeremeychik on 05.11.2015.
 */
public class Validator {

    private static boolean validate(Plane plane) {
        return true;
    }

    public static boolean validateFighterPlane(FighterPlane fighterPlane) {
        if (fighterPlane == null)
            return false;
        if (fighterPlane.getName() == null || fighterPlane.getName().length() < 1)
            return false;
        if (fighterPlane.getCapacity() < 1)
            return false;
        if (fighterPlane.getCarrying() < 0)
            return false;
        if (fighterPlane.getFuelConsumption() < 0)
            return false;
        if (fighterPlane.getFlyDistance() < 0)
            return false;
        if (fighterPlane.getPurpose() == null)
            return false;
        if (fighterPlane.getNumberOfMissiles() < 0)
            return false;
        return validate(fighterPlane);
    }

    public static boolean validateBomberPlane(BomberPlane bomberPlane) {
        if (bomberPlane == null)
            return false;
        if (bomberPlane.getName() == null || bomberPlane.getName().length() < 1)
            return false;
        if (bomberPlane.getCapacity() < 1)
            return false;
        if (bomberPlane.getCarrying() < 0)
            return false;
        if (bomberPlane.getFuelConsumption() < 0)
            return false;
        if (bomberPlane.getFlyDistance() < 0)
            return false;
        if (bomberPlane.getPurpose() == null)
            return false;
        if (bomberPlane.getNumberOfBombs() < 0)
            return false;
        return validate(bomberPlane);
    }

    public static boolean validatePassengerPlane(PassengerPlane passengerPlane) {
        if (passengerPlane.getBusinessClass() < 0)
            return false;
        if (passengerPlane.getEconomyClass() < 0)
            return false;
        return validate(passengerPlane);
    }

    public static boolean validateTransportPlane(TransportPlane transportPlane) {
        if (transportPlane.isLoader() != true || transportPlane.isLoader() != false)
            return false;
        return validate(transportPlane);
    }

    public static boolean validateCivilPlane(CivilPlane civilPlane) {
        if (civilPlane.getLuggageCapacity() < 0)
            return false;
        return validate(civilPlane);
    }

    public static boolean validateAircompany(Aircompany aircompany) {
        if (aircompany == null || aircompany.getPlanes() == null)
            return false;
        return true;
    }
}
