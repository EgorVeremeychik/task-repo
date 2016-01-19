package by.epam.training.entities;

import java.util.ArrayList;

/**
 * Created by EgorVeremeychik on 17.10.2015.
 */
public class Aircompany {
    private ArrayList<Plane> planes;

    public Aircompany() {
        planes = new ArrayList<Plane>();
    }

    public void add(Plane plane) {
        planes.add(plane);
    }

    public ArrayList<Plane> getPlanes() {
        return planes;
    }

    public void setPlanes(ArrayList<Plane> planes) {
        this.planes = planes;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        int i = 1;
        for (Plane plane : planes) {
            hash = (i++) * plane.hashCode();
        }
        return hash;
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
        Aircompany aircompany = (Aircompany) obj;
        if (this.planes != aircompany.planes) {
            if (this.planes == null) {
                return false;
            }
        }
        if (!this.planes.equals(aircompany.planes)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getClass().getName());
        builder.append("{ plane={");
        for (Plane plane : planes) {
            builder.append(plane.toString());
        }
        builder.append("}} ");
        return builder.toString();
    }
}
