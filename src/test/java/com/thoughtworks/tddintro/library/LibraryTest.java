package com.thoughtworks.tddintro.library;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class LibraryTest {


    /*

        List books tests. Implement the first three tests for the Verify exercise

     */

    private DateTimeFormatter dateTimeFormatter;
    private PrintStream printStream;

    @Before
    public void setUp(){
        printStream = mock(PrintStream.class);
        dateTimeFormatter = mock(DateTimeFormatter.class);
    }

    @Test
    public void shouldPrintBookTitleWhenThereIsOneBook() {
        List<String> books = new ArrayList<>();
        String title = "Book Title";
        books.add(title);
        Library library = new Library(books, printStream, dateTimeFormatter);
        library.listBooks();

        // add a verify statement here that shows that the book title was printed by to the printStream
        verify(printStream).println("Book Title");
    }

    @Test
    public void shouldPrintNothingWhenThereAreNoBooks() {
        List<String> books = new ArrayList<>();
        Library library = new Library(books, printStream, dateTimeFormatter);
        library.listBooks();
        // implement me
        verifyZeroInteractions(printStream);
    }

    @Test
    public void shouldPrintBothBookTitlesWhenThereAreTwoBooks() throws IOException {
        // implement me
        List<String> books = new ArrayList<>();
        books.add("Harry Potter");
        books.add("Lord of the Rings");
        Library library = new Library(books, printStream, dateTimeFormatter);
        library.listBooks();

        verify(printStream).println("Harry Potter");
        verify(printStream).println("Lord of the Rings");
    }

    /*

        Welcome message tests. Implement these tests for the when/thenReturn exercise

     */

    
    // This one is done for you
    @Test
    public void shouldWelcomeUser() {
        List<String> books = new ArrayList<>();
        Library library = new Library(books, printStream, dateTimeFormatter);

        // We don't need to mock DateTime because it is a value object
        // We can't mock it because it is a final class
        DateTime time = new DateTime();
        
        library.welcome(time);
        
        verify(printStream).println(contains("Welcome"));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsAnEmptyString() {
        List<String> books = new ArrayList<>();
        DateTime time = new DateTime();
        when(dateTimeFormatter.print(time)).thenReturn("");

        Library library = new Library(books, printStream, dateTimeFormatter);
        library.welcome(time);
        // add a verify here
        verify(printStream).println(endsWith(""));
    }

    @Test
    public void shouldDisplayFormattedTimeWhenFormattedTimeIsNotEmpty() {
        List<String> books = new ArrayList<>();
        DateTime time = new DateTime();
        when(dateTimeFormatter.print(time)).thenReturn("12:00 PM");

        Library library = new Library(books, printStream, dateTimeFormatter);
        library.welcome(time);
        // implement me
        // then move common test variables into a setup method
        verify(printStream).println(endsWith("12:00 PM"));

    }
}
