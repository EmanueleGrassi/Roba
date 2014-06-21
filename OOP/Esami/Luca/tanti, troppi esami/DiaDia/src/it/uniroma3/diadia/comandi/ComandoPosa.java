package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPosa extends Comando {

	String oggettoDaPosare;
	
	/*
	 * se è stato inserito un parametro corretto questo metodo posa l'oggetto
	 * @see it.uniroma3.diadia.comandi.Comando#esegui(it.uniroma3.diadia.Partita)
	 */
	public String esegui(Partita partita) {
		String s = "";
		if (oggettoDaPosare == null)
			s = "Quale attrezzo vuoi posare?";
		if (partita.getGiocatore().getBorsa().getAttrezzo(oggettoDaPosare) != null) {
			Attrezzo temp = partita.getGiocatore().getBorsa().removeAttrezzo(
					oggettoDaPosare);
			partita.getStanzaCorrente().addAttrezzo(temp);
			s = "Oggetto posato. Cosa vuoi fare ora?";
			return s;
		}
		s = "Oggetto non trovato nella borsa. Cosa vuoi fare ora?";
		return s;
	}

	@Override
	public void setParametro(String parametro) {
		this.oggettoDaPosare = parametro;
	}
	
	@Override
	public String getParametro() {
		return this.oggettoDaPosare;
	}

	public String getNome() {
		return "questo è il comando posa";
	}

}
