package br.ita.comp18.MURILONARCISO_QUESTAO08;

public interface UserDB {
	void newUser(String username);
	void removeUser(String username);
	boolean loginUser(String username);
}
