package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 * 
 * @author Paolo Merialdo, Valter Crescenzi (da un'idea di Michael Kolling and
 *         David J. Barnes)
 * @see Stanza
 * @version 0.1
 */

public class Partita {
	private Giocatore giocatore;
	private Labirinto labirinto;
	private Stanza stanzaCorrente;
	private boolean finita;

	public Partita() {
		this.finita = false;
		giocatore = new Giocatore();
		labirinto = new Labirinto();
		stanzaCorrente = this.labirinto.getStanzaIniziale();
	}

	/**
	 * Restituisce il labirinto creato
	 * 
	 * @return il riferimento al labirinto istanziato
	 */
	public Labirinto getLabirinto() {
		return this.labirinto;
	}
	
	/**
	 * Cambia il labirinto creato nel costruttore
	 */
	public void setLabirinto(Labirinto l){
		this.labirinto = l;
	}
	
	/**
	 * Restituisce il giocatore
	 * 
	 * @return il riferimento al giocatore
	 */
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	
	/**
	 * Cambia il giocatore creato dal costruttore
	 */
	public void setGiocatore(Giocatore g){
		this.giocatore = g;
	}
	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * 
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.stanzaCorrente == labirinto.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * 
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (giocatore.getCfu() == 0);
	}

	/**
	 * Imposta la partita come finita
	 * 
	 */
	public void setFinita() {
		this.finita = true;
	}
	
	/**
	 * Restituisce il riferimento alla stanza corrente
	 * 
	 * @return il riferimento alla stanza corrente
	 */
	public Stanza getStanzaCorrente() {

		return this.stanzaCorrente;
	}
	
	/**
	 * Cambia la stanza vincente con una passata per parametro
	 * 
	 * @param vincente
	 *            la nuova stanza vincente
	 */
	public void setStanzaCorrente(Stanza prossimaStanza) {
		this.stanzaCorrente = prossimaStanza;
	}
}
