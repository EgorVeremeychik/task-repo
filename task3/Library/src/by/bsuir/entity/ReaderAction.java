package by.bsuir.entity;

import by.bsuir.controller.LibraryController;
import by.bsuir.enums.BookPlaceEnum;
import by.bsuir.util.ExceptionHandler;
import by.bsuir.util.GenerateBook;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * Created by EgorVeremeychik on 31.01.2016.
 */
public class ReaderAction implements Runnable {

    private Reader reader;
    private static volatile boolean isAlive = false;
    private static ReentrantLock lock = new ReentrantLock();
    private static final Logger LOG = Logger.getLogger(Reader.class);

    public ReaderAction(Reader reader) {
        this.setReader(reader);
    }

    public void returnBook() {
        try {
            lock.lock();
            LOG.info(Thread.currentThread().getName() + " return book");
            LibraryController.returnBook(reader, GenerateBook.generate(reader.getBooks()));
            LOG.info(Thread.currentThread().getName() + " leave library!");
        } finally {
            lock.unlock();
        }
    }

    public void returnAllBooks() {
        try {
            lock.lock();
            List<Book> books = reader.getBooks().stream().filter(book -> book.getPlace()
                    == BookPlaceEnum.INREADINGROOM).collect(Collectors.toList());
            for (Book book : books)
                LibraryController.returnBook(reader, GenerateBook.generate(reader.getBooks()));
            LOG.info(Thread.currentThread().getName() + " return all books for readingRoom and leave library!");
        } finally {
            lock.unlock();
        }
    }

    public void read(){
        try {
            TimeUnit.SECONDS.sleep(5);
            returnAllBooks();
        } catch (InterruptedException e) {
            ExceptionHandler.handle(e);
        }
    }

    public void takeBook(int countBooks) {
        try {
            lock.lock();
            LOG.info(Thread.currentThread().getName() + " take book");
            int variant;
            Random random = new Random();
            while (countBooks > 0) {
                variant = random.nextInt(2);
                if (variant == 0) {
                    processTakeBookHome();
                } else {
                    processTakeBookReadingRoom();
                }
                countBooks--;
            }
            if ((reader.getBooks().stream().filter(books -> books.getPlace()
                    == BookPlaceEnum.INREADINGROOM)).count() == 0) {
                LOG.info(Thread.currentThread().getName() + " leave library!");
            }else{
                LOG.info(Thread.currentThread().getName() + " went to read!");
            }
        }finally {
            lock.unlock();
        }
    }

    public void processTakeBookHome() {
        if (((GenerateBook.getLibrary().getBooks().stream().filter(books -> books.getPlace()
                == BookPlaceEnum.ONHAND)).count()) != 0) {
            LibraryController.takeHome(reader, GenerateBook.generate(BookPlaceEnum.ONHAND));
        } else {
            LOG.info(Thread.currentThread().getName() + " takes a book, that is missing");
        }
    }

    public void processTakeBookReadingRoom() {
        if (((GenerateBook.getLibrary().getBooks().stream().filter(books -> books.getPlace()
                == BookPlaceEnum.INREADINGROOM)).count()) != 0) {
            LibraryController.takeInReadingRoom(reader, GenerateBook.generate(BookPlaceEnum.INREADINGROOM));
        } else {
            LOG.info(Thread.currentThread().getName() + " takes a book, that is missing");
        }
    }

    public void returnAndTake(int countBooks) {
        try {
            lock.lock();
            LOG.info(Thread.currentThread().getName() + " return and take book");
            LibraryController.returnBook(reader, GenerateBook.generate(reader.getBooks()));
            takeBook(countBooks);
        } finally {
            lock.unlock();
        }

    }

    @Override
    public void run() {
        try {
            Thread.currentThread().setName(reader.getReaderName());
            Random random = new Random();
            int variant;
            int countBooks = random.nextInt(3) + 1;
            while (ReaderAction.isAlive()) {
                if (Thread.currentThread().interrupted())
                    break;
                variant = random.nextInt(3);
                LOG.info(Thread.currentThread().getName() + " came to the library!");
                switch (variant) {
                    case 0:
                        takeBook(countBooks);
                        break;
                    case 1:
                        if (reader.getBooks().isEmpty()) {
                            takeBook(countBooks);
                            break;
                        }
                        returnBook();
                        break;
                    case 2:
                        if (reader.getBooks().isEmpty()) {
                            takeBook(countBooks);
                            break;
                        }
                        returnAndTake(countBooks);
                        break;
                }
                if ((reader.getBooks().stream().filter(books -> books.getPlace()
                        == BookPlaceEnum.INREADINGROOM)).count() != 0) {
                    read();
                }
                TimeUnit.SECONDS.sleep(10);
            }
        } catch (InterruptedException e) {
            ExceptionHandler.handle(e);
        } catch (Exception e) {
            ExceptionHandler.handle(e);
        }
    }

    public static boolean isAlive() {
        return isAlive;
    }

    public static void setIsAlive(boolean isAlive) {
        ReaderAction.isAlive = isAlive;
    }

    public void setReader(Reader reader) {
        this.reader = reader;
    }
}
