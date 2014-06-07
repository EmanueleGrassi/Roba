package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends Comando {
	
	public String esegui(Partita partita) {
		return partita.getStanzaCorrente().getDescrizione();
	}

	public String getNome() {
		return "questo è il comando guarda";
	}

}
