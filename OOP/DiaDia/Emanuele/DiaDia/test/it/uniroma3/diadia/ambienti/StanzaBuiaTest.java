package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaBuiaTest {

	StanzaBuia stanza;
	Attrezzo lanterna;
	String descrizione;
	
	@Before
	public void setUp() throws Exception {
		this.stanza = new StanzaBuia("N1", "lanterna");
		this.lanterna = new Attrezzo("lanterna", 2);
	}

	@Test
	public void testGetDescrizioneBuia() {
		assertEquals("Qui c'è buio pesto!", this.stanza.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneConOggetto() {
		this.stanza.addAttrezzo(lanterna);
		assertNotEquals("Qui c'è buio pesto!", this.stanza.getDescrizione());
	}
}
