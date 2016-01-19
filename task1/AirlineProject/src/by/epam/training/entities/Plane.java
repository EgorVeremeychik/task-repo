package by.epam.training.entities;

/**
 * Created by EgorVeremeychik on 17.10.2015.
 */
abstract public class Plane {
    private String name;
    private int capacity;
    private double carrying;
    private double fuelConsumption;
    private double flyDistance;

    public Plane() {
    }

    public Plane(String name, double carrying, int capacity, double fuelConsumption, double flyDistance) {
        this.setName(name);
        this.setCarrying(carrying);
        this.setCapacity(capacity);
        this.setFlyDistance(flyDistance);
        this.setFuelConsumption(fuelConsumption);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCarrying(double carrying) {
        this.carrying = carrying;
    }

    public double getCarrying() {
        return carrying;
    }

    public void setFlyDistance(double flyDistance) {
        this.flyDistance = flyDistance;
    }

    public double getFlyDistance() {
        return flyDistance;
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int hashCode() {
        return (int) (3 * carrying) + (int) (5 * flyDistance) + (int) (7 * fuelConsumption) + 11 * (capacity) + 13 * (name.hashCode());
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
        Plane plane = (Plane) obj;
        if (this.carrying != plane.carrying) {
            return false;
        }
        if (this.capacity != plane.capacity) {
            return false;
        }
        if (this.fuelConsumption != plane.fuelConsumption) {
            return false;
        }
        if (!this.name.equals(plane.name)) {
            return false;
        }
        if (this.flyDistance != plane.flyDistance) {
            return false;
        }
        return true;
    }

}
