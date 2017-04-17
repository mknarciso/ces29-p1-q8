package br.ita.comp18.MURILONARCISO_QUESTAO08;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class Sprint3Test extends User
{
    //  create mock
    private static UserDB userDB = mock(UserDB.class);
    private static BookDB bookDB = mock(BookDB.class);
    private static LoanDB loanDB = mock(LoanDB.class);
    
	public Sprint3Test(){
		super(userDB,bookDB,loanDB);
	}
	@Test
	public void UserAccess() {
		when(userDB.loginUser("joao")).thenReturn(true);
		assertTrue(login("joao"));
		
	}

}
