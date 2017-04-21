package br.ita.comp18.MURILONARCISO_QUESTAO08;

import java.util.ArrayList;

public class User {
	private UserDB _userDB;
	private LoanDB _loanDB;
	private BookDB _bookDB;
	private String _username;
	private boolean authenticate;
	private BlockDB _blockDB;
	public User(UserDB userDB, BookDB bookDB, LoanDB loanDB) {
		_userDB=userDB;
		_loanDB=loanDB;
		_bookDB=bookDB;
		authenticate = false;
	}
	public User(UserDB userDB, BookDB bookDB, LoanDB loanDB, BlockDB blockDB) {
		_userDB=userDB;
		_loanDB=loanDB;
		_bookDB=bookDB;
		_blockDB=blockDB;
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
			case 4:
				return " Vencido  ";
		}
		return "Erro!";
	}
	
	public void printMyBooks(){
		ArrayList<Book> myBooks = _loanDB.getListByUser(_username);
		System.out.println("Lista de livros de "+_username);
		System.out.println("[Status]ID/Titulo/Autor");
		for(int i=0;i<myBooks.size();i++){
			Book atual = myBooks.get(i);
			System.out.println("["+sBookStatus(atual.getId())+"]"+
						atual.getId()+" / "+
						atual.getTitle()+" / "+
						atual.getAutor()
					);
		}
	}
	public int getMyStatus(){
		if(_blockDB.isBlocked(_username))
				return _blockDB.getBlockType(_username);
		return 0;
	}
	
	public String sMyStatus(){
		int status = getMyStatus();
		switch (status){
			case 0:
				return "Sem Restrições";
			case 1:
				return "Bloqueado por atraso";
			case 2:
				return "Bloqueado por cobrança";
		}
		return "Erro!";
	}
}
