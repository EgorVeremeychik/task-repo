package by.epam.training.entities.military;

import by.epam.training.entities.Plane;
import by.epam.training.enums.PurposeEnum;

/**
 * Created by EgorVeremeychik on 17.10.2015.
 */
abstract public class MilitaryPlane extends Plane {
    private PurposeEnum purpose;

    public MilitaryPlane() {
    }

    public MilitaryPlane(String name, double carrying, int capacity, double fuelConsumption, double flyDistance, PurposeEnum purpose) {
        super(name, carrying, capacity, fuelConsumption, flyDistance);
        this.purpose = purpose;
    }

    public PurposeEnum getPurpose() {
        return purpose;
    }

    public void setPurpose(PurposeEnum purpose) {
        this.purpose = purpose;
    }

    public int hashCode() {
        return 17 * (super.hashCode()) + 19 * (purpose.getValue().hashCode());
    }

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
        MilitaryPlane military = (MilitaryPlane) obj;
        if (!super.equals(military)) {
            return false;
        }
        if (this.purpose != military.purpose) {
            return false;
        }
        return true;
    }
}
