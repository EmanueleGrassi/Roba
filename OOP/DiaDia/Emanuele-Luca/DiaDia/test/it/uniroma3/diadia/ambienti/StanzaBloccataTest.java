package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaBloccataTest {

	StanzaBloccata stanza;
	Stanza sud;
	
	@Before
	public void setUp() throws Exception {
		this.stanza = new StanzaBloccata("N1", "sud", "chiave");
		sud =  new Stanza("N2");
		this.stanza.impostaStanzaAdiacente("sud",sud);
	}

	@Test
	public void testGetStanzaAdiacente() {
		assertEquals(null, this.stanza.getStanzaAdiacente("sud"));
	}
	
	@Test
	public void testGetStanzaAdiacenteConOggetto() {
		this.stanza.addAttrezzo(new Attrezzo("chiave",1));
		assertEquals(sud, this.stanza.getStanzaAdiacente("sud"));
	}
}
