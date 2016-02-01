package by.bsuir.entity;

import by.bsuir.enums.BookPlaceEnum;

/**
 * Created by EgorVeremeychik on 21.01.2016.
 */
public class Book {
    private String bookName;
    public BookPlaceEnum place;

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public BookPlaceEnum getPlace() {
        return place;
    }

    public void setPlace(BookPlaceEnum place) {
        this.place = place;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        result.append(this.getClass().getSimpleName()).append(": [");
        result.append("name=").append(this.getBookName()).append(", ");
        result.append("place=").append(this.getPlace().getValue());
        result.append("]");
        return result.toString();
    }

}
