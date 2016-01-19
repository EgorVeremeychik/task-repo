package by.epam.training.service.util;

import by.epam.training.entities.Plane;

import java.util.Comparator;

/**
 * Created by EgorVeremeychik on 20.10.2015.
 */
public class PlaneComparator implements Comparator<Plane> {
    private ItemEnum sortingItem;

    public PlaneComparator(ItemEnum sortingItem) {
            setSortingItem(sortingItem);
    }

    public void setSortingItem(ItemEnum sortingItem) {
        this.sortingItem = sortingItem;
    }

    public ItemEnum getSortingItem() {
        return sortingItem;
    }

    @Override
    public int compare(Plane planeOne, Plane planeTwo) {
        switch (sortingItem) {
            case FLY_DISTANCE:
                double flyDistanceOne = planeOne.getFlyDistance();
                double flyDistanceTwo = planeTwo.getFlyDistance();
                if (flyDistanceOne > flyDistanceTwo) {
                    return 1;
                }
                if (flyDistanceOne < flyDistanceTwo) {
                    return -1;
                }
                return 0;
            case FUEL_CONSUMPTION:
                double fuelConsumptionOne = planeOne.getFuelConsumption();
                double fuelConsumptionTwo = planeTwo.getFuelConsumption();
                if (fuelConsumptionOne < fuelConsumptionTwo) {
                    return 1;
                }
                if (fuelConsumptionOne > fuelConsumptionTwo) {
                    return -1;
                }
                return 0;
            default:
                return 0;
        }
    }

    public enum ItemEnum {
        FLY_DISTANCE, FUEL_CONSUMPTION;
    }
}
