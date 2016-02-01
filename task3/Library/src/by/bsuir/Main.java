package by.bsuir;

import by.bsuir.controller.LibraryController;
import by.bsuir.entity.Library;
import by.bsuir.util.XMLBooksReader;

public class Main {

    public static void main(String[] args) {
        Library library = Library.getInstance();
        library.setBooks(XMLBooksReader.read());
        LibraryController libraryController = new LibraryController(library);
        libraryController.start();

    }
}
