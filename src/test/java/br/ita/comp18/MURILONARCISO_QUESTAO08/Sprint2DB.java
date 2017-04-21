package br.ita.comp18.MURILONARCISO_QUESTAO08;

import static org.junit.Assert.*;

import org.junit.Test;

public class Sprint2DB extends Admin
{
	private static UserServer userDB = new UserServer();
	private static BlockServer blockDB = new BlockServer();
	private static BookServer bookDB = new BookServer();
	private static LoanServer loanDB = new LoanServer();
    
	public Sprint2DB(){
		super(userDB,blockDB,bookDB,loanDB);
	}
	@Test
	public void AdminLendABook() {
		blockDB.removeBlocks("joao");
		int bookId = findTitle("Star Wars");
		assertEquals(1,bookId);
		assertTrue(lendBook(bookId, "joao"));
		assertTrue(loanDB.isLend(bookId));
		
	}
	@Test
	public void AdminReturnABook() {
		blockDB.removeBlocks("joao");
		int bookId = findTitle("Star Wars");
		returnBook(bookId,"joao");
		assertFalse(loanDB.isLend(bookId));
		
	}
}
