package br.ita.comp18.MURILONARCISO_QUESTAO08;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;



public class Sprint1DB extends Admin
{
    //  create mock
	private static UserServer userDB = new UserServer();
    //private static UserDB userDB = mock(UserDB.class);
    private static BlockDB blockDB = mock(BlockDB.class);
    private static BookDB bookDB = mock(BookDB.class);
    private static LoanDB loanDB = mock(LoanDB.class);
    
	public Sprint1DB(){
		super(userDB,blockDB,bookDB,loanDB);
	}

	@Test
	public void CreateUser()  {
		createUser("joao");
		assertTrue(exists("joao"));
		//verify(userDB, times(1)).newUser("joao");
	}
	@Test
	public void RemoveUser()  {
		createUser("joao");
		removeUser("joao");
		assertFalse(exists("joao"));
		//verify(userDB, times(1)).removeUser("joao");
	}
	/*@Test
	public void BlockUser()  {
		Date today = new Date(2017,04,17);
		blockUser("joao", 3, today);
		verify(blockDB, times(1)).newBlock("joao",today,3);
	}
	@Test
	public void NotBlockedTryToLend() {
		when(blockDB.isBlocked("joao")).thenReturn(false);
		assertTrue(lendBook(357, "joao"));
	}
	@Test
	public void BlockedTryToLend() {
		when(blockDB.isBlocked("joao")).thenReturn(true);
		assertFalse(lendBook(357, "joao"));
		
	}*/
}
