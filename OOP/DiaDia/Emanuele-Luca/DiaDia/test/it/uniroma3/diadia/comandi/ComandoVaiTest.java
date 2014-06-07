package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

import org.junit.Before;
import org.junit.Test;

public class ComandoVaiTest {

	Partita partita;
	Stanza stanzaCorrente;
	ComandoVai comando;
	int CFUattuali;
	
	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.stanzaCorrente = this.partita.getStanzaCorrente();
		this.comando = new ComandoVai();
		this.comando.setParametro("nord");
		this.CFUattuali = this.partita.getGiocatore().getCfu();
	}

	/**
	 * non posso determinare se il giocatore si è mosso o meno(anche perchè
	 * non è garantito) quindi controllo che i cfu diminuiscano.
	 */
	@Test
	public void testEsegui() {
		this.comando.esegui(partita);
		assertEquals((CFUattuali-1), this.partita.getGiocatore().getCfu());
	}

	@Test
	public void testGetParametro() {
		assertEquals("nord", this.comando.getParametro());
	}

	@Test
	public void testGetNome() {
		assertEquals("questo è il comando vai", this.comando.getNome());
	}

}
