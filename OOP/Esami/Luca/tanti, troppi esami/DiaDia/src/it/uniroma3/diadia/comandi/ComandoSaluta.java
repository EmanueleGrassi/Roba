package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoSaluta extends Comando {

	@Override
	public String esegui(Partita partita) {
		String s = "";
		if (partita.getStanzaCorrente().getPersonaggio() != null) {
			s = partita.getStanzaCorrente().getPersonaggio().saluta();
		} else 
			s = "Non c'� nessuno da salutare...";
		return s;
	}

	@Override
	public String getNome() {
		return "Questo � il comando saluta";
	}

}
