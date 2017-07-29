package com.twu.biblioteca;

import java.io.*;
import java.lang.*;
import java.util.*;

public class BibliotecaApp {
    List<Book> bookList = new ArrayList<Book>();
    List<Book> customerBooks = new ArrayList<Book>();
    private boolean running = true;

    public static void main(String[] args) {
        BibliotecaApp biblio = new BibliotecaApp();
        biblio.go();
    }

    public void go() {
        welcome();
        populateBookList();
        printMenu();
        while (running) {
            selectMenu(getInput());
        }
    }

    public void welcome() {
        System.out.println("Hello, welcome to Biblioteca!");
    }

    public void populateBookList(){
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1922);
        Book book2 = new Book("Moby Dick","Herman Melville", 1851);
        bookList.add(book1);
        bookList.add(book2);
    }

    public void printMenu(){
        System.out.println("Main Menu\n1 - List Books\n2 - Quit");
    }

    public String getInput(){
        String input = "";
        try {
            input = askUserInput();
        } catch(IOException ex) {
            System.out.println(ex.toString());
        }
        return input;
    }

    public void selectMenu(String selector) {
        if (selector.equals("1")) {
            printBookList();
        } else if (selector.equals("2")){
            quit();
        } else{
            System.out.println("Select a valid option!");
        }
    }

    public void printBookList(){
        for(Book book : bookList) {
            System.out.println(book.getTitle() + " | " + book.getAuthor() + " | " + book.getYearPublished());
        }
    }

    private String askUserInput() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String text = br.readLine();
        return text;
    }

    private void quit() {
        System.out.println("Bye!");
        running = false;
    }
}
