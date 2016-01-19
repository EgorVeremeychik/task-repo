package by.epam.training.entities.civil.transport;

import by.epam.training.entities.civil.CivilPlane;

/**
 * Created by EgorVeremeychik on 19.10.2015.
 */
public class TransportPlane extends CivilPlane {
    private boolean loader;

    public TransportPlane() {
    }

    public TransportPlane(String name, double carrying, int capacity, double fuelConsumption, double flyDistance, double luggageCapacity, boolean loader) {
        super(name, carrying, capacity, fuelConsumption, flyDistance, luggageCapacity);
        this.setLoader(loader);
    }

    public boolean isLoader() {
        return loader;
    }

    public void setLoader(boolean loader) {
        this.loader = loader;
    }

    @Override
    public int hashCode() {
        return 37 * (super.hashCode()) + 41 * (loader ? 1 : 0);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }
        TransportPlane transport = (TransportPlane) obj;
        if (!super.equals(transport)) {
            return false;
        }
        if (this.loader != transport.loader) {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getName());
        builder.append("{ capacity=");
        builder.append(super.getCapacity());
        builder.append(" carrying=");
        builder.append(super.getCarrying());
        builder.append(" flyDistance=");
        builder.append(super.getFlyDistance());
        builder.append(" fuelConsumption=");
        builder.append(super.getFuelConsumption());
        builder.append(" loader=");
        builder.append(isLoader());
        builder.append("} ");
        return builder.toString();
    }
}

