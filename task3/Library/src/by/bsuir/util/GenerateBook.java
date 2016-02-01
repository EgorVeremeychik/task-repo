package by.bsuir.util;

import by.bsuir.entity.Book;
import by.bsuir.entity.Library;
import by.bsuir.enums.BookPlaceEnum;
import org.apache.log4j.Logger;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by EgorVeremeychik on 24.01.2016.
 */
public class GenerateBook {
    private static Library library;

    public static Book generate(List<Book> books) {
        Random random = new Random();
        int i = random.nextInt((int) books.stream().count());
        return books.stream().skip(i).findFirst().get();
    }

    public static Book generate(BookPlaceEnum bookPlaceEnum) {
        Book book;
        Random random = new Random();
        int i = random.nextInt((int) (library.getBooks()).stream().filter(books -> books.getPlace()
                == bookPlaceEnum).count());
        book = (library.getBooks().stream().filter(books -> books.getPlace()
                == bookPlaceEnum).collect(Collectors.toList())).stream().skip(i).findFirst().get();
        return book;
    }

    public static void setLibrary(Library lib) {
        library = lib;
    }

    public static Library getLibrary() {
        return library;
    }
}
