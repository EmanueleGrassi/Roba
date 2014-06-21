package it.uniroma3.diadia.personaggi;

import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Cane extends AbstractPersonaggio {

	private static final int DANNI_BASE = 1;
	private static final String MESSAGGIO_MORSO = "Ahi! Il cane ti ha morso e hai perso CFU!";
	private static final String CIBO_PREFERITO = "osso";
	private static final Attrezzo ATTREZZO_REGALO = new Attrezzo("Palla",1);
	private int danni;
	private String ciboPreferito;
	private Attrezzo attrezzoRegalo;
	
	public Cane(String nome, String presentaz) {
		super(nome, presentaz);
		this.danni = DANNI_BASE;
		this.ciboPreferito = CIBO_PREFERITO;
		this.attrezzoRegalo = ATTREZZO_REGALO;
	}
	
	public Cane(String nome, String presentaz, int danni, String ciboPreferito, String nomeRegalo, int pesoRegalo) {
		super(nome, presentaz);
		this.danni = danni;
		this.ciboPreferito = ciboPreferito;
		this.attrezzoRegalo = new Attrezzo(nomeRegalo, pesoRegalo);
	}

	@Override
	public String agisci(Partita partita) {
		partita.getGiocatore().setCfu(partita.getGiocatore().getCfu()-danni);
		return MESSAGGIO_MORSO;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		String s = "";
		if(attrezzoRegalo==null)
			return "Al cane è piaciuto il regalo ma non ha lasciato nulla";
		if (attrezzo.getNome().equals(this.ciboPreferito)) {
			partita.getStanzaCorrente().addAttrezzo(this.attrezzoRegalo);
			this.attrezzoRegalo = null;
			s = "Al cane è piaciuto il regalo ed ha lasciato un oggetto nella stanza.";
		}
		else {
			partita.getStanzaCorrente().addAttrezzo(attrezzo);
			s = "Al cane non è piaciuto il tuo regalo e l'ha gettato a terra";
		}
		return s;
	}
	
	

}
