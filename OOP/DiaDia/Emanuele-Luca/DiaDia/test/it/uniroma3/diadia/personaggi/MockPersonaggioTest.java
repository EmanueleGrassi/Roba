package it.uniroma3.diadia.personaggi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;

import org.junit.Before;
import org.junit.Test;

public class MockPersonaggioTest {

	AbstractPersonaggio personaggio;
	Partita partita;
	
	@Before
	public void setUp() throws Exception {
		this.personaggio = new MockPersonaggio("Mock", "sono un mock");
		this.partita = new Partita();
	}

	@Test
	public void testAgisci() {
		assertEquals("done", this.personaggio.agisci(this.partita));
	}

}
