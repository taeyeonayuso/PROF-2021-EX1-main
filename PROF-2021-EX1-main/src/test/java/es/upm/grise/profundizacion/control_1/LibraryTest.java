package es.upm.grise.profundizacion.control_1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryTest {
	Library library;
	Book book1;
	Book book2;
	
	@BeforeEach
	void setUp() {
		library = new Library();
		book1 = new Book("Title1");
		book2 = new Book("Title2");
	}
	@Test
	void testAddBook() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		library.addBook(book1);
		assertEquals(book1, library.getBook("Title1"));
	}
	@Test 
	void testAddBook2() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		library.addBook(book1);
		assertThrows(DuplicatedBookException.class, () -> library.addBook(book1));
	}
	@Test
	void testRemoveBook() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		library.addBook(book1);
		library.addBook(book2);
		library.removeBook(book1);
		assertThrows(NonExistingBookException.class, () -> library.getBook("Title1"));
	}
	@Test
	void testRemoveBook2() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		library.addBook(book1);
		library.removeBook(book1);
		assertThrows(EmptyLibraryException.class, () -> library.getBook("Title1"));
	}

	@Test
	void testGetBook() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		library.addBook(book1);
		assertEquals(book1, library.getBook("Title1"));
	}
	@Test
	void testGetBook2() throws DuplicatedBookException, NonExistingBookException, EmptyLibraryException {
		library.addBook(book2);
		assertThrows(NonExistingBookException.class, () -> library.getBook("Title1"));
	}



}
