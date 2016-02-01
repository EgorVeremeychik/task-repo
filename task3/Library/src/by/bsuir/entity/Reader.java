package by.bsuir.entity;

import by.bsuir.enums.ReaderStateEnum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by EgorVeremeychik on 21.01.2016.
 */
public class Reader{

    private String readerName;
    private ReaderStateEnum state;
    private List<Book> books = new ArrayList<>();
    private ReaderAction readerAction;

    public String getReaderName() {
        return readerName;
    }

    public void setReaderName(String readerName) {
        this.readerName = readerName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public ReaderStateEnum getState() {
        return state;
    }

    public void setState(ReaderStateEnum state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Reader{ " + " name " + getReaderName() + " state " + getState() + " }";
    }

    public ReaderAction getReaderAction() {
        return readerAction;
    }

    public void setReaderAction(ReaderAction readerAction) {
        this.readerAction = readerAction;
    }
}
