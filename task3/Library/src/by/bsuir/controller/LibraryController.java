package by.bsuir.controller;

import by.bsuir.entity.Book;
import by.bsuir.entity.Library;
import by.bsuir.entity.Reader;
import by.bsuir.entity.ReaderAction;
import by.bsuir.enums.MessagesEnum;
import by.bsuir.util.ExceptionHandler;
import by.bsuir.util.GenerateBook;
import by.bsuir.util.Messages;
import by.bsuir.util.XMLReadersReader;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by EgorVeremeychik on 22.01.2016.
 */
public class LibraryController {
    private static Library library;
    private ExecutorService libraryExecutor;
    private static final Logger LOG = Logger.getLogger(LibraryController.class);

    static {
        new DOMConfigurator().doConfigure("log4j.xml", LogManager.getLoggerRepository());
    }

    public LibraryController(Library library) {
        this.setLibrary(library);
        GenerateBook.setLibrary(library);
    }

    public void start() {
        try {
            LOG.info(Messages.getMessage(MessagesEnum.LIBRARY_START_WORK));
            libraryExecutor = Executors.newSingleThreadExecutor();
            library.setReaders(XMLReadersReader.read());
            System.out.println(Messages.getMessage(MessagesEnum.LIBRARY_START_WORK));
            libraryExecutor.execute(library);
            ReaderAction.setIsAlive(true);
            System.out.print(Messages.getMessage(MessagesEnum.PROCESSING));
            for (int i = 0; i < 15; i++) {
                System.out.print(".");
                TimeUnit.SECONDS.sleep(1);
            }
            System.out.println();
            ReaderAction.setIsAlive(false);
            LOG.info(Messages.getMessage(MessagesEnum.LIBRARY_STOPED_GIVE_BOOKS));
            System.out.println(Messages.getMessage(MessagesEnum.LIBRARY_STOPED_GIVE_BOOKS));
            library.getReadersExecuter().shutdown();
            if (!library.getReadersExecuter().awaitTermination(5, TimeUnit.SECONDS)) {
                library.getReadersExecuter().shutdownNow();
            }
            System.out.println(Messages.getMessage(MessagesEnum.LIBRARY_END_WORK));
            LOG.info(Messages.getMessage(MessagesEnum.LIBRARY_END_WORK));
            libraryExecutor.shutdownNow();
        } catch (InterruptedException e) {
            ExceptionHandler.handle(e);
        } catch (Exception e) {
            ExceptionHandler.handle(e);
        }
    }

    public static void setLibrary(Library lib) {
        library = lib;
    }

    public static void takeHome(Reader reader, Book book) {
        reader.addBook(book);
        LOG.info(Thread.currentThread().getName() + reader.getBooks());
        library.getBooks().remove(book);
        LOG.info(Messages.getMessage(MessagesEnum.LIBRARY) + library.getBooks());
    }

    public static void takeInReadingRoom(Reader reader, Book book) {
        reader.addBook(book);
        LOG.info(Thread.currentThread().getName() + reader.getBooks());
        library.getBooks().remove(book);
        LOG.info(Messages.getMessage(MessagesEnum.LIBRARY) + library.getBooks());
    }

    public static void returnBook(Reader reader, Book book) {
        library.addBook(book);
        LOG.info(Messages.getMessage(MessagesEnum.LIBRARY) + library.getBooks());
        reader.getBooks().remove(book);
        LOG.info(Thread.currentThread().getName() + reader.getBooks());
    }

}
