package it.uniroma3.diadia.personaggi;

import java.util.Collection;
import java.util.Iterator;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class Strega extends AbstractPersonaggio {

	private Stanza stanzaConPochiOggetti, stanzaConMoltiOggetti;
	
	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
	}

	@Override
	public String agisci(Partita partita) {
		setStanzaConPochiOggetti(partita);
		setStanzaConMoltiOggetti(partita);
		String msg = "";
		if (this.haSalutato()) {
			msg = "Ehi! Tu sei simpatico! Guarda dove ti porto!";
			partita.setStanzaCorrente(this.stanzaConMoltiOggetti);
		}
		else {
			msg = "Come osi parlarmi così!?!? Verrai punito!";
			partita.setStanzaCorrente(this.stanzaConPochiOggetti);
		}
		msg += "\n" + partita.getStanzaCorrente().getDescrizione();
		return msg;
	}


	private void setStanzaConMoltiOggetti(Partita partita) {
		Stanza destinazione = maxOggetti(partita.getStanzaCorrente().getStanzeAdiacenti().values());
		this.stanzaConMoltiOggetti = destinazione;
	}


	private Stanza maxOggetti(Collection<Stanza> values) {
		Iterator<Stanza> iterator = values.iterator();
		int max = iterator.next().getAttrezzi().length;
		Stanza valoreRitorno = iterator.next();
		while (iterator.hasNext()) {
			if (iterator.next().getAttrezzi().length > max)
				valoreRitorno = iterator.next();
			iterator.next();
		}
		return valoreRitorno;
	}


	private Stanza minOggetti(Collection<Stanza> values) {
		Iterator<Stanza> iterator = values.iterator();
		int min = iterator.next().getAttrezzi().length;
		Stanza valoreRitorno = iterator.next();
		while (iterator.hasNext()) {
			if (iterator.next().getAttrezzi().length < min)
				valoreRitorno = iterator.next();
			iterator.next();
		}
		return valoreRitorno;
	}


	private void setStanzaConPochiOggetti(Partita partita) {
		Stanza destinazione = minOggetti(partita.getStanzaCorrente().getStanzeAdiacenti().values());
		this.stanzaConPochiOggetti = destinazione;
	}

}
