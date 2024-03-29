package it.uniroma3.diadia;

import static org.junit.Assert.*;

import java.io.StringReader;

import org.junit.Before;
import org.junit.Test;

public class CaricatoreLabirintoTest {

	private StringReader monolocale;
	private CaricatoreLabirinto caricatoreMonolocale;
	
	@Before
	public void setUp() throws Exception {
		this.monolocale = new StringReader("Stanze: biblioteca\nInizio: biblioteca\nVincente: biblioteca\nAttrezzi: libro 1 biblioteca\nUscite: ");
		this.caricatoreMonolocale = new CaricatoreLabirinto(this.monolocale);
		this.caricatoreMonolocale.carica();
	}

	@Test
	public void testGetStanzaIniziale() {
		assertEquals("biblioteca", this.caricatoreMonolocale.getStanzaIniziale().getNome());
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals("biblioteca", this.caricatoreMonolocale.getStanzaVincente().getNome());
	}

}
