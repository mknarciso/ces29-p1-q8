package br.ita.comp18.MURILONARCISO_QUESTAO08;

import java.util.Date;

public interface BlockDB {
	void newBlock(String username, Date start, int days);
	void removeBlocks(String username);
	boolean isBlocked(String username);
}
