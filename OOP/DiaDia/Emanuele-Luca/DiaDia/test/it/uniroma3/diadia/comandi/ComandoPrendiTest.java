package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class ComandoPrendiTest {

	Partita partita;
	ComandoPrendi comando;
	int oggettiInBorsaIniziali;
	Attrezzo attrezzo;
	
	
	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.comando = new ComandoPrendi();
		this.comando.setParametro("martello");
		this.oggettiInBorsaIniziali = this.partita.getGiocatore().getBorsa().getnumAttrezzi();
		this.attrezzo = new Attrezzo("martello", 5);
		this.partita.getStanzaCorrente().addAttrezzo(attrezzo);
	}

	@Test
	public void testEseguinull() {
		this.comando.setParametro(null);
		this.comando.esegui(partita);
		assertEquals(this.oggettiInBorsaIniziali,
				this.partita.getGiocatore().getBorsa().getnumAttrezzi());
	}

	@Test
	public void testEsegui() {
		this.comando.esegui(partita);
		assertEquals((this.oggettiInBorsaIniziali + 1),
				this.partita.getGiocatore().getBorsa().getnumAttrezzi());
	}
	
	@Test
	public void testGetParametro() {
		assertEquals("martello", this.comando.getParametro());
	}

	@Test
	public void testGetNome() {
		assertEquals("questo è il comando prendi", this.comando.getNome());
	}

}
