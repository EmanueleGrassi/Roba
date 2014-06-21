package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

import org.junit.Before;
import org.junit.Test;

public class ComandoPosaTest {

	Partita partita;
	ComandoPosa comando;
	int oggettiInBorsaIniziali;
	Attrezzo attrezzo;
	Stanza stanza;
	
	@Before
	public void setUp() throws Exception {
		this.partita = new Partita();
		this.comando = new ComandoPosa();
		this.comando.setParametro("martello");
		this.attrezzo = new Attrezzo("martello", 5);
		this.partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		this.oggettiInBorsaIniziali = this.partita.getGiocatore().getBorsa().getnumAttrezzi();
		this.stanza = this.partita.getStanzaCorrente();
	}

	@Test
	public void testEseguinull() {
		this.comando.setParametro(null);
		this.comando.esegui(partita);
		assertEquals("gli oggetti nella borsa sono gli stessi",
				this.oggettiInBorsaIniziali, 
				this.partita.getGiocatore().getBorsa().getnumAttrezzi());
	}
	public void testEsegui() {
		this.comando.esegui(partita);
		assertEquals("gli oggetti sono diminuiti",
				(this.oggettiInBorsaIniziali - 1),
				this.partita.getGiocatore().getBorsa().getnumAttrezzi());
		assertEquals(true,this.stanza.hasAttrezzo(this.attrezzo.getNome()));
	}

	@Test
	public void testGetParametro() {
		assertEquals("martello", this.comando.getParametro());
	}

	@Test
	public void testGetNome() {
		assertEquals("questo è il comando posa", this.comando.getNome());
	}

}
