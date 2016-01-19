package by.epam.training.entities.military.bomber;

import by.epam.training.entities.military.MilitaryPlane;
import by.epam.training.enums.PurposeEnum;

/**
 * Created by EgorVeremeychik on 19.10.2015.
 */
public class BomberPlane extends MilitaryPlane {
    private int numberOfBombs;

    public BomberPlane() {
    }

    public BomberPlane(String name, double carrying, int capacity, double fuelConsumption, double flyDistance, PurposeEnum purpose, int numberOfBombs) {
        super(name, carrying, capacity, fuelConsumption, flyDistance, purpose);
        this.setNumberOfBombs(numberOfBombs);
    }

    public int getNumberOfBombs() {
        return numberOfBombs;
    }

    public void setNumberOfBombs(int numberOfBombs) {
        this.numberOfBombs = numberOfBombs;
    }

    @Override
    public int hashCode() {
        return 43 * super.hashCode() + 47 * numberOfBombs;
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
        BomberPlane bomber = (BomberPlane) obj;
        if (!super.equals(bomber)) {
            return false;
        }
        if (this.numberOfBombs != bomber.numberOfBombs) {
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
        builder.append(" purpose=");
        builder.append(super.getPurpose().getValue());
        builder.append(" numberOfBombs=");
        builder.append(getNumberOfBombs());
        builder.append("} ");
        return builder.toString();
    }
}
