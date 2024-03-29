package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends Comando {

	private static String[] elencoComandi = {"vai", "aiuto", "fine", "guarda", "prendi", "posa", "interagisci", "saluta", "regala"};
	
	/**
	 * stampa la lista di comandi eseguibili
	 */
	public String esegui(Partita partita) {
		String s = "";
		for (int i = 0; i < elencoComandi.length; i++)
			s += elencoComandi[i] + " ";
		return s;
	}
	
	public String getNome() {
		return "questo � il comando aiuto";
	}

}
