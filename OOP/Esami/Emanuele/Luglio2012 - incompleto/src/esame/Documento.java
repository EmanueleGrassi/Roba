package esame;

import java.util.HashMap;

public class Documento extends Archivio {
	private int dimensione;
	
	public Documento(String nome, int dimensione, String dataCreazione, PermessoAccesso permessoAccesso) {
		this.setNome(nome);
		this.dimensione = dimensione;
		this.setDataCreazione(dataCreazione);
		setPermessi(new HashMap<String, PermessoAccesso>());
		this.getPermessi().put(permessoAccesso.getNome(), permessoAccesso);
	}
	
	@Override
	public int getDimensione() {
		return this.dimensione;
	}

	/**
	 * @param dimensione the dimensione to set
	 */
	public void setDimensione(int dimensione) {
		this.dimensione = dimensione;
	}
}
