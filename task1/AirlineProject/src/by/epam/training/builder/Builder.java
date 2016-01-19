package by.epam.training.builder;

import by.epam.training.entities.Plane;

/**
 * Created by EgorVeremeychik on 20.10.2015.
 */
public interface Builder {
    Plane getResult();
    void setArg(String name, String arg);

}
