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
	}
	public boolean login(String username){
		if(_userDB.loginUser(username)){
			_username = username;
			authenticate = true;
			return true;
		}
		return false;
			
	}
	public void logout(){
		authenticate = false;
	}
	public int findTitle(String title){
		if (authenticate)
			return _bookDB.getIdByTitle(title);
		else 
			return 0;
	}
	public int bookStatus(int bookId){
		if (authenticate)
			return _bookDB.getStatus(bookId);
		else 
			return 0;
	}
	public String sBookStatus(int bookId){
		int status = bookStatus(bookId);
		switch (status){
			case 0:
				return "Não autenticado";
			case 1:
				return "Disponível";
			case 2:
				return "Emprestado";
			case 3:
				return "Extraviado";
		}
		return "Erro!";
	}
}
