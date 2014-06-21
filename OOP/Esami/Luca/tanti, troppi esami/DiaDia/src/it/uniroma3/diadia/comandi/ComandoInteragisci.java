package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisci extends Comando {
	private String messaggio;

	public String esegui(Partita partita) {
		String s = "";
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		if (personaggio != null) {
			this.messaggio = personaggio.agisci(partita);
			s = this.messaggio;
		}
		else
			s = "Non c'è nessuno con cui interagire qui.";
		return s;
	}

	public String getMessaggio() {
		return this.messaggio;
	}

	@Override
	public String getNome() {
		return "questo è il comando interagisci";
	}
}
