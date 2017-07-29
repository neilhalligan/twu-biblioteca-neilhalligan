package com.twu.biblioteca;

import org.junit.*;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import java.io.*;
import java.util.*;
import static org.junit.Assert.*;

public class BibliotecaAppTest {
    private ByteArrayOutputStream outContent;
    private BibliotecaApp biblioteca;

    @Before
    public void setUp() throws Exception {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        biblioteca = new BibliotecaApp();
    }

    @Test
    public void printsWelcomeMessage() throws Exception {
        biblioteca.welcome();
        String expectedOutput  = "Hello, welcome to Biblioteca!\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void hasBookList() throws Exception {
        List<Book> mockBookList = new ArrayList<Book>();
        assertEquals(mockBookList, biblioteca.bookList);
    }

    @Test
    public void populateBookList() throws Exception {
        biblioteca.populateBookList();
        Book testBook1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1922);
        Book testBook2 = new Book("Moby Dick","Herman Melville", 1851);
        assertEquals(testBook1, biblioteca.bookList.get(0));
        assertEquals(testBook2, biblioteca.bookList.get(1));
    }

    @Test
    public void printBookList() throws Exception {
        biblioteca.populateBookList();
        biblioteca.printBookList();
        String book1 = "The Great Gatsby | F. Scott Fitzgerald | 1922\n";
        String book2 = "Moby Dick | Herman Melville | 1851\n";
        String expectedOutput  = book1 + book2;
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void printMenu() throws Exception {
        biblioteca.printMenu();
        String expectedOutput  = "Main Menu\n1 - List Books\n2 - Quit\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void selectMenu() throws Exception {
        biblioteca.populateBookList();
        String expectedOutput = "Select a valid option!\n";
        biblioteca.selectMenu("0");
        for(Book book : biblioteca.bookList) {
            expectedOutput += book.getTitle() + " | " + book.getAuthor() + " | " + book.getYearPublished() + "\n";
        }
        biblioteca.selectMenu("1");
        expectedOutput += "Bye!\n";
        biblioteca.selectMenu("2");
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    public void hasCustomerBooks() throws Exception {
        List<Book> testCustomerBooks = new ArrayList<Book>();
        assertEquals(biblioteca.customerBooks, testCustomerBooks);
    }

    @Test
    public void addToCustomerBooks() throws Exception {
        biblioteca.addToCustomerBooks
//                customerBooks.add(new Book("The Great Gatsby", "F. Scott Fitzgerald", 1922));

    }
}
