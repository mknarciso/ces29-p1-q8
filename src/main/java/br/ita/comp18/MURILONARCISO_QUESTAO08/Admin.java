package br.ita.comp18.MURILONARCISO_QUESTAO08;

import java.util.Date;

public class Admin {
	private UserDB _userDB;
	private BlockDB _blockDB;
	private LoanDB _loanDB;
	private BookDB _bookDB;
	public Admin(UserDB userDB, BlockDB blockDB, BookDB bookDB, LoanDB loanDB) {
		_userDB=userDB;
		_blockDB=blockDB;
		_loanDB=loanDB;
		_bookDB=bookDB;
	}
	public void createUser(String username){
		_userDB.newUser(username);
	}
	public void removeUser(String username){
		_userDB.removeUser(username);
	}
	public void blockUser(String username, int days, Date start){
		_blockDB.newBlock(username, start, days);
	}
	public int findTitle(String title){
		return _bookDB.getIdByTitle(title);
	}
	public boolean lendBook(int id, String username){
		if(_blockDB.isBlocked(username))
			return false;
		_loanDB.newLoan(id,username,_bookDB);
		return true;
	}
	public void returnBook(int id, String username){
		_loanDB.removeLoan(id,username,_bookDB);
	}
}
