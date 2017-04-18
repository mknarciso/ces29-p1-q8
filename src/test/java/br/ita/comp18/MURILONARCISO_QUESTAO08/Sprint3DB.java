package br.ita.comp18.MURILONARCISO_QUESTAO08;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class Sprint3DB extends User
{
	private static UserServer userDB = new UserServer();
    //private static UserDB userDB = mock(UserDB.class);
	private static BookServer bookDB = new BookServer();
    //private static BookDB bookDB = mock(BookDB.class);
	private static LoanServer loanDB = new LoanServer();
    //private static LoanDB loanDB = mock(LoanDB.class);
    
	public Sprint3DB(){
		super(userDB,bookDB,loanDB);
	}
	@Test
	public void UserAccess() {
		//when(userDB.loginUser("joao")).thenReturn(true);
		assertTrue(login("joao"));
		
	}
	@Test
	public void SearchBookNotAuthenticated() {
		//when(bookDB.getIdByTitle("Star Wars")).thenReturn(357);
		assertEquals(0,findTitle("Star Wars"));
	}
	@Test
	public void SearchBookAuthenticated() {
		//when(userDB.loginUser("joao")).thenReturn(true);
		//when(bookDB.getIdByTitle("Star Wars")).thenReturn(357);
		login("joao");
		assertEquals(1,findTitle("Star Wars"));
		logout();
	}
	@Test
	public void GetBookStatusDisponível() {
		//when(userDB.loginUser("joao")).thenReturn(true);
		//when(bookDB.getIdByTitle("Star Wars")).thenReturn(357);
		//when(bookDB.getStatus(357)).thenReturn(2);
		login("joao");
		assertEquals(1,findTitle("Star Wars"));
		int bookId = findTitle("Star Wars");
		loanDB.removeLoan(1, "joao", bookDB);
		assertEquals(1,bookStatus(bookId));
		assertEquals("Disponível",sBookStatus(bookId));
		logout();
	}
	@Test
	public void GetBookStatusEmprestado() {
		//when(userDB.loginUser("joao")).thenReturn(true);
		//when(bookDB.getIdByTitle("Star Wars")).thenReturn(357);
		//when(bookDB.getStatus(357)).thenReturn(2);
		login("joao");
		assertEquals(1,findTitle("Star Wars"));
		int bookId = findTitle("Star Wars");
		loanDB.newLoan(1, "joao", bookDB);
		assertEquals(2,bookStatus(bookId));
		assertEquals("Emprestado",sBookStatus(bookId));
		logout();
	}
}
