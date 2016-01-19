package by.epam.training;

import by.epam.training.service.util.PlaneComparator;
import by.epam.training.service.PlaneController;

public class TaskOne {
    public static void main(String[] args) {

        PlaneController controller = new PlaneController();
        controller.createAircompany();
        controller.getCapacity();
        controller.getCarrying();
        controller.getFuelConsumption(300, 700);
        controller.sortPlane(new PlaneComparator(PlaneComparator.ItemEnum.FUEL_CONSUMPTION));


    }


}







