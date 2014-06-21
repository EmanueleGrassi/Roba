package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVai extends Comando {

	private String direzione;

	/**
	 * sposta il giocatore nella stanza selezionata
	 * @see it.uniroma3.diadia.comandi.Comando#esegui(it.uniroma3.diadia.Partita)
	 */
	public String esegui(Partita partita) {
		String s = "";
		Stanza prossimaStanza = null;
		if (direzione == null) {
			s = "Dove vuoi andare? Devi specificare una direzione";
		}
		else {
			prossimaStanza = partita.getStanzaCorrente().getStanzaAdiacente(this.direzione);
			if (prossimaStanza == null) {
				s = "Direzione inesistente";
			}
			else {
				partita.setStanzaCorrente(prossimaStanza);
				s = partita.getStanzaCorrente().getNome();
				//System.out.println(partita.getStanzaCorrente().getDescrizione());
				partita.getGiocatore().setCfu(partita.getGiocatore().getCfu() - 1);				
			}
		}
		return s;		
	}

	@Override
	public void setParametro(String parametro) {
		this.direzione = parametro;
	}
	
	@Override
	public String getParametro() {
		return this.direzione;
	}

	public String getNome() {
		return "questo è il comando vai";
	}
}
