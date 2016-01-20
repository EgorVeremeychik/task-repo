package by.epam.training.enums;

/**
 * Created by EgorVeremeychik on 20.01.2016.
 */
public enum  MessagesEnum {
    PROJECT_START("project.start"),
    PROJECT_END("project.end"),
    VALIDATE_FAIL("validate.fail"),
    CREATE_AIRCOMPANY("create.aircompany"),
    FIGHTER_PLANE_BUILDER_CALLED("fighter.plane.builder.called"),
    PASSENGER_PLANE_BUILDER_CALLED("passenger.plane.builder.called"),
    TRANSPORT_PLANE_BUILDER_CALLED("transport.plane.builder.called"),
    BOMBER_PLANE_BUILDER_CALLED("bomber.plane.builder.called"),
    GET_ALL_CAPACITY("get.all.capacity.called"),
    GET_ALL_CARRYING("get.all.carrying.called"),
    SORT_PLANE("sort.plane"),
    GET_FUEL_CONSUMPTION("get.fuel.consumption");

    String value;

    MessagesEnum(String key) {
        this.value = key;
    }

    public String getValue(){
        return this.value;
    }
}
