package by.epam.training.builder;

import by.epam.training.entities.Plane;
import by.epam.training.entities.military.fighter.FighterPlane;
import by.epam.training.enums.MessagesEnum;
import by.epam.training.enums.PurposeEnum;
import by.epam.training.service.util.Messages;
import org.apache.log4j.Logger;

/**
 * Created by EgorVeremeychik on 20.10.2015.
 */
public class FighterPlaneBuilder implements Builder {

    private static Logger LOG = Logger.getLogger(FighterPlaneBuilder.class);

    public FighterPlaneBuilder(){LOG.info(Messages.getMessage(MessagesEnum.FIGHTER_PLANE_BUILDER_CALLED));}
    private FighterPlane fighter = new FighterPlane();

    public Plane getResult() {
        return fighter;
    }

    public void setArg(String name, String arg) {
        switch (name) {
            case "name":
                fighter.setName(arg);
                break;
            case "carrying":
                fighter.setCarrying(Double.parseDouble(arg));
                break;
            case "capacity":
                fighter.setCapacity(Integer.parseInt(arg));
                break;
            case "fuelConsumption":
                fighter.setFuelConsumption(Double.parseDouble(arg));
                break;
            case "flyDistance":
                fighter.setFlyDistance(Double.parseDouble(arg));
                break;
            case "luggageCapacity":
                fighter.setNumberOfMissiles(Integer.parseInt(arg));
                break;
            case "purpose":
                fighter.setPurpose(PurposeEnum.FIGHTER);
                break;
            case "numberOfMissiles":
                fighter.setNumberOfMissiles(Integer.parseInt(arg));
                break;
        }
    }
}
