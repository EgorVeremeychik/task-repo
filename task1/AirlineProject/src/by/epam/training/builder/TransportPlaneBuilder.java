package by.epam.training.builder;

import by.epam.training.entities.Plane;
import by.epam.training.entities.civil.transport.TransportPlane;
import by.epam.training.enums.MessagesEnum;
import by.epam.training.service.util.Messages;
import org.apache.log4j.Logger;

/**
 * Created by EgorVeremeychik on 20.10.2015.
 */
public class TransportPlaneBuilder implements Builder {

    private static Logger LOG = Logger.getLogger(TransportPlaneBuilder.class);

    public TransportPlaneBuilder(){LOG.info(Messages.getMessage(MessagesEnum.TRANSPORT_PLANE_BUILDER_CALLED));}

    private TransportPlane transport = new TransportPlane();

    public Plane getResult() {
        return transport;
    }

    public void setArg(String name, String arg) {
        switch (name) {
            case "name":
                transport.setName(arg);
                break;
            case "carrying":
                transport.setCarrying(Double.parseDouble(arg));
                break;
            case "capacity":
                transport.setCapacity(Integer.parseInt(arg));
                break;
            case "fuelConsumption":
                transport.setFuelConsumption(Double.parseDouble(arg));
                break;
            case "flyDistance":
                transport.setFlyDistance(Double.parseDouble(arg));
                break;
            case "luggageCapacity":
                transport.setLuggageCapacity(Double.parseDouble(arg));
                break;
            case "loader":
                transport.setLoader(Boolean.parseBoolean(arg));
                break;
        }
    }
}