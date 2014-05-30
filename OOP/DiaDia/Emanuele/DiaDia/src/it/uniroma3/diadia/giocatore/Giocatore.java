package it.uniroma3.diadia.giocatore;

public class Giocatore {
	
	private Borsa borsa;
	private int cfu;
	private static int CFU_INIZIALI = 20;
	
	public Giocatore(){
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}
	/**
	 * metodo che ottiene il numero di cfu del giocatore
	 * @return il numero di cfu del giocatore
	 */
	public int getCfu() {
		return this.cfu;
	}

	/**
	 * Cambia i cfu del giocatore
	 * @param un intero
	 */
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}
	
	/**
	 * Restituisce la borsa del giocatore
	 * @return il riferimento alla borsa
	 */
	public Borsa getBorsa() {
		return borsa;
	}

	/**
	 * Cambia la borsa del giocatore
	 * @param un'istanza di Borsa
	 */
	public void setBorsa(Borsa borsa) {
		this.borsa = borsa;
	}
	
	/**
	 * ritorna un booleano, true se il giocatore ha ancora cfu a disposizione
	 */
	public boolean giocatoreIsVivo(){
		return this.cfu > 0;
	}
}
