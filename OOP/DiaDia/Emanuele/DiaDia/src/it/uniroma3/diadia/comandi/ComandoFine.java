package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends Comando {
	
	/**
	 * TODO penso che questo metodo farà finire la partita un giorno
	 * per ora stampa e ba
	 */
	public void esegui(Partita partita) {
		System.out.println("Grazie di aver giocato!");  // si desidera smettere
	}

	public String getNome() {
		return "questo è il comando fine";
	}
}
