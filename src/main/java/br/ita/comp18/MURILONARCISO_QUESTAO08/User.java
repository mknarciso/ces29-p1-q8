package br.ita.comp18.MURILONARCISO_QUESTAO08;

public class User {
	private UserDB _userDB;
	private LoanDB _loanDB;
	private BookDB _bookDB;
	private String _username;
	private boolean authenticate;
	public User(UserDB userDB, BookDB bookDB, LoanDB loanDB) {
		_userDB=userDB;
		_loanDB=loanDB;
		_bookDB=bookDB;
		authenticate = false;
		_username="";
	}
	public boolean login(String username){
		if(_userDB.loginUser(username)){
			_username = username;
			authenticate = true;
			return true;
		}
		return false;
			
	}
	
}
