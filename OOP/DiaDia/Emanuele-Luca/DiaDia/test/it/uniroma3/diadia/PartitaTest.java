package it.uniroma3.diadia;

import static org.junit.Assert.*;
import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.giocatore.Giocatore;

import org.junit.Before;
import org.junit.Test;

public class PartitaTest {

	private Partita partita;
	private Labirinto labirinto;
	private Giocatore giocatore;
	
	@Before
	public void setUp() throws Exception {
		partita = new Partita();
		partita.setFinita();
		giocatore = new Giocatore();
		partita.setGiocatore(giocatore);
		labirinto = new Labirinto();
		partita.setLabirinto(labirinto);
	}

	@Test
	public void testIsFinita() {
		assertEquals("La partita è stata settata a finita nel setUp",true,partita.isFinita());
	}
	
	@Test
	public void testgetLabirinto(){
		assertEquals(labirinto, partita.getLabirinto());
	}
	
	@Test
	public void testgetGiocatore(){
		assertEquals(giocatore, partita.getGiocatore());
	}
}
