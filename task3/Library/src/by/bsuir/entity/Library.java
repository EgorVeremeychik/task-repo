package by.bsuir.entity;

import by.bsuir.util.ExceptionHandler;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by EgorVeremeychik on 21.01.2016.
 */

public class Library implements Runnable {

    private List<Book> books = new ArrayList<>();
    private List<Reader> readers = new ArrayList<>();
    private Logger LOG = Logger.getLogger(Library.class);
    private static AtomicBoolean created = new AtomicBoolean();
    private static ReentrantLock libraryInstanceLock = new ReentrantLock();
    private static volatile Library instance = null;
    private ExecutorService readersExecuter;

    public static Library getInstance() {
        if (!created.get()) {
            libraryInstanceLock.lock();
            try {
                if (instance == null) {
                    instance = new Library();
                    created.set(true);
                }
            } finally {
                libraryInstanceLock.unlock();
            }
        }
        return instance;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void setReaders(List<Reader> readers) {
        this.readers = readers;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Book book : this.getBooks()) {
            result.append(book.toString());
            result.append("\n");
        }
        return result.toString();
    }

    @Override
    public void run() {
        try {
            Random random = new Random();
            readersExecuter = Executors.newCachedThreadPool();
            for (Reader reader : readers) {
                if(ReaderAction.isAlive()) {
                    TimeUnit.SECONDS.sleep(random.nextInt(1));
                    readersExecuter.execute(reader.getReaderAction());
                }else {
                    break;
                }
            }
        } catch (InterruptedException e) {
            ExceptionHandler.handle(e);
        } catch (Exception e) {
            ExceptionHandler.handle(e);
        }
    }

    public ExecutorService getReadersExecuter() {
        return readersExecuter;
    }
}
