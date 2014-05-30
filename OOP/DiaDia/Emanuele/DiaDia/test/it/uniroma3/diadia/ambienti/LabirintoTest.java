package it.uniroma3.diadia.ambienti;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;

import org.junit.Before;
import org.junit.Test;

public class LabirintoTest {

	Labirinto labirinto;
	Stanza biblioteca;
	
	@Before
	public void setUp() throws Exception {
		labirinto = new Labirinto();
		biblioteca = new Stanza("Biblioteca");
		labirinto.setStanzaVincente(biblioteca);
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals(biblioteca, labirinto.getStanzaVincente());
	}
}
