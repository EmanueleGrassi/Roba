package it.uniroma3.diadia.attrezzi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class AttrezzoTest {

	private Attrezzo attrezzo;
	
	@Before
	public void setUp() throws Exception {
		attrezzo = new Attrezzo("Martello", 2);
	}

	@Test
	public void testGetNome() {
		assertEquals("Martello", attrezzo.getNome());
	}

	@Test
	public void testGetPeso() {
		assertEquals(2, attrezzo.getPeso());
	}

	@Test
	public void testToString() {
		assertEquals("Martello (2kg)", attrezzo.toString());
	}

}
