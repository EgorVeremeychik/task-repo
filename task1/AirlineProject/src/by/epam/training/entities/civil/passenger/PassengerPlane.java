package by.epam.training.entities.civil.passenger;

import by.epam.training.entities.civil.CivilPlane;

/**
 * Created by EgorVeremeychik on 19.10.2015.
 */
public class PassengerPlane extends CivilPlane {
    private int economyClass;
    private int businessClass;

    public PassengerPlane() {
    }

    public PassengerPlane(String name, double carrying, int capacity, double fuelConsumption, double flyDistance, double luggageCapacity, int economyClass, int businessClass) {
        super(name, carrying, capacity, fuelConsumption, flyDistance, luggageCapacity);
        this.setEconomyClass(economyClass);
        this.setBusinessClass(businessClass);
    }

    public int getEconomyClass() {
        return economyClass;
    }

    public void setEconomyClass(int economyClass) {
        this.economyClass = economyClass;
    }

    public int getBusinessClass() {
        return businessClass;
    }

    public void setBusinessClass(int businessClass) {
        this.businessClass = businessClass;
    }

    @Override
    public int hashCode() {
        return 31 * (super.hashCode()) + 34 * (economyClass) + 37 * (businessClass);
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
        PassengerPlane passenger = (PassengerPlane) obj;
        if (!super.equals(passenger)) {
            return false;
        }
        if (this.economyClass != passenger.economyClass) {
            return false;
        }
        if (this.businessClass != passenger.businessClass) {
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
        builder.append(" businessClass=");
        builder.append(getBusinessClass());
        builder.append(" economyClass=");
        builder.append(getEconomyClass());
        builder.append("} ");
        return builder.toString();
    }
}
