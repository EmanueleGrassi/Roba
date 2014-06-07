package it.uniroma3.diadia.personaggi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Strega extends AbstractPersonaggio {

	private final static String MSG_BUONO = "Ehi! Tu sei simpatico! Guarda dove ti porto!";
	private final static String MSG_CATTIVO = "Come osi parlarmi così!?!? Verrai punito!";
	private final static String RISATA = "Povero sciocco! AHAHAHA";
	
	private Stanza stanzaConPochiOggetti, stanzaConMoltiOggetti;
	private List<Attrezzo> attrezzi;
	
	public Strega(String nome, String presentaz) {
		super(nome, presentaz);
		this.attrezzi = new ArrayList<>();
	}

	@Override
	public String agisci(Partita partita) {
		setStanzaConPochiOggetti(partita);
		setStanzaConMoltiOggetti(partita);
		String msg = "";
		if (this.haSalutato()) {
			msg = MSG_BUONO;
			partita.setStanzaCorrente(this.stanzaConMoltiOggetti);
		}
		else {
			msg = MSG_CATTIVO;
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
		Stanza valoreRitorno = iterator.next();
		int max = valoreRitorno.getAttrezzi().length;
		while (iterator.hasNext()) {
			Stanza tmp = iterator.next();
			if (tmp.getAttrezzi().length > max)
				valoreRitorno = tmp;
		}
		return valoreRitorno;
	}


	private Stanza minOggetti(Collection<Stanza> values) {
		Iterator<Stanza> iterator = values.iterator();
		Stanza valoreRitorno = iterator.next();
		int min = valoreRitorno.getAttrezzi().length;
		while (iterator.hasNext()) {
			Stanza tmp = iterator.next();
			if (tmp.getAttrezzi().length < min)
				valoreRitorno = tmp;
		}
		return valoreRitorno;
	}


	private void setStanzaConPochiOggetti(Partita partita) {
		Stanza destinazione = minOggetti(partita.getStanzaCorrente().getStanzeAdiacenti().values());
		this.stanzaConPochiOggetti = destinazione;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		this.attrezzi.add(attrezzo);
		return RISATA;
	}

}
