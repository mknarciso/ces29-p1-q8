package br.ita.comp18.MURILONARCISO_QUESTAO08;

public class Book {
	private String _title, _author;
	private int _id;
	private BookDB _bookDB;
	public Book(String title, String author, BookDB bookDB){
		_bookDB = bookDB;
		_title = title;
		_author = author;
		_id = _bookDB.newBook(title,author);
	}
	public String getAutor() {
		return _author;
	}
	public String getTitle() {
		return _title;
	}
	public int getId() {
		return _id;
	}
}
