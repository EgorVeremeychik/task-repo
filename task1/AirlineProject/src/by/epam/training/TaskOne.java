package by.epam.training;

import by.epam.training.enums.MessagesEnum;
import by.epam.training.service.util.ExceptionHandler;
import by.epam.training.service.util.Messages;
import by.epam.training.service.util.PlaneComparator;
import by.epam.training.service.PlaneController;

import java.util.logging.Logger;


public class TaskOne {

    public static void main(String[] args) {
        ExceptionHandler.start();
        PlaneController controller = new PlaneController();
        controller.createAircompany();
        controller.getCapacity();
        controller.getCarrying();
        controller.getFuelConsumption(300, 700);
        PlaneComparator planeComparator = new PlaneComparator(PlaneComparator.ItemEnum.FUEL_CONSUMPTION);
        controller.sortPlane(planeComparator);
        ExceptionHandler.end();
    }
}







