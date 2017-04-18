package br.ita.comp18.MURILONARCISO_QUESTAO08;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class Sprint2DB extends Admin
{
	private static UserServer userDB = new UserServer();
    //private static UserDB userDB = mock(UserDB.class);
	private static BlockServer blockDB = new BlockServer();
    //private static BlockDB blockDB = mock(BlockDB.class);
	private static BookServer bookDB = new BookServer();
    //private static BookDB bookDB = mock(BookDB.class);
	private static LoanServer loanDB = new LoanServer();
    //private static LoanDB loanDB = mock(LoanDB.class);
    
	public Sprint2DB(){
		super(userDB,blockDB,bookDB,loanDB);
	}
	@Test
	public void AdminLendABook() {
		//when(bookDB.getIdByTitle("Star Wars")).thenReturn(357);
		//when(blockDB.isBlocked("joao")).thenReturn(false);
		blockDB.removeBlocks("joao");
		int bookId = findTitle("Star Wars");
		//System.out.print(blockDB.isBlocked("joao"));
		assertEquals(1,bookId);
		assertTrue(lendBook(bookId, "joao"));
		assertTrue(loanDB.isLend(bookId));
		//verify(loanDB, times(1)).newLoan(357,"joao",bookDB);
		
	}
	@Test
	public void AdminReturnABook() {
		blockDB.removeBlocks("joao");
		//when(bookDB.getIdByTitle("Star Wars")).thenReturn(357);
		//when(blockDB.isBlocked("joao")).thenReturn(false);
		int bookId = findTitle("Star Wars");
		returnBook(bookId,"joao");
		assertFalse(loanDB.isLend(bookId));
		
	}
}
