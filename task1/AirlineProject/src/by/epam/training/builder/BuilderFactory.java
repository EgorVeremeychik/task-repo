package by.epam.training.builder;

/**
 * Created by EgorVeremeychik on 22.10.2015.
 */
public class BuilderFactory {
    public static Builder newBuilder(String name) {
        switch (name) {
            case "FighterPlane":
                return new FighterPlaneBuilder();
            case "BomberPlane":
                return new BomberPlaneBuilder();
            case "PassengerPlane":
                return new PassengerPlaneBuilder();
            case "TransportPlane":
                return new TransportPlaneBuilder();
        }
        return null;
    }
}
