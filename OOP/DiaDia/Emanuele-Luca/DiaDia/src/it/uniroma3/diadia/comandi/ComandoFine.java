package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoFine extends Comando {

	public String esegui(Partita partita) {
		return "Grazie di aver giocato!";  // si desidera smettere
	}

	public String getNome() {
		return "questo è il comando fine";
	}
}
