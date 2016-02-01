package by.bsuir.enums;

/**
 * Created by EgorVeremeychik on 21.01.2016.
 */
public enum  BookPlaceEnum {
    ONHAND("OnHand"),
    INREADINGROOM("InReadingRoom");

    private String value;

    BookPlaceEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
