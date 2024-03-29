package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.Partita;

/**
 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * (Ad es. alla riga digitata dall'utente "vai nord"
 *  corrisponde un comando di nome "vai" e parametro "nord").
 *
 * @author  Paolo Merialdo (da un'idea di Michael Kolling and David J. Barnes) *
 * @version 0.1
 */

public abstract class Comando {
	
	private String parametro;
	
	/**
	 * esecuzione del comando
	 * @param partita
	 * @return TODO
	 * @return 
	 */
	public abstract String esegui(Partita partita);
	
	/**
	 * metodo per settare il parametro, usato anche se non strettamente necessario
	 * a tutti i comandi
	 */
	public void setParametro(String parametro) {
	}
	
	/**
	 * metodo per ottenere il parametro
	 * 
	 */
	public String getParametro() {
		return this.parametro;
	}
	
	/**
	 * metodo per ottenere il nome del comando
	 */
	public abstract String getNome();
}

