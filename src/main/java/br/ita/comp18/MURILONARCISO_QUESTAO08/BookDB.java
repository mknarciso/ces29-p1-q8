package br.ita.comp18.MURILONARCISO_QUESTAO08;

public interface BookDB {

	int newBook(String title, String autor);
	int getIdByTitle(String title);
	int getStatus(int bookId); // 1-Disponível // 2-Emprestado // 3-Extraviado
}
