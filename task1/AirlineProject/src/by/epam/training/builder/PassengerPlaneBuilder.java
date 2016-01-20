package by.epam.training.builder;

import by.epam.training.entities.Plane;
import by.epam.training.entities.civil.passenger.PassengerPlane;
import by.epam.training.enums.MessagesEnum;
import by.epam.training.service.util.Messages;
import org.apache.log4j.Logger;

/**
 * Created by EgorVeremeychik on 20.10.2015.
 */
public class PassengerPlaneBuilder implements Builder {

    private static Logger LOG = Logger.getLogger(PassengerPlaneBuilder.class);

    public PassengerPlaneBuilder(){LOG.info(Messages.getMessage(MessagesEnum.PASSENGER_PLANE_BUILDER_CALLED));}

    private PassengerPlane passenger = new PassengerPlane();

    public Plane getResult() {
        return passenger;
    }

    public void setArg(String name, String arg) {
        switch (name) {
            case "name":
                passenger.setName(arg);
                break;
            case "carrying":
                passenger.setCarrying(Double.parseDouble(arg));
                break;
            case "capacity":
                passenger.setCapacity(Integer.parseInt(arg));
                break;
            case "fuelConsumption":
                passenger.setFuelConsumption(Double.parseDouble(arg));
                break;
            case "flyDistance":
                passenger.setFlyDistance(Double.parseDouble(arg));
                break;
            case "luggageCapacity":
                passenger.setLuggageCapacity(Double.parseDouble(arg));
                break;
            case "economyClass":
                passenger.setEconomyClass(Integer.parseInt(arg));
                break;
            case "businessClass":
                passenger.setEconomyClass(Integer.parseInt(arg));
                break;
        }
    }
}
