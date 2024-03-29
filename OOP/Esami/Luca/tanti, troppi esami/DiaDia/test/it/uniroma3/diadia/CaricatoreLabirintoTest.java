package it.uniroma3.diadia;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CaricatoreLabirintoTest {

	private CaricatoreLabirinto caricatoreMonolocale;
	
	@Before
	public void setUp() throws Exception {
		this.caricatoreMonolocale = new CaricatoreLabirinto("lab.txt");
		this.caricatoreMonolocale.carica();
	}

	@Test
	public void testCarica() {
		assertEquals("N10", this.caricatoreMonolocale.getStanzaIniziale().getStanzaAdiacente("est").getNome());
	}

	@Test
	public void testGetStanzaIniziale() {
		assertEquals("Atrio", this.caricatoreMonolocale.getStanzaIniziale().getNome());
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals("N11", this.caricatoreMonolocale.getStanzaVincente().getNome());
	}

}
