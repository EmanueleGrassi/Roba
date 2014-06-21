package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends Comando {

	private static String[] elencoComandi = {"vai", "aiuto", "fine", "guarda", "prendi", "posa", "interagisci", "saluta", "regala"};
	
	/**
	 * stampa la lista di comandi eseguibili
	 */
	public String esegui(Partita partita) {
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < elencoComandi.length; i++)
		{
			str.append(elencoComandi[i]);
			str.append(" ");
		}
		return str.toString();
	}
	
	public String getNome() {
		return "Questo è il comando aiuto";
	}
}
