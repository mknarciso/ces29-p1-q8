package br.ita.comp18.MURILONARCISO_QUESTAO08;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Matchers.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Sprint4Mock extends User
{
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}

	@After
	public void cleanUpStreams() {
	    System.setOut(null);
	}
    //  create mock
    private static UserDB userDB = mock(UserDB.class);
    private static BookDB bookDB = mock(BookDB.class);
    private static LoanDB loanDB = mock(LoanDB.class);
    
	public Sprint4Mock(){
		super(userDB,bookDB,loanDB);
	}

	@Test
	public void GetBookStatus() {
		when(userDB.loginUser("joao")).thenReturn(true);
		//Mock id
		//int startID = 100;
		when(bookDB.newBook(anyString(),anyString())).thenReturn(100).thenReturn(101).thenReturn(102);
		//Mock DB Answer
		Book b1 = new Book("Elon Musk: Tesla, SpaceX, and the Quest for a Fantastic Future","Ashlee Vance",bookDB);
		Book b2 = new Book("Zero to One: Notes on Startups, or How to Build the Future","Peter Thiel",bookDB);
		Book b3 = new Book("The Innovators: How a Group of Hackers, Geniuses, and Geeks Created the Digital Revolution","Walter Isaacson",bookDB);
		ArrayList<Book> bookList = new ArrayList<Book>();
		bookList.add(b1);bookList.add(b2);bookList.add(b3);
		//End Mock Answer
		//Mock books status
		when(bookDB.getStatus(100)).thenReturn(4);
		when(bookDB.getStatus(101)).thenReturn(2);
		when(bookDB.getStatus(102)).thenReturn(4);
		//Mock db response
		when(loanDB.getListByUser("joao")).thenReturn(bookList);
		// Start simulation
		login("joao");
		printMyBooks();
		assertEquals("Lista de livros de joao\n"+
				"[Status]ID/Titulo/Autor\n"+
				"[ Vencido  ]100 / Elon Musk: Tesla, SpaceX, and the Quest for a Fantastic Future / Ashlee Vance\n"+
				"[Emprestado]101 / Zero to One: Notes on Startups, or How to Build the Future / Peter Thiel\n"+
				"[ Vencido  ]102 / The Innovators: How a Group of Hackers, Geniuses, and Geeks Created the Digital Revolution / Walter Isaacson\n", outContent.toString()
			);
		logout();
	}
}