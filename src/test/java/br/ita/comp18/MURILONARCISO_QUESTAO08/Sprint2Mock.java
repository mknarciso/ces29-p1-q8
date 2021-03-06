package br.ita.comp18.MURILONARCISO_QUESTAO08;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class Sprint2Mock extends Admin
{
    //  create mock
    private static UserDB userDB = mock(UserDB.class);
    private static BlockDB blockDB = mock(BlockDB.class);
    private static BookDB bookDB = mock(BookDB.class);
    private static LoanDB loanDB = mock(LoanDB.class);
    
	public Sprint2Mock(){
		super(userDB,blockDB,bookDB,loanDB);
	}
	@Test
	public void AdminLendABook() {
		when(bookDB.getIdByTitle("Star Wars")).thenReturn(357);
		when(blockDB.isBlocked("joao")).thenReturn(false);
		int bookId = findTitle("Star Wars");
		assertTrue(lendBook(bookId, "joao"));
		verify(loanDB, times(1)).newLoan(357,"joao",bookDB);
		
	}
	@Test
	public void AdminReturnABook() {
		when(bookDB.getIdByTitle("Star Wars")).thenReturn(357);
		when(blockDB.isBlocked("joao")).thenReturn(false);
		int bookId = findTitle("Star Wars");
		returnBook(bookId,"joao");
		verify(loanDB, times(1)).removeLoan(357,"joao",bookDB);
		
	}
}
