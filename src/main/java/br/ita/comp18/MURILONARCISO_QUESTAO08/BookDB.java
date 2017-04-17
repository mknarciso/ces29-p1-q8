package br.ita.comp18.MURILONARCISO_QUESTAO08;

public interface BookDB {

	int newBook(String title, String autor);
	int getIdByTitle(String title);
}
