package by.epam.training.entities.military.fighter;

import by.epam.training.entities.Plane;
import by.epam.training.entities.military.MilitaryPlane;
import by.epam.training.enums.PurposeEnum;

/**
 * Created by EgorVeremeychik on 19.10.2015.
 */
public class FighterPlane extends MilitaryPlane {
    private int numberOfMissiles;

    public FighterPlane() {
    }

    public FighterPlane(String name, double carrying, int capacity, double fuelConsumption, double flyDistance, PurposeEnum purpose, int numberOfMissiles) {
        super(name, carrying, capacity, fuelConsumption, flyDistance, purpose);
        this.setNumberOfMissiles(numberOfMissiles);
    }

    public int getNumberOfMissiles() {
        return numberOfMissiles;
    }

    public void setNumberOfMissiles(int numberOfMissiles) {
        this.numberOfMissiles = numberOfMissiles;
    }

    @Override
    public int hashCode() {
        return 49 * super.hashCode() + 51 * numberOfMissiles;
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
        FighterPlane fighter = (FighterPlane) obj;
        if (!super.equals(fighter)) {
            return false;
        }
        if (this.numberOfMissiles != fighter.numberOfMissiles) {
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
        builder.append(" numberOfMissiles=");
        builder.append(getNumberOfMissiles());
        builder.append("} ");
        return builder.toString();
    }
}
