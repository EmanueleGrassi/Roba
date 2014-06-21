package it.uniroma3.diadia.ambienti;

import java.io.FileNotFoundException;

import it.uniroma3.diadia.CaricatoreLabirinto;
import it.uniroma3.diadia.FormatoFileNonValidoException;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.personaggi.AbstractPersonaggio;
import it.uniroma3.diadia.personaggi.Strega;

public class Labirinto {
	private Stanza stanzaIniziale;
	private Stanza stanzaVincente;
	private final String MESSAGGIO_BENVENUTO = 
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	public Labirinto() {
//		creaStanze();
		CaricatoreLabirinto caricatore;
		try {
			caricatore = new CaricatoreLabirinto("lab.txt");
			try {
				caricatore.carica();
				this.stanzaIniziale = caricatore.getStanzaIniziale();
				this.stanzaVincente = caricatore.getStanzaVincente();
			} catch (FormatoFileNonValidoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	/**
	 * Restituisce il messaggio di benvenuto
	 * @return una stringa contenente il messaggio di benvenuto
	 */
	public String getMessaggioBenvenuto(){
		return this.MESSAGGIO_BENVENUTO;
	}
	
	/**
     * Crea tutte le stanze e le porte di collegamento
     */
    @SuppressWarnings("unused")
	private void creaStanze() {
		/* crea gli attrezzi */
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
		Attrezzo pc = new Attrezzo("pc",2);
		Attrezzo iPod = new Attrezzo("iPod",1);
		Attrezzo libro = new Attrezzo("libro",3);
		Attrezzo chiave = new Attrezzo("chiave",1);
		Attrezzo banco = new Attrezzo("banco",12);
		
		/* creo i personaggi */
		AbstractPersonaggio stregaMorgana = new Strega("Morgana", "La strega nera");
    	
		/* crea stanze del labirinto */
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		aulaN11.addAttrezzo(chiave);
		Stanza aulaN10 = new Stanza("Aula N10");
		aulaN10.addAttrezzo(libro);
		aulaN10.addAttrezzo(banco);
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		laboratorio.addAttrezzo(pc);
		laboratorio.setPersonaggio(stregaMorgana);
		Stanza biblioteca = new Stanza("Biblioteca");
		StanzaBloccata aulaBloccata = new StanzaBloccata("Aula N12", "est", "chiave");
		
		/* collega le stanze */
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN11.impostaStanzaAdiacente("nord", aulaBloccata);
		aulaBloccata.impostaStanzaAdiacente("sud", aulaN11);
		aulaBloccata.impostaStanzaAdiacente("est", biblioteca);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        /* pone gli attrezzi nelle stanze */
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);
		atrio.addAttrezzo(iPod);

		// il gioco comincia nell'atrio
        stanzaIniziale = atrio;  
		stanzaVincente = biblioteca;
    }
    

	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}

	public void setStanzaIniziale(Stanza stanzaIniziale) {
		this.stanzaIniziale = stanzaIniziale;
	}

	public Stanza getStanzaIniziale() {
		return this.stanzaIniziale;
	}

	public void setStanzaVincente(Stanza vincente) {
		this.stanzaVincente = vincente;
	}
}
