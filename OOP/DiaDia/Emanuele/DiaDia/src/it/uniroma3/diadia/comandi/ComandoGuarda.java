package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

public class ComandoGuarda extends Comando {
	
	public void esegui(Partita partita) {
		System.out.println(partita.getStanzaCorrente().getDescrizione());
	}

	public String getNome() {
		return "questo è il comando guarda";
	}

}
