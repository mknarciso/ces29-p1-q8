package br.ita.comp18.MURILONARCISO_QUESTAO08;

public interface LoanDB {

	void newLoan(int id, String username, BookDB _bookDB);

	void removeLoan(int id, String username, BookDB _bookDB);

	boolean isLend(int bookid);

}
