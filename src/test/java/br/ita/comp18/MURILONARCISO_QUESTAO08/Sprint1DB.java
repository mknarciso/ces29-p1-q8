package br.ita.comp18.MURILONARCISO_QUESTAO08;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.Date;



public class Sprint1DB extends Admin
{
	private static UserServer userDB = new UserServer();
	private static BlockServer blockDB = new BlockServer();
	private static BookServer bookDB = new BookServer();
	private static LoanServer loanDB = new LoanServer();
    
	public Sprint1DB(){
		super(userDB,blockDB,bookDB,loanDB);
	}

	@Test
	public void CreateUser()  {
		createUser("joao");
		assertTrue(exists("joao"));
	}
	@Test
	public void RemoveUser()  {
		createUser("joao");
		removeUser("joao");
		assertFalse(exists("joao"));
	}
	@Test
	public void BlockUser()  {
		Date today = new Date(2017,04,17);
		blockUser("joao", 3, today);
		assertTrue(blockDB.isBlocked("joao"));
		
	}
	@Test
	public void NotBlockedTryToLend() {
		blockDB.removeBlocks("joao");
		assertTrue(lendBook(357, "joao"));
	}
	@Test
	public void BlockedTryToLend() {
		Date today = new Date(2017,04,17);
		blockUser("joao", 3, today);
		assertFalse(lendBook(357, "joao"));
		
	}
}
