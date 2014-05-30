package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FabbricaDiComandiSempliceTest {

	FabbricaDiComandiSemplice factory;
	Comando posa, prendi;
	
	@Before
	public void setUp() throws Exception {
		factory = new FabbricaDiComandiSemplice();
		posa = factory.costruisciComando("posa");
		prendi = factory.costruisciComando("prendi");
		prendi.setParametro("occhiali");
	}

	@Test
	public void testCostruisciComandoPosa() {
		assertEquals("questo è il comando posa", posa.getNome());
	}
	
	@Test
	public void testCostruisciComandoPrendi() {
		assertEquals("questo è il comando prendi", prendi.getNome());
		assertEquals("occhiali", prendi.getParametro());
	}

}
