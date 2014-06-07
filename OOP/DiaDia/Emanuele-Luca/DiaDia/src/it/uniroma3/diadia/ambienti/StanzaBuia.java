package it.uniroma3.diadia.ambienti;

public class StanzaBuia extends Stanza {

	private String oggettoPerIlluminare;
	
	public StanzaBuia(String nome, String oggettoPerIlluminare) {
		super(nome);
		this.oggettoPerIlluminare = oggettoPerIlluminare;
	}
	
	/**
	 * metodo che restituisce una stringa che descrive
	 * la stanza
	 */
	@Override
	public String getDescrizione() {
		return this.toString();
	}
	
	@Override
	public String toString() {
		if (this.hasAttrezzo(this.oggettoPerIlluminare))
			return super.toString();
		else
			return "Qui c'è buio pesto!";
	}
	
}
