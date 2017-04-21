package br.ita.comp18.MURILONARCISO_QUESTAO08;

import static org.junit.Assert.*;

import org.junit.Test;

public class Sprint3DB extends User
{
	private static UserServer userDB = new UserServer();
	private static BookServer bookDB = new BookServer();
	private static LoanServer loanDB = new LoanServer();
    
	public Sprint3DB(){
		super(userDB,bookDB,loanDB);
	}
	@Test
	public void UserAccess() {
		assertTrue(login("joao"));
		
	}
	@Test
	public void SearchBookNotAuthenticated() {
		assertEquals(0,findTitle("Star Wars"));
	}
	@Test
	public void SearchBookAuthenticated() {
		login("joao");
		assertEquals(1,findTitle("Star Wars"));
		logout();
	}
	@Test
	public void GetBookStatusDisponível() {
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
		login("joao");
		assertEquals(1,findTitle("Star Wars"));
		int bookId = findTitle("Star Wars");
		loanDB.newLoan(1, "joao", bookDB);
		assertEquals(2,bookStatus(bookId));
		assertEquals("Emprestado",sBookStatus(bookId));
		logout();
	}
}
