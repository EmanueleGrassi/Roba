package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;

public class ComandoInteragisci extends Comando {
	private String messaggio;

	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getStanzaCorrente().getPersonaggio();
		if (personaggio != null) {
			this.messaggio = personaggio.agisci(partita);
			System.out.println(this.messaggio);
		}
		else
			System.out.println("Non c'è nessuno con cui interagire qui.");
	}

	public String getMessaggio() {
		return this.messaggio;
	}

	@Override
	public String getNome() {
		return "questo è il comando interagisci";
	}
}
