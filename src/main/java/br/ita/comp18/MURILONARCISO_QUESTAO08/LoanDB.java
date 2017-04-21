package br.ita.comp18.MURILONARCISO_QUESTAO08;

import java.util.ArrayList;

public interface LoanDB {

	void newLoan(int id, String username, BookDB _bookDB);

	void removeLoan(int id, String username, BookDB _bookDB);

	boolean isLend(int bookid);

	ArrayList<Book> getListByUser(String username);
}
