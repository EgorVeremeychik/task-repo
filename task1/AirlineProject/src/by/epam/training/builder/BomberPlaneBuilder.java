package by.epam.training.builder;

import by.epam.training.entities.Plane;
import by.epam.training.entities.military.bomber.BomberPlane;
import by.epam.training.enums.MessagesEnum;
import by.epam.training.enums.PurposeEnum;
import by.epam.training.service.util.Messages;
import org.apache.log4j.Logger;

import javax.xml.crypto.KeySelector;

/**
 * Created by EgorVeremeychik on 20.10.2015.
 */
public class BomberPlaneBuilder implements Builder {

    private static Logger LOG = Logger.getLogger(BomberPlaneBuilder.class);

    public BomberPlaneBuilder(){LOG.info(Messages.getMessage(MessagesEnum.BOMBER_PLANE_BUILDER_CALLED));}

    private BomberPlane bomber = new BomberPlane();

    public Plane getResult() {
        return bomber;
    }

    public void setArg(String name, String arg) {
        switch (name) {
            case "name":
                bomber.setName(arg);
                break;
            case "carrying":
                bomber.setCarrying(Double.parseDouble(arg));
                break;
            case "capacity":
                bomber.setCapacity(Integer.parseInt(arg));
                break;
            case "fuelConsumption":
                bomber.setFuelConsumption(Double.parseDouble(arg));
                break;
            case "flyDistance":
                bomber.setFlyDistance(Double.parseDouble(arg));
                break;
            case "luggageCapacity":
                bomber.setNumberOfBombs(Integer.parseInt(arg));
                break;
            case "purpose":
                bomber.setPurpose(PurposeEnum.BOMBER);
                break;
            case "numberOfBombs":
                bomber.setNumberOfBombs(Integer.parseInt(arg));
                break;
        }
    }
}
