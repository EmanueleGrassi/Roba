package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;
import it.uniroma3.diadia.giocatore.Giocatore;

import org.junit.Before;
import org.junit.Test;

public class GiocatoreTest {

	Giocatore giocatore;
	Borsa borsa;
	
	@Before
	public void setUp() throws Exception {
		giocatore = new Giocatore();
		borsa = new Borsa();
		giocatore.setCfu(25);
		giocatore.setBorsa(borsa);
	}

	@Test
	public void testGetCfu() {
		assertEquals(25, giocatore.getCfu());
	}
	
	@Test
	public void testgetBorsa(){
		assertEquals(borsa, giocatore.getBorsa());
	}
}
