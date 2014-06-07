package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

import org.junit.Before;
import org.junit.Test;

public class BorsaTest {

	Borsa borsa;
	Attrezzo martello;
	
	@Before
	public void setUp() throws Exception {
		this.borsa = new Borsa();
		this.martello = new Attrezzo("Martello", 2);
		this.borsa.addAttrezzo(martello);
	}

	@Test
	public void testGetPesoMax() {
		assertEquals(10, borsa.getPesoMax());
	}

	@Test
	public void testGetAttrezzo() {
		assertEquals(martello, borsa.getAttrezzo("Martello"));
	}

	@Test
	public void testIsEmpty() {
		assertEquals(false,borsa.isEmpty());
	}

	@Test
	public void testHasAttrezzo() {
		assertEquals(true, borsa.hasAttrezzo("Martello"));
	}
}
