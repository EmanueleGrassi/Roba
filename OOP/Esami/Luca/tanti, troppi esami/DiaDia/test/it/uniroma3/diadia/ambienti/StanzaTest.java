package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class StanzaTest {

	private Stanza stanza;
	private Attrezzo martello, scala, forbici;
	
	@Before
	public void setUp() throws Exception {
		stanza = new Stanza("Cortile");
		martello = new Attrezzo("Martello", 2);
		stanza.addAttrezzo(martello);
		scala = new Attrezzo("Scala", 5);
		stanza.addAttrezzo(scala);
		forbici = new Attrezzo("Forbici",1);
		stanza.addAttrezzo(forbici);
	}

	@Test
	public void testGetAttrezzo(){
		assertEquals(martello, stanza.getAttrezzo("Martello"));
	}

	@Test
	public void testHasAttrezzo() {
		assertEquals(true, stanza.hasAttrezzo("Forbici"));
	}
	
	@Test
	public void testgetDescrizione(){
		System.out.print(stanza.getDescrizione());
		assertEquals("Nome Stanza corrente: Cortile \nUscite: \nAttrezzi nella stanza: [Martello, Scala, Forbici]", stanza.getDescrizione());
	}

}
