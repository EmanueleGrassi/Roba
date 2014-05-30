package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoAiuto extends Comando {

	private static String[] elencoComandi = {"vai", "aiuto", "fine", "guarda", "prendi", "posa", "interagisci"};
	
	/**
	 * stampa la lista di comandi eseguibili
	 */
	public void esegui(Partita partita) {
		for (int i = 0; i < elencoComandi.length; i++)
			System.out.print(elencoComandi[i] + " ");
		System.out.println();
	}
	
	public String getNome() {
		return "questo è il comando aiuto";
	}

}
